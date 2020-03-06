package info.vziks.skeleton.config;

import info.vziks.skeleton.config.utils.AppNameService;
import info.vziks.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Class WebSkeletonSecurityConfig
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Configuration
@EnableWebSecurity
public class WebSkeletonSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/auth/registration",
                        "/user/**"
                ).not().fullyAuthenticated()
//                .antMatchers("/foruser/**").hasRole("USER")
//                .antMatchers("/foradmin/**").hasRole("ADMIN")
                .antMatchers("/",
                        "/about",
                        "/contact").permitAll()
//                .antMatchers("/webjars/**", "/js/**", "/css/**", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/")
                .failureUrl("/auth/login?error=true")
                .permitAll()
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/");

    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity
                .ignoring()
                .antMatchers("/webjars/**",
                        "/js/**", "/css/**", "/img/**", "/webfonts/**");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService(userService).
                passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean(name = "appService")
    public AppNameService appService() {
        return () -> "AppName";
    }


}
