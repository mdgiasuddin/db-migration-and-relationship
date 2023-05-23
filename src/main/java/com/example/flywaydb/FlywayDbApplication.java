package com.example.flywaydb;

//import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEncryptableProperties
public class FlywayDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayDbApplication.class, args);
    }

}
