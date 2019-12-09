package polygon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import polygon.security.UrlAuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.csrf().ignoringAntMatchers("/console/**");
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/console/**","/**").permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login").successHandler(urlRedirect())
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/")
                .permitAll();


    }

    @Bean
    public AuthenticationSuccessHandler urlRedirect(){
        return new UrlAuthSuccessHandler();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder().username("user")
                        .password("password")
                        .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
