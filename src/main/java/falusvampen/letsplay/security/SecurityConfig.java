
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// // Your security configurations will go here
// }
// }
// package falusvampen.letsplay.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
// // Your security configurations will go here

// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// return
// http.csrf().disabled().authorizeRequests().anyRequest().authenticated().and().httpBasic().and().build();
// }

// }

package falusvampen.letsplay.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeRequests((authorizeRequests) -> authorizeRequests
//                         .requestMatchers("/**").hasRole("USER"))
//                 .formLogin(withDefaults());
//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails user = User.withDefaultPasswordEncoder()
//                 .username("user")
//                 .password("password")
//                 .roles("USER")
//                 .build();
//         UserDetails admin = User.withDefaultPasswordEncoder()
//                 .username("admin")
//                 .password("password")
//                 .roles("ADMIN", "USER")
//                 .build();
//         return new InMemoryUserDetailsManager(user, admin);
//     }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
