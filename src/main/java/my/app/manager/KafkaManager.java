package my.app.manager;

import my.app.constant.topic.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaManager {
    private static final Logger logger = LoggerFactory.getLogger(KafkaManager.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaManager(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ListenableFuture<SendResult<String, String>> send(String topic, @Nullable String data) {
        return kafkaTemplate.send(topic, data);
    }

    @KafkaListener(topics = { Topic.BAELDUNG }, groupId = "foo")
    public void listenGroupFoo(String message) {
        logger.info("Received Message in group foo: {}", message);
    }
}
