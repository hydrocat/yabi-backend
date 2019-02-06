/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.Configuration;

import ipb.yabi.YabiUser.YabiUser;
import ipb.yabi.YabiUser.YabiUserRepository;
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
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    YabiUserRepository userRepo;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        YabiUser user = userRepo.findByName(authentication.getName());
        if (user == null) // User does not exist in database
        {
            System.out.println("Ususario nao encontrado na base de dados do Yabi");
            throw new AuthenticationServiceException("Ususario nao encontrado na base de dados do Yabi");
        }
        System.out.println("Tentei autenticar o " + authentication.getName());
        return new YabiAuthenticationToken(authentication.getName(), "senha?", user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        System.out.println("Lets try this");
        return authentication.equals(
                       YabiAuthenticationToken.class) || 
               authentication.equals(
                       UsernamePasswordAuthenticationToken.class
               );
    }
    
}
