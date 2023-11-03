package pl.coderslab.equipmentrentalbootapp.service;

import pl.coderslab.equipmentrentalbootapp.dto.UserToEditDataDto;
import pl.coderslab.equipmentrentalbootapp.entity.User;

public interface UserService {
    User findByUsername(String name);
    User findByEmail(String email);

    void saveUser(User user);

    void updateUser(User user);

    UserToEditDataDto convert(User user);
}
