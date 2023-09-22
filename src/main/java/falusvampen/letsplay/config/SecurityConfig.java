
package falusvampen.letsplay.config;

import falusvampen.letsplay.filter.JWTFilter;
import falusvampen.letsplay.service.UserInfoDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        // First we need to inject out JWTFilter into the SecurityFilterChain
        @Autowired
        private JWTFilter jwtFilter;

        // Then we need to configure the UserDetailsService
        @Bean
        public UserDetailsService userDetailsService() {
                return new UserInfoDetailsService();
        }

        @Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
                http.csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(
                                                authorize -> authorize.requestMatchers("/api/products/").permitAll()
                                                                .requestMatchers("/api/products/{id}").permitAll()
                                                                .anyRequest().authenticated());

                return http.build();
        }

        // Password encoder is needed but commented out for now
        // @Bean
        // public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        // }

}
