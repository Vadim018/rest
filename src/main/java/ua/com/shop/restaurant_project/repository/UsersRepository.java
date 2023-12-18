package ua.com.shop.restaurant_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.restaurant_project.entity.Users;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long>
{
    List<Users> findAllByUsernameAndPassword(String username, String pass);
    Users findByUsernameAndPassword(String user, String pass);
}