package at.nightfight.model.mapper;

import at.nightfight.model.User;
import at.nightfight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserIdUserEntityMapper {

    @Autowired
    UserRepository userRepository;

    public User asUser (Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        return null;
    }

    public Long asUserId (User user){
        return user.getId();
    }
}
