package org.geoChivas99s;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
//injeção de dependencias usando o bean
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;
// usando variável global dentro de um arquivo de configurations
    @Value("${application.name}")
    private String Teste;



    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName + Teste ;
    }
    public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    }
}