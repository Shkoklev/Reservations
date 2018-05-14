package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Owner;
import com.sorsix.interns.reservations.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class OwnerService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerService(OwnerRepository repository, PasswordEncoder passwordEncoder) {
        this.ownerRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Owner saveOwner(String firstName, String lastName, String email, String password) {
        boolean ownerExists = ownerRepository.existsByEmail(email);
        if (ownerExists) {
            logger.warn("Owner [{}] already exists.", email);
            throw new EntityExistsException(email);
        } else {
            Owner newOwner = new Owner(firstName, lastName, email);
            newOwner.setPassword(passwordEncoder.encode(password));
            return ownerRepository.save(newOwner);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Loading owner: [{}]", username);
        return ownerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
}
