package pl.sda.filmrepository;



import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/suggestions/**")
                .authenticated().and()
                .httpBasic().and()
                .csrf()         // wylaczenie http protokolu,na web
                .disable();
    }

   @Override
     protected void configure(AuthenticationManagerBuilder auth ) throws  Exception {
            auth.inMemoryAuthentication().withUser("admin")
                    .password("{noop}password")  //  noop - no operation
                    .roles("ADMIN");
// jaki endpoint jakie ma wymagania
        // na poziomie http

        }
    }
