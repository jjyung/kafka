package my.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.app.constant.topic.Topic;
import my.app.constant.topic.WeatherGroup;
import my.app.model.weather.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsDeskIIService {
    private static final Logger logger = LoggerFactory.getLogger(NewsDeskIIService.class);
    private static final List<WeatherData> WEATHER_DATA_QUEUE = new ArrayList<>();
    private static final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = { Topic.WEATHER }, groupId = WeatherGroup.NEWS_DESK)
    public void listenFromKafka(String weatherDataJsonStr) throws JsonProcessingException {
        WeatherData weatherData = mapper.readValue(weatherDataJsonStr, WeatherData.class);
        WEATHER_DATA_QUEUE.add(weatherData);
        logger.info(
            "{} received a weatherData: {}, total: {}",
            this.getClass().getSimpleName(), weatherData, WEATHER_DATA_QUEUE.size()
        );
    }

    public WeatherData getLast() {
        return WEATHER_DATA_QUEUE.get(WEATHER_DATA_QUEUE.size() - 1);
    }
}
