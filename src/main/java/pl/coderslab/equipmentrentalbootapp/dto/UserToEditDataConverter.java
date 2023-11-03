package pl.coderslab.equipmentrentalbootapp.dto;

import org.springframework.stereotype.Component;
import pl.coderslab.equipmentrentalbootapp.entity.User;

@Component
public class UserToEditDataConverter implements BaseConverter<User, UserToEditDataDto> {

    @Override
    public UserToEditDataDto convert(User from) {
        UserToEditDataDto user = new UserToEditDataDto();
        user.setFirstName(from.getFirstName());
        user.setLastName(from.getLastName());
        user.setAddress(from.getAddress());
        return user;
    }
}