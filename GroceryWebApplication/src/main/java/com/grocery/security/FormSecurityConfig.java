package com.grocery.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class FormSecurityConfig extends WebSecurityConfigurerAdapter {

 

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
		/* provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); */
		 provider.setPasswordEncoder(new BCryptPasswordEncoder()); 
        return provider;
    }

 

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        //super.configure(http);
        http
        .csrf().disable()
        .authorizeRequests().antMatchers("/").permitAll();
       /* .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/customerLogin").permitAll()
        .and().antMatcher("/getspecificproducts").anonymous().and()
        .logout().invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logoutpage"))
        .logoutSuccessUrl("/customerLogin").permitAll();*/
    }
    
    
    
}