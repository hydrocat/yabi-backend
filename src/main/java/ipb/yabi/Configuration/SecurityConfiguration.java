/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author hydrocat
 */
@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public SecurityConfiguration() {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/user").permitAll()
                // Spring Repositories
                .antMatchers("/directories/**", "/yabiUsers/**", "/permissionTrees/**", "/sqlQueries/**").hasRole("ADMIN")
                // Custom Controllers
                .antMatchers(HttpMethod.DELETE, "/permission/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, YabiAuthenticationProvider ap) throws Exception {
//        auth.authenticationProvider(ap);
        auth.authenticationProvider(ap);
                
//                .userSearchFilter("(uid={0})")
//                .userSearchBase("ou=users,dc=ipb,dc=pt")
//                .groupSearchBase("ou=groups,dc=ipb,dc=pt")
//                .contextSource().url("ldaps://ldap.ipb.pt:636");
    }
}
