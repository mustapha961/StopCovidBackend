package groupe4pfe.stopcovid.Utils;

import com.google.firebase.messaging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FCMService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public void sendNotifications(List<String> tokens) {
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle("BlockCovid")
                        .setBody("Vous avez été en contact avec quelqu'un de malade")
                        .build())
                .setToken("c--yoJsMTUSd2cI_7a_iN0:APA91bE0y6Gnm0PlfDb_qDZQaJHAAmqG0KTy1QypceZn_Qp-FYrUPXZpWTp9CHc2_4-0iyCaPMa19xFVogRdYhwfC0kyHohk8mJrA5VUympWRmf0GztXhUoNroPv44uReKHjTV1Q1AZf")
                .build();
        try {
            firebaseMessaging.send(message);
            System.out.println("notif sent");
        } catch (FirebaseMessagingException e) {
            System.out.println("Some notif have been not sent");
        }

    }
}
