import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    List<Point> points = new ArrayList<>();
    List<BufferedImage> image = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        for (Vehicle v : vehicles) {
            addCarImageAndPos(v);
        }
    }
    //method to add image and point to our panel.
    public void addCarImageAndPos(Vehicle v) {

        points.add(v.getPosition());
        try {
            image.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + v.getModelName() + ".jpg")));
        } catch (IOException E) {
            System.out.println(E.getMessage() + v.getModelName());
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
for (int i = 0; i < image.size(); i++){
    g.drawImage(image.get(i),points.get(i).x,points.get(i).y,null);
     //   for (Vehicle v : vehicles) {
       //     g.drawImage(image.get(vehicles.indexOf(v)),(int) v.getPosition().getX(), (int) v.getPosition().getY(), null);
        }

    }
}
