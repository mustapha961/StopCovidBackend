package groupe4pfe.stopcovid.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    private String SECRET_KEY = "secret";

    public String extractEmail(String token) {
        Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String email = jwt.getClaim("mail").asString();
        return email;
    }

    public String extractRole(String token) {
        Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String role = jwt.getClaim("role").asString();
        return role;
    }
    public String extractId(String token) {
        Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String userId = jwt.getClaim("id").asString();
        return userId;
    }

    public String createToken(String email, String id,String role) {

        return JWT.create().withClaim("id", id)
                .withClaim("mail",email)
                .withClaim("role",role)
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    public Boolean validateToken(String email, UserDetails userDetails) {
        return (email.equals(userDetails.getUsername()));
    }


}
