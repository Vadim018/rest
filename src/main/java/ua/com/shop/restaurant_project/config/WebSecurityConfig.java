package ua.com.shop.restaurant_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.shop.restaurant_project.service.UserManagerService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig
{
    private final UserManagerService userManagerService;

    @Autowired
    public WebSecurityConfig(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // шифрування паролів
    }

    @Bean
    public SecurityFilterChain spiFilterChain(HttpSecurity http) throws Exception // налаштовує HttpSecurity
    {
        http.authenticationManager(http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userManagerService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build());
        http
                .csrf()
                .disable()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(
                                "/",
                                "/registration",
                                "/registration/**",
                                "/static/**",
                                "/resources",
                                "/resources/**"
                        )
                        .permitAll()
                        .requestMatchers(
                                "/category_manager",
                                "/product_manager",
                                "/customer_manager")

                        .hasRole("Admin")
                        .requestMatchers("/")
                        .hasRole("User")
                        .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll())
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/"));
        return http.build();
    }
}

/*
   Цей код допомагає забезпечити захист та автентифікацію у
   веб-застосунку за допомогою Spring Security.
*/