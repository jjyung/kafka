package my.app.model.weather;

import java.io.Serializable;

public class WeatherData implements Serializable {

    private static final long serialVersionUID = -4203770756697027417L;

    private double temperature;
    private double humidity;

    public WeatherData() {
    }

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override public String toString() {
        return "WeatherData{" +
            "temperature=" + temperature +
            ", humidity=" + humidity +
            '}';
    }
}
