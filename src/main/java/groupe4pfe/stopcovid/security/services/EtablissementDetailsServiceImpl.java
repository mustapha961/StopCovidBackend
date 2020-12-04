package groupe4pfe.stopcovid.security.services;

import groupe4pfe.stopcovid.model.Etablissement;
import groupe4pfe.stopcovid.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("etablissement")
public class EtablissementDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Etablissement etablissement = etablissementRepository.findByEmail(s).orElse(null);
        return new User(etablissement.getEmail(),etablissement.getMot_de_passe(),new ArrayList<>());
    }
}
