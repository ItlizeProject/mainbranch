package com.example.demo.Config;
import com.example.demo.Service.MyUserLoginDetailsService;
import com.example.demo.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//dont need to extend WebSecurityConfigurerAdapter
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig {
    @Autowired
    MyUserLoginDetailsService userService;

    @Autowired
    private PasswordEncoder encoder;//need it?
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    //????????????password??????
    //??????Java ???UserSeviceImp class??? @Autowired ???PasswordEncoder passwordEncoder ???????????????????????????BCryptPasswordEncoder??????????????????
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    //Authentication
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure database-based user password query.
        // Password uses BCryptEncoder (combined with random salt and encryption algorithm) that comes with security.
        //Override the UserdatailsService class
        /*
        AuthenticationManagerBuilder?????????????????????????????? userDetailsService()????????????????????????UserDetailsService?????????????????????
        ???MyUserLoginDetailsService??????????????????UserDetailsService????????????????????????class @Autowired ???MyUserLoginDetailsService userService???
        ????????????auth.userDetailsService(userService)
         */
        auth.userDetailsService(userService)
                //Override the default password verification class
                .passwordEncoder(bCryptPasswordEncoder());//call?????????bean????????????????????????
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }
    //configure for http security non-deprecated
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers("/user/authenticate").permitAll()
                .requestMatchers("/user/createUser").permitAll()
                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
              //  .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
              //  .requestMatchers("/login/**")
              //  .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }
}


