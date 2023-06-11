package org.geoChivas99s.service.impl;

import org.geoChivas99s.domain.entity.Users;
import org.geoChivas99s.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserDetailsService {


    @Autowired
   private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Users user = userRepository.findByLogin(s).orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado!!"));
      String [] roles = user.isAdmin() ? new String[]{"ADMIN","USER"} : new String[]{"USER"};

        return User.builder().username(user.getLogin())
                .password(user.getSenha())
                .roles(roles).build();
    }


    @Transactional
    public Users saveUser(Users user){
   return   userRepository.save(user);
    }

    public Iterable<Users> getAll(){
        return userRepository.findAll();
    }

}
