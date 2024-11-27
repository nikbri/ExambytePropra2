package exambyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("ALL")
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/wellcome").permitAll()
                        .requestMatchers("/css/*").permitAll()
                        .anyRequest().authenticated()
        )
        .oauth2Login(config ->
                config.userInfoEndpoint(
                        info -> info.userService(new AppUserService())
                ));

        return chainBuilder.build();
    }

}
