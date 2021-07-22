package my.app.controller;

import my.app.model.weather.WeatherData;
import my.app.service.NewsDeskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news-desk")
public class NewsDeskController {

    private final NewsDeskService newsDeskService;

    public NewsDeskController(NewsDeskService newsDeskService) {
        this.newsDeskService = newsDeskService;
    }

    @GetMapping("/weather/last")
    public WeatherData getLastWeatherDate() {
        return newsDeskService.getLast();
    }

}
