package falusvampen.letsplay.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
// import org.springframework.security.core.userdetails.UserDetails;

import falusvampen.letsplay.services.JWTService;

public class JWTServiceTest {

    @Test
    public void testExtractUsername() {
        JWTService jwtService = new JWTService();
        String token = jwtService.generateToken("testUsername");
        assertEquals("testUsername", jwtService.extractUsername(token));
    }

    @Test
    public void testGenerateToken() {
        JWTService jwtService = new JWTService();
        String token = jwtService.generateToken("testUsername");
        assertNotNull(token);
    }

    @Test
    public void testIsTokenExpired() {
        JWTService jwtService = new JWTService();
        String token = jwtService.generateToken("testUsername");
        assertFalse(jwtService.isTokenExpired(token));
    }
}
