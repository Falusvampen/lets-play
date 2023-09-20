package falusvampen.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import falusvampen.letsplay.config.UserInfoDetails;
import falusvampen.letsplay.models.User;

public class UserInfoDetailsTest {

    @Test
    public void testUserInfoDetails() {
        User user = new User();
        user.setEmail("test@email.com");
        user.setPassword("testPassword");
        user.setRole("ADMIN");

        UserInfoDetails userDetails = new UserInfoDetails(user, true, true, true, false);

        assertEquals("test@email.com", userDetails.getUsername());
        assertEquals("testPassword", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")));
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertFalse(userDetails.isEnabled());
    }

}
