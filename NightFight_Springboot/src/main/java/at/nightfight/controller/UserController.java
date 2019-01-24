package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.User;
import at.nightfight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable(name = "id") Long id){
        Optional<User> user = this.userRepository.findById(id);
        return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
    }

/*    @PostMapping("/users")
    public ResponseEntity<Character> createCharacter(){

        Character newCharacter = new Character();

        return new ResponseEntity<Character>(newCharacter, HttpStatus.CREATED);
    }*/


}
