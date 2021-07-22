package my.app.service;

import my.app.constant.topic.Topic;
import my.app.model.weather.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherStationService {

    private final KafkaTemplate<String, WeatherData> weatherDataKafkaTemplate;

    @Autowired
    public WeatherStationService(KafkaTemplate<String, WeatherData> weatherDataKafkaTemplate) {
        this.weatherDataKafkaTemplate = weatherDataKafkaTemplate;
    }

    public void produceAnObservation() {
        weatherDataKafkaTemplate.send(
            Topic.WEATHER,
            new WeatherData(
                Math.random() * 40d,
                Math.random()
            )
        );
    }
}
