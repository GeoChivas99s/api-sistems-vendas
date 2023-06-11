package org.geoChivas99s.rest.controler;

import lombok.RequiredArgsConstructor;
import org.geoChivas99s.domain.entity.Users;
import org.geoChivas99s.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImp userServiceImp;
    @Autowired
  private PasswordEncoder passwordEncoder;

    @PostMapping
    public Users saveUser(@RequestBody Users user){
        user.setSenha(passwordEncoder.encode(user.getSenha()));
 return userServiceImp.saveUser(user);

    }

    @GetMapping
    public Iterable<Users> getUsers(){
        return userServiceImp.getAll();
    }

}
