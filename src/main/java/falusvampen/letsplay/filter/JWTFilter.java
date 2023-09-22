package falusvampen.letsplay.filter;

import falusvampen.letsplay.service.JWTService;
import falusvampen.letsplay.service.UserInfoDetailsService;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;

public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserInfoDetailsService userInfoDetailsService;

}
