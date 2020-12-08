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

    SpringApplication.run(StopcovidApplication.class, args);
  }
}