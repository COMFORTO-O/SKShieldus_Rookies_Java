package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationConfigTest {

    @Test
    public void testNotificationManagerBean() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(NotificationConfig.class);

        NotificationManager manager = context.getBean(NotificationManager.class);
        assertNotNull(manager);

        assertNotNull(manager.getEmailService());
        assertNotNull(manager.getSmsService());

        assertTrue(manager.getEmailService() instanceof EmailNotificationService);
        assertTrue(manager.getSmsService() instanceof SmsNotificationService);

        manager.sendNotificationByEmail("이메일 테스트 메시지");
        manager.sendNotificationBySms("SMS 테스트 메시지");

        context.close();
    }
}
