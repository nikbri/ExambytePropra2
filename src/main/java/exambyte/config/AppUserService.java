package exambyte.config;

import exambyte.Database.DatabaseManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppUserService implements OAuth2UserService {
    private final DefaultOAuth2UserService defaultOAuth2UserService = new DefaultOAuth2UserService();

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)throws OAuth2AuthenticationException {
        OAuth2User originalUser = defaultOAuth2UserService.loadUser(userRequest);
        Set<GrantedAuthority> authorities = new HashSet<>(originalUser.getAuthorities());
        //Bestimmt noch andern:
        DatabaseManager db = new DatabaseManager();
        String name = originalUser.getAttribute("login");
        String role = db.getRole(name);

        switch (role) {
            case "ROLE_ADMIN":
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
                break;
            case "ROLE_STUDENT":
                authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
                break;
            case "ROLE_ORGANIZER":
                authorities.add(new SimpleGrantedAuthority("ROLE_ORGANIZER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
        }
        return new DefaultOAuth2User(authorities,originalUser.getAttributes(),"id");
    }

}
