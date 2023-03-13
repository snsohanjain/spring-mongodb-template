package com.example.springmongodbtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){
        Address address = new Address("India","Mysore","571604");
        return args -> {
            String email = "snsohan@gmail.com";
            Student student = new Student(
                    "Sohan",
                    "Jain",
                    email,
                    Gender.MALE,address,
                    List.of("Computer Science"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
                    );
                    repository.insert(student);
        };
    }
}
