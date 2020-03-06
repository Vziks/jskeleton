package info.vziks.skeleton.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class AuthenticationSystem
 * Project skeleton
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class AuthenticationSystem {

    public static boolean isLogged() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && !("anonymousUser").equals(authentication.getName());
    }
}
