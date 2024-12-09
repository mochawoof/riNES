import javax.swing.*;
import java.awt.*;

class ToolButton extends JButton {
    public ToolButton(ImageIcon icon, String toolTip) {
        setIcon(icon);
        setToolTipText(toolTip);
    }
    public ToolButton(String text, String toolTip) {
        setText(text);
        setToolTipText(toolTip);
    }
    public ToolButton(String text) {
        setText(text);
    }
}