import javax.swing.*;
import java.awt.*;

class Emulator extends JComponent {
    public Emulator() {}
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int width = 256;
        int height = 240;
        
        float aw = ((float) width) / ((float) height); // Get width from height
        float ah = ((float) height) / ((float) width); // Get height from width
        
        int wh = (int) (getHeight() * aw); // Width for full height
        int hw = (int) (getWidth() * ah); // Height for full width
        
        int x = 0;
        int y = 0;
        int w = getWidth();
        int h = getHeight();
        
        if (wh > getWidth()) {
            // Use hw
            y = (getHeight() / 2) - (hw / 2);
            h = hw;
        } else {
            // Use wh
            x = (getWidth() / 2) - (wh / 2);
            w = wh;
        }
        
        int px = wh / 256;
        
        g.setColor(Color.BLACK);
        g.fillRect(x, y, w, h);
    }
}