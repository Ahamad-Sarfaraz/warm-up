package LLD.DesignPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    public static void main(String[] args) {
        // create Subject
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer carDisplay = new CarDisplay();
        Observer tvDisplay = new TVDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(carDisplay);
        weatherStation.addObserver(tvDisplay);
        weatherStation.setWeather("Rainy");

        // notify all observers
        weatherStation.notifyObservers();
        weatherStation.removeObserver(tvDisplay);

        weatherStation.setWeather("Sunny");
        weatherStation.notifyObservers();

    }

}

// behavioral design pattern, establish one to many relationship between  subjects and observers
// when subject state changes, all observers are notified
// example - stock market, weather app, social media notifications
// Use Case - Weather App


interface Subject{

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}

interface Observer{
    void update(String updatedWeatherInformation);
}

// Concrete of Subject
class WeatherStation implements Subject{

    List<Observer> observerList = new ArrayList<>();

    public void setWeather(String weather) {
        this.weather = weather;
    }

    String weather;

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(Observer observer:this.observerList){
            observer.update(this.weather);
        }
    }
}


// Concrete of Observer
class TVDisplay implements Observer {

    private String weather;

    @Override
    public void update(String updatedWeather) {
        this.weather = updatedWeather;
        displayLatestWeather();

    }

    private void displayLatestWeather() {
        System.out.println(STR."Updated weather: \{this.weather} displayed on TVDisplay");
    }

}


class PhoneDisplay implements Observer {

    private String weather;

    @Override
    public void update(String updatedWeather) {
        this.weather = updatedWeather;
        displayLatestWeather();

    }

    private void displayLatestWeather() {
        System.out.println(STR."Updated weather: \{this.weather} displayed on PhoneDisplay");
    }

}

class CarDisplay implements Observer {

    private String weather;

    @Override
    public void update(String updatedWeather) {
        this.weather = updatedWeather;
        displayLatestWeather();

    }

    private void displayLatestWeather() {
        System.out.println(STR."Updated weather: \{this.weather} displayed on CarDisplay");
    }

}