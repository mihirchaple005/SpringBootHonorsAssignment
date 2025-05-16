package org.example.service;

// import org.example.model.User;
// import org.example.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.stereotype.Service;

// import org.springframework.data.domain.Pageable;

// import javax.swing.text.html.Option;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class UserService {

//     // this is the business logic of the system..

//     @Autowired
//     private UserRepository userRepository;

//     public User registerUser(User user){
//         if (userRepository.findByEmail(user.getEmail()).isPresent()){
//             throw new RuntimeException("User Already Exists");
//         }
//         // userRepository.save(user);
//         return userRepository.save(user);
//     }


//     public Optional<User> getUserByEmail(String email) {
//         return userRepository.findByEmail(email);
//     }

//     public Optional<User> getUserByPhone(String phone) {
//         return userRepository.findByPhone(phone);
//     }

//     public List<User> getUserByName(String name){
//         return userRepository.findByNameIgnoreCase(name);
//     }

//     public List<User> getUsersWithBookedTickets() {
//         return userRepository.findUsersWithBookedTickets();
//     }

//     public Page<User> getAllUsers(Pageable pageable) {
//         return userRepository.findAll(pageable);
//     }

//     public User getUserById(long userId) {
//         return userRepository.getUserById(userId);
//     }

//     public void deleteUser(long userId) {
//         userRepository.deleteUser(userId);
//     }
// }


import org.example.exception.UserAlreadyExistsException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;





@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        return userRepository.save(user); // Replaces createUser()
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByNameIgnoreCase(name);
    }

    // public List<User> getUsersWithBookedTickets() {
    //     return userRepository.findUsersWithBookedTickets();
    // }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // Use built-in methods instead of custom repository ones
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId); // Replaces getUserById()
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId); // Replaces deleteUser()
    }
}