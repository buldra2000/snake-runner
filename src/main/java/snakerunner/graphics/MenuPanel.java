package snakerunner.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    private static final String LABEL = " Welcome to Snake Runner";
    private static final String START = "Start";
    private static final String OPTION = "Option";
    private static final String EXIT = "Exit";

    private final JButton start;
    private final JButton option;
    private final JButton exit;
    private final JLabel label;
    private final Color backgrounColor;

    public MenuPanel(){
        super();
        start = new JButton(START);
        option = new JButton(OPTION);
        exit = new JButton(EXIT);
        label = new JLabel(LABEL);
        backgrounColor = new Color(100,238,100);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(backgrounColor);
        
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        option.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(label);
        add(Box.createVerticalGlue());
        add(start);
        add(option);
        add(exit);
        add(Box.createVerticalGlue());
        
        getStartButton().addActionListener(e -> pressedStartbutton());
        getOptionButton().addActionListener(e -> pressedOptionbutton());
        getExitButton().addActionListener(e -> pressedExitbutton());
    }

    public JButton getStartButton() {
        return start;
    }

    public JButton getOptionButton() {
        return option;
    }

    public JButton getExitButton() {
        return exit;
    }

    public void pressedStartbutton(){
        System.out.println("Start button pressed");
    }

    public void pressedOptionbutton(){
        System.out.println("Option button pressed");
    }

    public void pressedExitbutton(){
        System.out.println("Exit button pressed");
        System.exit(0);
    }
}