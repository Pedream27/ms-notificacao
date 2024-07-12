package dev.phsaraiva.com.br.ms_agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import dev.phsaraiva.com.br.ms_agendamento.dto.UserDto;
import dev.phsaraiva.com.br.ms_agendamento.entity.User;
import dev.phsaraiva.com.br.ms_agendamento.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDto dto) {
        repository.save(new User(dto.name() , dto.email() , dto.number()));
        
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserByID(@PathVariable("userid") Long userID) {

        var user = repository.findById(userID);

        if (user.isEmpty()) {
            return new ResponseEntity(null).notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }
    
    

}
