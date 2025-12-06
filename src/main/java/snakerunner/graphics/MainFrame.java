package snakerunner.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    private static final String TITLE = "Snake Runner";
    private static final double PROPORTION = 0.5;
    private final OptionPanel optionPanel = new OptionPanel();

    public MainFrame(){
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(optionPanel, BorderLayout.CENTER);
        setDimensionFrame();
    }

    private void setDimensionFrame(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)(screensize.width * PROPORTION);
        int height = (int)(screensize.height * PROPORTION);
        setSize(width,height);
    }

    public void display() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}