package groupe4pfe.stopcovid.security.services;

import groupe4pfe.stopcovid.model.Medecin;
import groupe4pfe.stopcovid.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("medecin")
public class MedecinDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MedecinRepository medecinRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Medecin medecin = medecinRepository.findByEmail(email).orElse(null);
        UserDetails user = new User(medecin.getEmail(),medecin.getMot_de_passe(),new ArrayList<>());
        return user;
    }
}
