import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;


public class CarView extends JFrame implements Observer {
    private static final int X = 1000;
    private static final int Y = 600;
    List<Vehicle> vehicles;

    CarController carC;
    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();

    int gasOrBrakeAmount = 50;
    JLabel gasLabel = new JLabel("Amount of gas or brake");

    JPanel brakePanel = new JPanel();

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add a car");
    JButton removeButton = new JButton("Remove a car");


    // Constructor
    public CarView(String framename, CarController cc) {
        this.carC = cc;
        try {
            drawPanel = new DrawPanel(X, Y - 240, carC.model.vehicles);
        } catch (IOException e) {
        }

        initComponents(framename);
    }

    // Sets everything in place and fits everything

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(gasOrBrakeAmount, //initial value
                        0, //min
                        100, //max
                        1);//step

        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasOrBrakeAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        brakePanel.add(gasLabel, BorderLayout.PAGE_START);
        brakePanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
        this.add(brakePanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeButton, 7);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 100, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 100, 200));
        this.add(stopButton);

        // This actionListener is for the gas button only


        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasOrBrakeAmount);

            }
        });
/**
 *
 *
 * actionlistener for the start button
 */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startEngine();
            }
        });

        /**
         * actionlistener for the stop button
         */

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopEngine();
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasOrBrakeAmount);
            }
        });
        /**
         * actionlistener for the turboOn button
         */

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.setTurboOn();
            }
        });

        /**
         * actionlistener for the turboOff button
         */

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.setTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.scaniaLiftBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.scaniaLowerBed();
            }
        });


        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.addCar();
                drawPanel.addCarImageAndPos(carC.model.vehicles.get(carC.model.vehicles.size() - 1));
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drawPanel.image.size() == 0) {
                    drawPanel.image.remove(0);
                }
                carC.removeCar();
                drawPanel.image.remove((drawPanel.image.size() - 1));
            }
        });

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void refresh() {
        for (Vehicle vehicle : carC.model.vehicles) {

            carC.model.turnAroundCar(vehicle);
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition().getX());
            int y = (int) Math.round(vehicle.getPosition().getY());
            // repaint() calls the paintComponent method of the panel
            drawPanel.repaint();
        }
    }
}