package groupe4pfe.stopcovid.Utils;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FCMService {

    public void sendNotifications(List<String> tokens) {
        MulticastMessage message = MulticastMessage.builder()
                .setNotification(Notification.builder()
                        .setTitle("BlockCovid")
                        .setBody("Vous avez été en contact avec quelqu'un de malade")
                        .build())
                .addAllTokens(tokens)
                .build();
        try {
             FirebaseMessaging.getInstance().sendMulticast(message).getResponses();
            System.out.println("notif sent");
        }catch (FirebaseMessagingException e){
            System.out.println("Some notif have been not sent");
        }

    }


}
