package com.simard.adopteunmonstre.controllers;

import com.simard.adopteunmonstre.mappers.UserMapper;
import com.simard.adopteunmonstre.model.entities.dto.user.UserDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserLoginEmailDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserLoginUserNameDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserSignInDto;
import com.simard.adopteunmonstre.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> createUser(@RequestBody UserSignInDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserDto(this.userService.createUser(UserMapper.toUser(user))));
    }

    @PostMapping("/login/email")
    public ResponseEntity<Boolean> loginWithEmail(@RequestBody UserLoginEmailDto user) {
        return ResponseEntity.ok(this.userService.loginWithEmail(user));
    }

    @PostMapping("/login/username")
    public ResponseEntity<Boolean> loginWithUserName(@RequestBody UserLoginUserNameDto user) {
        return ResponseEntity.ok(this.userService.loginWithUserName(user));
    }
}
