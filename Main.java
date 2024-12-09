import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

class Main {
    private static JFrame frame;
    
    private static ToolButton openButton;
    private static ToolButton restartButton;
    private static ToolButton playPauseButton;
    private static ToolButton controlsButton;
    private static ToolButton settingsButton;
    
    public static void main(String[] args) {
        Settings.init();
        setupFrame();
        setupEvents();
    }
    private static void setLaf(String name) {
        try {
            boolean wasSet = false;
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals(name)) {
                    wasSet = true;
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            SwingUtilities.updateComponentTreeUI(frame);
            if (!wasSet) {
                setLaf("Metal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printLafs() {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + ": " + info.getClassName());
        }
    }
    private static void setupFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setLaf(Settings.get("Theme"));
        frame = new JFrame("RiNES");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(Res.getAsImage("res/mr retro icon.png"));
        
        JToolBar tool = new JToolBar("Tools");
        frame.add(tool, BorderLayout.PAGE_START);
        
        openButton = new ToolButton("Open");
        tool.add(openButton);
        
        restartButton = new ToolButton("Restart");
        tool.add(restartButton);
        
        playPauseButton = new ToolButton("Play");
        tool.add(playPauseButton);
        
        controlsButton = new ToolButton("Controls");
        tool.add(controlsButton);
        
        settingsButton = new ToolButton("Settings");
        tool.add(settingsButton);
        
        Emulator emu = new Emulator();
        frame.add(emu, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
    private static void setupEvents() {
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                c.setFileFilter(new FileNameExtensionFilter("INES 1.0 Files (.nes)", "nes"));
                if (c.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    
                }
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opt = Settings.showEditWindow(frame);
                if (opt == Settings.OK || opt == Settings.RESET) {
                    frame.dispose();
                    main(new String[0]);
                }
            }
        });
    }
}