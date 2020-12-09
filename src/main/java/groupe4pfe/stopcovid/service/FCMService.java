package groupe4pfe.stopcovid.service;

import com.google.firebase.messaging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FCMService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public void sendNotifications(List<String> tokens) {

        MulticastMessage message = MulticastMessage.builder()
                .setNotification(Notification.builder()
                        .setTitle("BlockCovid")
                        .setBody("Vous avez été en contact avec quelqu'un de malade")
                        .build())
                .addAllTokens(tokens)
                .build();
        try {
            firebaseMessaging.sendMulticast(message).getResponses();
            System.out.println("notif sent");
        } catch (FirebaseMessagingException e) {
            System.out.println("Some notif have been not sent");
        }

    }
}
