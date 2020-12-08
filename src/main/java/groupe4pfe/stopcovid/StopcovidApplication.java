package groupe4pfe.stopcovid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StopcovidApplication {

  public static void main(String[] args) {
    SpringApplication.run(StopcovidApplication.class, args);
  }
}