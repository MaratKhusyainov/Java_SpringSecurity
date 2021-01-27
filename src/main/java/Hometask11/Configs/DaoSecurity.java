package Hometask11.Configs;


import Hometask11.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@RequiredArgsConstructor
public class DaoSecurity extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(DaoSecurity.class.getName());


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Dao Auth Provider");
        http.authorizeRequests()
                .antMatchers("/api/v1/score/dec").hasRole("ADMIN")
                .antMatchers("/api/v1/score/inc").hasRole("ADMIN")
                .antMatchers("/api/v1/score/current").hasRole("ADMIN")
                .antMatchers("/api/v1/score/**").authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

}