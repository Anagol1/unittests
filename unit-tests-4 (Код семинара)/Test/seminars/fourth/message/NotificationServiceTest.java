package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
      4.5. Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
      Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String recipient),
      который отправляет сообщение получателю.
      Вам необходимо проверить правильность работы класса NotificationService,
      который использует MessageService для отправки уведомлений.
    */
class NotificationServiceTest {

    @Test
    void NotificationServiceTest() {
        MessageService mockMessageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(mockMessageService);
        String message = "Привет";
        String recipient = "Анна";
        notificationService.sendNotification(message,recipient);
        verify(mockMessageService).sendMessage(message,recipient);

    }

}