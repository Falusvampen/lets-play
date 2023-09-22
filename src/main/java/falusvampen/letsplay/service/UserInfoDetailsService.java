package falusvampen.letsplay.service;

import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.models.User; // Assuming you have a UserEntity class for your user
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username); // findByUsername
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        User user = userOptional.get();

        // Initialize authorities
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString())); // Assuming getRole returns an Enum or
                                                                                // String

        // Return Spring Security User object
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                authorities);
    }
}
