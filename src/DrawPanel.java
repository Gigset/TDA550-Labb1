import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.List;
// vi bör överväga att inte ha images i bilklasserna. Vi kan istället ha hashmaps. Å andra sidan behöver koden inte va perfekt, så vi kanske inte ska göra det så komplicerat???
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    List<Vehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> carsIn) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        vehicles = carsIn;

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle v : vehicles) {

            g.drawImage(v.getImage(), (int) v.getPosition().getX(), (int) v.getPosition().getY(), null);

        }

    }

}
