
package falusvampen.letsplay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

        @Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
                http.csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(
                                                authorize -> authorize.requestMatchers("/api/products/").permitAll()
                                                                .requestMatchers("/api/products/{id}").permitAll()
                                                                .anyRequest().authenticated());

                return http.build();
        }

}
