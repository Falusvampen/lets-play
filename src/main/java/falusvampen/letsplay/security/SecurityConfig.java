
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