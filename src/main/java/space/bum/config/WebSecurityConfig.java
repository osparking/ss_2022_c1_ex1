package space.bum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

    @Bean
    UserDetailsService userService() {
        var userManager = new InMemoryUserDetailsManager();
        var user = User.withUsername("park")
                .password("1234")
                .authorities("read")
                .build();
        userManager.createUser(user);
        return userManager;
    }
    
    @SuppressWarnings("deprecation")
	@Bean
    PasswordEncoder passwordEncoder() {
    	return NoOpPasswordEncoder.getInstance();
    }
}
