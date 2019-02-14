package at.nightfight.controller;

import at.nightfight.message.request.LoginForm;
import at.nightfight.message.request.SignUpForm;
import at.nightfight.message.response.JwtResponse;
import at.nightfight.model.Role;
import at.nightfight.model.RoleName;
import at.nightfight.model.User;
import at.nightfight.repository.RoleRepository;
import at.nightfight.repository.UserRepository;
import at.nightfight.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));


        // get and set Roles
        // !!!! UNCOMMENT TO LET REQUESTER CHOOSE BETWEEN AVAILABLE ROLES
/*        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch(role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "pm":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);*/


        // TEMP SET USER ROLE MANUALLY
        Set<Role>roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow( () -> new RuntimeException("Fail! -> Cause: User Role not found."));
        roles.add(userRole);
        user.setRoles(roles);

        // ADD NOW as Timestamp for created
        user.setCreated(LocalDate.now());

        // SET USER AS NOT BLOCKED
        user.setBlocked(false);


        // SAVE/CREATE USER
        User createdUser = userRepository.save(user);


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signUpRequest.getUsername(),
                        signUpRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));
        //return ResponseEntity.ok().body("User registered successfully!");
    }

}
