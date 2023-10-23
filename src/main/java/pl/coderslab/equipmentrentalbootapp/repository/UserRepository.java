package pl.coderslab.equipmentrentalbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.equipmentrentalbootapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
