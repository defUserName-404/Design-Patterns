package buttons;

import javax.swing.*;
import java.awt.*;

public class LinuxButton implements Button {
    private final JPanel panel = new JPanel();
    private final JFrame frame = new JFrame();
    JButton button;

    @Override
    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World From Linux");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 129));
        label.setFont(new Font("Dialog", Font.BOLD, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(e -> {
            frame.setVisible(false);
            System.exit(0);
        });
    }
}
