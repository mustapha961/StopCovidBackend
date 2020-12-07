package groupe4pfe.stopcovid.security.services;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.repository.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component("citoyen")
public class CitoyenDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Citoyen citoyen = citoyenRepository.findById(UUID.fromString(s)).orElse(null);
        if(citoyen==null)
            return null;
        return new User(citoyen.getId().toString(),"",new ArrayList<>());
    }
}
