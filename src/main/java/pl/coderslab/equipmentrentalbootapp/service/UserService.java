package pl.coderslab.equipmentrentalbootapp.service;

import pl.coderslab.equipmentrentalbootapp.entity.User;

public interface UserService {
    User findByUsername(String name);

    void saveUser(User user);
}
