/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.Configuration;

import ipb.yabi.YabiUser.YabiUser;
import java.util.Collection;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author hydrocat
 */
public class YabiAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public YabiAuthenticationToken(Object principal, Object credentials, YabiUser user) {
        super(principal, credentials);
        super.setDetails(user);
    }

    public YabiAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, YabiUser user) {
        super(principal, credentials, authorities);
        super.setDetails(user);
    }
    
}
