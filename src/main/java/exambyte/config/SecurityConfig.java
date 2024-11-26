package exambyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@SuppressWarnings("ALL")
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/wellcome").permitAll()
                        .requestMatchers("/studentLogin").permitAll()
                        .requestMatchers("/adminLogin").permitAll()
                        .requestMatchers("/css/*").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return chainBuilder.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(new User("default", "{noop}default", List.of()));
        return manager;
    }
}
