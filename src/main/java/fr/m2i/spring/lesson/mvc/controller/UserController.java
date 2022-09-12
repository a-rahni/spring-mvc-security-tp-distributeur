package fr.m2i.spring.lesson.mvc.controller;

import fr.m2i.spring.lesson.mvc.form.UserForm;
import fr.m2i.spring.lesson.mvc.model.Role;
import fr.m2i.spring.lesson.mvc.model.User;
import fr.m2i.spring.lesson.mvc.service.IRoleService;
import fr.m2i.spring.lesson.mvc.service.IUserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class UserController {

    private final IUserService userService;
    private final IRoleService roleService;

    @Autowired
    public UserController(IUserService userService, IRoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping({"/", "/users"})
    public String showUsersPage(ModelMap model) {
        return "admin/users";
    }

    @GetMapping("/addUser")
    public String showAddUserPage(ModelMap model) {
        return "admin/save-user";
    }

    @GetMapping(value = "/updateUser")
    public String showUpdateUser(@RequestParam("id") Long id, ModelMap model) {

        if (id == null || id < 1) {
            model.addAttribute("error", "Veuillez entrer un id utilisateur valide");
            return "admin/users";
        }

        User user = userService.findById(id);

        if (user == null) {
            model.addAttribute("error", "Le utilisateur n'existe pas");
            return "admin/users";
        }

        UserForm userForm = new UserForm();
        userForm.setId(id);
        userForm.setEmail(user.getEmail());
        userForm.setFirstName(user.getFirstName());
        userForm.setLastName(user.getLastName());
        userForm.setBalance(user.getBalance());

        model.put("userForm", userForm);

        return "admin/save-user";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") Long id, ModelMap model) {

        if (id == null || id < 1) {
            model.addAttribute("error", "Veuillez entrer un id utilisateur valide");
            return "admin/users";
        }

        User user = userService.findById(id);

        if (user == null) {
            model.addAttribute("error", "Le utilisateur n'existe pas");
            return "admin/users";
        }

        try {
            userService.delete(user);
        } catch (Exception e) {
            model.addAttribute("error", "Une erreur est survenue lors de la suppression de l'utilisateur");
            return "admin/users";
        }

        return "redirect:/admin/users";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@Valid UserForm userForm,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "admin/save-user";
        }

        saveUserFromForm(userForm);

        return "redirect:/admin/users";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid UserForm userForm,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "admin/save-user";
        }

        saveUserFromForm(userForm);

        return "redirect:/admin/users";
    }

    @ModelAttribute("users")
    public List<User> addUsers() {
        return userService.findAll();
    }

    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }

    @ModelAttribute("roles")
    public List<Role> addRoles() {
        return roleService.findAll();
    }

    private void saveUserFromForm(UserForm userForm) {
        User user = new User();
        user.setId(userForm.getId());
        user.setEmail(userForm.getEmail());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setBalance(userForm.getBalance());
        user.setPassword(userForm.getPassword());
        user.setRole(new Role(userForm.getRole().getId()));

        userService.save(user);
    }
}
