import java.awt.*;

public class GraphicHello {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(300,200);
        panel.setBackground(Color.MAGENTA);
        Graphics g=panel.getGraphics();
        // g.drawLine(25,75,175,25);
        g.setColor(Color.YELLOW);
        g.fillOval(20,20,260,160);
        g.setColor(Color.GREEN);
        g.drawOval(20,20,260,160);
        g.setColor(Color.BLUE); 
        g.setFont(new Font("SansSerif",Font.BOLD,30));
        g.drawString("Hello Mills HS!",60,100);
        g.setColor(Color.RED); 
        g.setFont(new Font("Serif",Font.PLAIN,15));
        g.drawString("From Steve",150,150);
    }
}