
package fr.m2i.spring.lesson.mvc.repository;

import fr.m2i.spring.lesson.mvc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
