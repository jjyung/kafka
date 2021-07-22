package my.app.controller;

import my.app.service.WeatherStationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-station")
public class WeatherStationController {

    private final WeatherStationService weatherStationService;

    public WeatherStationController(WeatherStationService weatherStationService) {this.weatherStationService = weatherStationService;}

    @PostMapping("/observation")
    public void produceAnObservation() {
        weatherStationService.produceAnObservation();
    }
}
