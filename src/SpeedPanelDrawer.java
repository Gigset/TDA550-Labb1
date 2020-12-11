import javax.swing.*;
import java.awt.*;
public class SpeedPanelDrawer extends JPanel{

    public SpeedPanelDrawer(){
        this.setDoubleBuffered(true);
    }

    //Denna metod kallas när vi behöver uppdatera panelen så att den målar om sig
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
