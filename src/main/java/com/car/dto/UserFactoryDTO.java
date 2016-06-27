package com.car.dto;

import com.car.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserFactoryDTO
{
    public Users CutCode (UserDTO userDTO)
    {
        Users users = new Users();
        users.setLogin(userDTO.getLogin());
        users.setPassword(userDTO.getPassword());
        users.setEmail(userDTO.getEmail());
        users.setFirstName(userDTO.getFirstName());
        users.setLastName(userDTO.getLastName());
        return users;
    }

    public String CutUser (UserDTO userDTO)
    {
        return userDTO.getSecretCode();
    }

    public Users FindUser (UserAuDTO userAuDTO)
    {
        Users users = new Users();
        users.setLogin(userAuDTO.getLogin());
        users.setPassword(userAuDTO.getPassword());
        users.setEmail("vlad-aizen@yandex.by");
        users.setFirstName("Vlad");
        users.setLastName("Hrytsuk");
        return users;
    }
}

