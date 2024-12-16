package ait.lesson10.shop_javapro.repository;

import ait.lesson10.shop_javapro.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Optional<Role> findRoleByTitle(String title);
}
