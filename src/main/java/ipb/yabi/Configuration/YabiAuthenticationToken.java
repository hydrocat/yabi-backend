/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.Configuration;

import ipb.yabi.YabiUser.YabiUser;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author hydrocat
 */
public class YabiAuthenticationToken extends AbstractAuthenticationToken {

    public YabiAuthenticationToken(Collection<? extends GrantedAuthority> authorities, UserDetails details) {
        super(authorities);
        this.setDetails(details);
        this.setAuthenticated(true);
    }


    @Override
    public Object getCredentials() {
        return this.getDetails();
    }

    @Override
    public Object getPrincipal() {
        return this.getDetails();
    }

    @Override
    public boolean implies(Subject sbjct) {
        return super.implies(sbjct);
    }
    
}
