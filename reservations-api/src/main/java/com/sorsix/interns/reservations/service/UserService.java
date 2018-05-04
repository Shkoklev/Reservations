package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Place;
import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(
            String firstName,
            String lastName,
            String username,
            String email,
            Integer age,
            String password,
            Place place) throws Exception {

        Optional<UserDetails> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            log.info("This username already exists");
            throw new Exception("Exists");
        }
        else {
            User newUser = new User(firstName,lastName,age,username,password,email,place);
            newUser.setPassword(bCryptPasswordEncoder.encode(password));
            return userRepository.save(newUser);
        }
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> user = userRepository.findByUsername(username);
        if (user.isPresent())
            return user.get();
        else throw new UsernameNotFoundException("Not found");
    }
}
