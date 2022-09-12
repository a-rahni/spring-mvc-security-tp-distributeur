package fr.m2i.spring.lesson.mvc.service;

import fr.m2i.spring.lesson.mvc.model.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    void addBalance(User user, Double balance);

    void decreaseBalance(User user, Double balance);

    public List<User> findAll();

    User findById(Long id);

    User findByEmail(String email);

    User save(User user);

    public void delete(User user);
}
