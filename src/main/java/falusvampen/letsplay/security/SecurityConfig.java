

package falusvampen.letsplay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .httpBasic(withDefaults()) // authentication
                                .authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()); // authorization

                return http.build();
        }

}
