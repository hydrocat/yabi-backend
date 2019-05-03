package ipb.yabi.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author vitorio <a40920@alunos.ipb.pt>
 */
@Component
public class YabiPasswordEncoder implements PasswordEncoder {
    
    private static Logger logger = LoggerFactory.getLogger(YabiPasswordEncoder.class);

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        boolean matches = rawPassword.toString().equals(encodedPassword);
        if (!matches) {
            throw new BadCredentialsException("Unamtched passwords");
        }
        return matches;
    }
    
}
