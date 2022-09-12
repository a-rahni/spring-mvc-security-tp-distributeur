package fr.m2i.spring.lesson.mvc.service;

import fr.m2i.spring.lesson.mvc.model.Role;
import java.util.List;

public interface IRoleService {

    List<Role> findAll();
}
