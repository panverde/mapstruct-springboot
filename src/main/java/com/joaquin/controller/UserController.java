package com.joaquin.controller;

import com.joaquin.dto.FlattenUserDTO;
import com.joaquin.dto.UserDTO;
import com.joaquin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<List<UserDTO>>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/flattenList", method = RequestMethod.GET)
    public ResponseEntity<List<FlattenUserDTO>> getFlattenUsers() {
        return new ResponseEntity<List<FlattenUserDTO>>(userService.getFlattenUsers(), HttpStatus.OK);
    }

}
