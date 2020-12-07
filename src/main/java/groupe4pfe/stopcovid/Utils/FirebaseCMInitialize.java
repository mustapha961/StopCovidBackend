package groupe4pfe.stopcovid.Utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FirebaseCMInitialize {

    @PostConstruct
   public void initialize(){
       try {
           FileInputStream serviceAccount = new FileInputStream("./serviceAccount.json");
           FirebaseOptions options = new FirebaseOptions.Builder()
                   .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                   .build();

           FirebaseApp.initializeApp(options);

       } catch (IOException fileNotFoundException) {
           fileNotFoundException.printStackTrace();
       }

   }



}
