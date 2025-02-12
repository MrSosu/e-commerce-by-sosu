package com.sosu.notifications.kafka;

import com.sosu.notifications.kafka.orders.OrderConfirmation;
import com.sosu.notifications.kafka.payment.PaymentConfirmation;
import com.sosu.notifications.notification.Notification;
import com.sosu.notifications.notification.NotificationRepository;
import com.sosu.notifications.notification.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationRepository notificationRepository;

    @KafkaListener(topics = "order-topic")
    public void consumeOrderNotification(OrderConfirmation orderConfirmation) {
        notificationRepository.save(
                Notification
                        .builder()
                        .notificationType(NotificationType.ORDER_NOTIFICATION)
                        .notificationTime(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        // TODO inviare la email di conferma dell'ordine
    }

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentNotification(PaymentConfirmation paymentConfirmation) {
        notificationRepository.save(
                Notification
                        .builder()
                        .notificationType(NotificationType.PAYMENT_NOTIFICATION)
                        .notificationTime(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        // TODO invio la email di conferma del pagamento
    }
}
