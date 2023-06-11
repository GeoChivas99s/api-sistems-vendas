package org.geoChivas99s.rest.controler;

import lombok.RequiredArgsConstructor;
import org.geoChivas99s.JwtService;
import org.geoChivas99s.domain.entity.Users;
import org.geoChivas99s.rest.dto.CredentialDTO;
import org.geoChivas99s.rest.dto.TokenDTO;
import org.geoChivas99s.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImp userServiceImp;
    @Autowired
  private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;
    @PostMapping
    public Users saveUser(@RequestBody Users user){
        user.setSenha(passwordEncoder.encode(user.getSenha()));
 return userServiceImp.saveUser(user);

    }

    @GetMapping
    public Iterable<Users> getUsers(){
        return userServiceImp.getAll();
    }

    @PostMapping("/auth")
public TokenDTO authUser(@RequestBody CredentialDTO credentialDTO){

        try {

            Users autenticatedUser = Users.builder().login(credentialDTO.getLogin())
                    .senha(credentialDTO.getSenha()).build();

         UserDetails userDetails = userServiceImp.autenticate(autenticatedUser);


        String token = jwtService.generateToken(autenticatedUser);
return new TokenDTO(autenticatedUser.getLogin(), token);

        }catch (UsernameNotFoundException e){
   throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
        }

    }
}
