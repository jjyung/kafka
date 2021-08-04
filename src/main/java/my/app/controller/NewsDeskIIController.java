package my.app.controller;

import my.app.model.weather.WeatherData;
import my.app.service.NewsDeskIIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news-desk-2")
public class NewsDeskIIController {

    private final NewsDeskIIService newsDeskIIService;

    public NewsDeskIIController(NewsDeskIIService newsDeskIIService) {
        this.newsDeskIIService = newsDeskIIService;
    }

    @GetMapping("/weather/last")
    public WeatherData getLastWeatherDate() {
        return newsDeskIIService.getLast();
    }

}
