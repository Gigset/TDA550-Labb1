
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class SpeedPanel extends JFrame implements Observer{
    private static final int X = 200;
    private static final int Y = 200;
    private int cars;
    private CarModel carm;

    SpeedPanelDrawer spd;

    List<JLabel> vehicleLabels = new ArrayList<>();

    JPanel panel = new JPanel();

    public SpeedPanel(CarModel model) {
        this.carm = model;
        this.cars = model.vehicles.size();
        this.spd = new SpeedPanelDrawer();
        constructLabel();
    }

    void initializeLabels() {
        this.setPreferredSize(new Dimension(X, Y));

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        this.add(spd);


        panel.setLayout(new GridLayout(10, 1));

        int idx = 0;
        for (JLabel vl : vehicleLabels) {
            panel.add(vl, idx);
            idx++;
        }
        this.add(panel);

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

        private void constructLabel () {
            for (Vehicle v : carm.vehicles) {
                vehicleLabels.add(new JLabel("Model:" + v.getModelName() + " Speed" + v.getCurrentSpeed()));
            }
        }

        public void refreshAllLabels(){
        vehicleLabels = new ArrayList<>();
        this.removeAll();
        initializeLabels();
        this.cars = carm.getVehicles().size();
        }

        @Override
        public void refresh(){
        if(cars != carm.vehicles.size()){
            refreshAllLabels();
        }

            for(Vehicle v : carm.vehicles){
                for(JLabel vl : vehicleLabels){
                    if(vl.toString().contains(v.getModelName())){
                        vl.setText(v.getModelName() + " has speed" + v.getCurrentSpeed());
                    }
                }
            }
            this.repaint();
        }


}

