package org.geoChivas99s.config;

import org.geoChivas99s.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImp userServiceImp;
@Bean
   public PasswordEncoder passwordEncoder(){
      return  new BCryptPasswordEncoder();
   }
    // Para resolver os mambos de auternticação dos usuários
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(userServiceImp)
          .passwordEncoder(passwordEncoder());
    }


    //Para validação as autorizações , acesso a q e tals
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/clientes/**")
                .hasRole("USER")
                .antMatchers("/api/products/**")
                .hasRole("ADMIN")
                .antMatchers("/api/pedidos/**")
                .hasRole("USER")
                .antMatchers("/api/cargos/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/colaboradores/**")
                .hasRole("USER")
                .and()
                .httpBasic();
    }
}
