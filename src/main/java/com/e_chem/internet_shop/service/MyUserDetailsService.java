package com.e_chem.internet_shop.service;

import com.e_chem.internet_shop.config.MyUserDetails;
import com.e_chem.internet_shop.domain.User;
import com.e_chem.internet_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByFirstName(username);
        return user.map(MyUserDetails::new)
                .orElseThrow();
    }
}
