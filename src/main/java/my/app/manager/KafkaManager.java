package my.app.manager;

import my.app.constant.topic.TOPIC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaManager {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaManager(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ListenableFuture<SendResult<String, String>> send(String topic, @Nullable String data) {
        return kafkaTemplate.send(topic, data);
    }

    @KafkaListener(topics = { TOPIC.BAELDUNG }, groupId = "foo")
    public void listenGroupFoo(String message) {
        // TODO logger?
        System.out.println("Received Message in group foo: " + message);
    }
}
