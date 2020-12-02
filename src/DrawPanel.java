import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.IOException;
import java.util.List;
// vi bör överväga att inte ha images i bilklasserna. Vi kan istället ha hashmaps. Å andra sidan behöver koden inte va perfekt, så vi kanske inte ska göra det så komplicerat???
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    List<Car> cars;

    // To keep track of a single cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();


    // TODO: Make this general for all cars
    void moveit(int x, int y) {
        volvoPoint.x = x;
        volvoPoint.y = y;
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Car> carsIn) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        cars = carsIn;

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Car car : cars) {

            g.drawImage(car.getImage(), (int) car.getPosition().getX(), (int) car.getPosition().getY(), null);

        }

    }

}
