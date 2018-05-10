package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Place;
import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.EntityExistsException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(
            String firstName,
            String lastName,
            String email,
            String username,
            String password,
            LocalDate birthDate,
            Place place) {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            logger.warn("Username [{}] already exists", username);
            throw new EntityExistsException(username);
        } else {
            User newUser = new User(firstName, lastName, username, email);
            newUser.setBirthDate(birthDate);
            newUser.setPlace(place);
            newUser.setPassword(passwordEncoder.encode(password));
            return userRepository.save(newUser);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Loading user: [{}]", username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
