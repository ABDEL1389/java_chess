import javax.swing.*;
import java.awt.*;

public class board_gui{
    public board_gui(){
        JFrame frame = new JFrame("Chess");
        frame.setSize(720, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel for the grid
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(8, 8));

        // Add buttons to the grid panel
        for (int row = 8; row > 0; row--) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton(Character.toString((char) (col + 97)) + Integer.toString(row));
                button.setPreferredSize(new Dimension(80, 80));
                if ((row + col) % 2 == 1) {
                    button.setBackground(new Color(139, 69, 19));
                }
                gridPanel.add(button);
            }
        }

        JLabel label = new JLabel("a1");
        label.setBounds(120, 670, 50, 40);
        frame.add(label);

        // Add the grid panel to the frame
        frame.getContentPane().add(gridPanel);

        // Adjust frame size and make it visible
        frame.pack();
        frame.setVisible(true);
    }
}
