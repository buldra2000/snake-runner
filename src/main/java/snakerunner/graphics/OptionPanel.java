package snakerunner.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {

    private static final String APPLY = "Apply";
    private static final String BACK = "Back";
    private static final String OPTION = "Option";
    private static final String SOUND = "Sound On / Off";

    private final JPanel soundPanel;
    private final JButton apply;
    private final JButton back;
    private final Color backgrounColor;
    private final JCheckBox checkbox;
    private final JLabel title;
    private final JLabel label;

    public OptionPanel(){
        super();
        soundPanel = new JPanel();
        apply = new JButton(APPLY);
        back = new JButton(BACK);
        backgrounColor = new Color(100,238,100);
        checkbox = new JCheckBox();
        title = new JLabel(OPTION);
        label = new JLabel(SOUND);

        title.setFont(new Font("Arial", Font.BOLD, 32));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(backgrounColor);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        apply.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        soundPanel.setLayout(new BoxLayout(soundPanel, BoxLayout.X_AXIS));
        soundPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkbox.setAlignmentX(Component.CENTER_ALIGNMENT);

        soundPanel.add(label);
        soundPanel.add(checkbox);

        add(title);
        add(Box.createVerticalGlue());
        add(label);
        add(checkbox);
        add(Box.createVerticalGlue());
        add(apply);
        add(back);

        getApply().addActionListener(e -> applyButton());
        getBack().addActionListener(e -> backButton());
    }

    public JButton getApply() {
        return apply;
    }

    public JButton getBack() {
        return back;
    }

    public JCheckBox getCheckbox() {
        return checkbox;
    }

    public void applyButton(){
        System.out.println("Apply button pressed");
    }

    public void backButton(){
        System.out.println("Back button pressed");
    }
}