package com.simard.adopteunmonstre.mappers;

import com.simard.adopteunmonstre.model.entities.User;
import com.simard.adopteunmonstre.model.entities.dto.user.UserDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserLoginEmailDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserLoginUserNameDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserSignInDto;


public class UserMapper {
    private UserMapper() {
        // Constructeur privé pour empêcher l'instanciation de la classe
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static User toUser(UserSignInDto signInDto) {
        User user = new User();
        user.setUsername(signInDto.getUsername());
        user.setEmail(signInDto.getEmail());
        user.setPassword(signInDto.getPassword());
        return user;
    }

    public static User toUserFromLoginEmailDto(UserLoginEmailDto loginEmailDto) {
        User user = new User();
        user.setEmail(loginEmailDto.getEmail());
        user.setPassword(loginEmailDto.getPassword());
        return user;
    }

    public static User toUserFromUserLoginUsernameDto(UserLoginUserNameDto loginUserNameDto) {
        User user = new User();
        user.setUsername(loginUserNameDto.getUsername());
        user.setPassword(loginUserNameDto.getPassword());
        return user;
    }

}
