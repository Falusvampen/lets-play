// package falusvampen.letsplay.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Service;
// import falusvampen.letsplay.models.User;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @Service
// public class JwtUtil {

// private String SECRET_KEY = "your-secret-key-here";

// public String generateToken(User user) {
// Map<String, Object> claims = new HashMap<>();
// return createToken(claims, user.getId());
// }

// private String createToken(Map<String, Object> claims, String subject) {
// return Jwts.builder()
// .setClaims(claims)
// .setSubject(subject)
// .setIssuedAt(new Date(System.currentTimeMillis()))
// .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //
// 10 hours validity
// .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
// .compact();
// }
// }
