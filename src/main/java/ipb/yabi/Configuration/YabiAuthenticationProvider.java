/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.Configuration;

import ipb.yabi.YabiUser.YabiUser;
import ipb.yabi.YabiUser.YabiUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hydrocat
 */
@Component
public class YabiAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private YabiUserRepository userRepo;
    
    private final Logger logger = LoggerFactory.getLogger(YabiAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        YabiUser user = userRepo.findByName(authentication.getName());
        if (user == null) // User does not exist in database
        {
            logger.info("User not found in Yabi Database");
            throw new AuthenticationServiceException("User not found in Yabi Database");
        }

        return new YabiAuthenticationToken(user.getAuthorities(), user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                YabiAuthenticationToken.class)
                || authentication.equals(
                        UsernamePasswordAuthenticationToken.class
                );
    }

}
