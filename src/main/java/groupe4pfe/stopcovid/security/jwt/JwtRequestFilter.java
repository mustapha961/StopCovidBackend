package groupe4pfe.stopcovid.security.jwt;

import groupe4pfe.stopcovid.security.Util.JwtUtil;
import groupe4pfe.stopcovid.security.services.CitoyenDetailsServiceImpl;
import groupe4pfe.stopcovid.security.services.EtablissementDetailsServiceImpl;
import groupe4pfe.stopcovid.security.services.MedecinDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("medecin")
    private MedecinDetailsServiceImpl medecinDetailsService;
    @Autowired
    @Qualifier("citoyen")
    private CitoyenDetailsServiceImpl citoyenDetailsService;
    @Autowired
    @Qualifier("etablissement")
    private EtablissementDetailsServiceImpl etablissementDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        String email = null;
        String jwt = null;
        String role = null;
        String id = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            email = jwtUtil.extractEmail(jwt);
            id = jwtUtil.extractId(jwt);
            role = jwtUtil.extractRole(jwt);
        }

        if ((email != null || id != null) && role != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = null;
            if(role.equals("etablissement")){
                userDetails = this.etablissementDetailsService.loadUserByUsername(email);
            }else if(role.equals("citoyen")){
                userDetails = this.citoyenDetailsService.loadUserByUsername(id);
            }else{
                userDetails = this.medecinDetailsService.loadUserByUsername(email);

            }

            String aValider = email.equals("") ? id : email;
            if (jwtUtil.validateToken(aValider, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(request, response);
    }

}