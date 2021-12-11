package com.appistock.proyectostock.config;

import com.appistock.proyectostock.security.RestAuthenticationEntryPoint;
import com.appistock.proyectostock.security.TokenAuthenticationFilterP;
import com.appistock.proyectostock.security.TokenAuthenticationFilterR;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public TokenAuthenticationFilterR createTokenAuthenticationFilterR(){
        return new TokenAuthenticationFilterR();
    }

    @Bean
    public TokenAuthenticationFilterP createTokenAuthenticationFilterP(){
        return new TokenAuthenticationFilterP();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()//peticiones entrantes para consimir la api
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers(
                        //permitidos sin autenticacion, es decir, excluidos del security
                        "/login_P",
                        "/login_R",
                        "/signUp_R",
                        "/signUp_P"
                )
                .permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(createTokenAuthenticationFilterP(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(createTokenAuthenticationFilterR(),UsernamePasswordAuthenticationFilter.class);
    }
}
