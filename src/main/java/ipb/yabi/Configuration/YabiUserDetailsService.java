/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.Configuration;

import ipb.yabi.YabiUser.YabiUser;
import ipb.yabi.YabiUser.YabiUserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author hydrocat
 */
public class YabiUserDetailsService implements AuthenticationUserDetailsService {

    @Autowired
    YabiUserRepository userRepo;

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        YabiUser user = (YabiUser) token.getPrincipal();
        SecurityContextHolder.getContext()
                .setAuthentication(
                        new YabiAuthenticationToken(
                                Arrays.asList(
                                        new SimpleGrantedAuthority(
                                                user.getRole().toString()
                                        )
                                ),
                                user));
        return user;
    }

}
