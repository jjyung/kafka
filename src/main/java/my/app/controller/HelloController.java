package my.app.controller;

import my.app.manager.KafkaManager;
import my.app.model.message.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private KafkaManager kafkaManager;

    @GetMapping("/")
    public String greeting() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/{topic}")
    public void sendMessage(
        @PathVariable String topic,
        @RequestBody MessageDTO messageDTO
    ) {
        kafkaManager.send(topic, messageDTO.getData());
    }
}
