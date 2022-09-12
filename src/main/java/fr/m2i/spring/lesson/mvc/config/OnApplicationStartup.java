package fr.m2i.spring.lesson.mvc.config;

import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.model.Role;
import fr.m2i.spring.lesson.mvc.model.User;
import fr.m2i.spring.lesson.mvc.repository.RoleRepository;
import fr.m2i.spring.lesson.mvc.service.IProductService;
import fr.m2i.spring.lesson.mvc.service.IUserService;
import java.util.Arrays;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnApplicationStartup implements InitializingBean {

    private final RoleRepository roleRepository;
    private final IUserService userService;
    private final IProductService productService;

    @Autowired
    public OnApplicationStartup(RoleRepository roleRepository, IUserService userService,
            IProductService productService) {

        this.roleRepository = roleRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Role roleAdmin = new Role("ADMIN");
        Role roleProvider = new Role("PROVIDER");
        Role roleCustomer = new Role("CUSTOMER");

        roleRepository.saveAll(Arrays.asList(roleAdmin, roleProvider, roleCustomer));

        User admin = new User("admin", "admin", "admin@admin.com", "admin", new Role(1L));

        userService.save(admin);

        productService.save(new Product("café", 1d, 5));
        productService.save(new Product("soda", 2d, 5));
        productService.save(new Product("barre céréales", 3d, 5));
    }
}
