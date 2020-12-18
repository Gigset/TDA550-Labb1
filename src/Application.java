import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Application {
    CarModel model;
    CarController controller;

    List<Observer> observers = new ArrayList<>();

    final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());

    public static void main(String[] args) {
        Application app = new Application();

        app.runProgramme();

        app.timer.start();

    }
    public void runProgramme(){
        this.model = new CarModel();
        this.controller = new CarController(model);
        model.vehicles.add(new Volvo240());
        model.vehicles.add(new Saab95());
        model.vehicles.add(new Scania());

        for (int i = 0; i < model.vehicles.size(); i++) {
            model.vehicles.get(i).setPosition(new Point(10, i * 100));
        }

        observers.add(new CarView("Frame N.O 2", controller));
        observers.add(new SpeedPanel(model));

    }


    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(Observer obs : observers){
                obs.refresh();
            }
        }
    }
}
