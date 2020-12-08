package groupe4pfe.stopcovid;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@RestController
public class StopcovidApplication {

  public static void main(String[] args) {
    try {
      FileInputStream serviceAccount = new FileInputStream("./serviceAccount.json");
      FirebaseOptions options = new FirebaseOptions.Builder()
              .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .build();

      FirebaseApp.initializeApp(options);

    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
    SpringApplication.run(StopcovidApplication.class, args);
  }
}