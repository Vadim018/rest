package ua.com.shop.restaurant_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.restaurant_project.entity.Users;
import java.util.List;
public interface UserRepository extends JpaRepository<Users, Long>
{
    List<Users> findAllByUsername(String name);
    Users findByUsername(String name);
}