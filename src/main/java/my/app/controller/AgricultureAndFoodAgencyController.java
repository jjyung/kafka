package my.app.controller;

import my.app.model.weather.WeatherData;
import my.app.service.AgricultureAndFoodAgencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/afa")
public class AgricultureAndFoodAgencyController {

    private final AgricultureAndFoodAgencyService newsDeskService;

    public AgricultureAndFoodAgencyController(AgricultureAndFoodAgencyService newsDeskService) {
        this.newsDeskService = newsDeskService;
    }

    @GetMapping("/weather/last")
    public WeatherData getLastWeatherDate() {
        return newsDeskService.getLast();
    }

}
