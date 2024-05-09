import javax.swing.*;
import java.awt.*;


public class board_gui extends JFrame {

    public board_gui() {
        setTitle("Chess Board");
        setSize(800, 800); // Increased size to accommodate coordinates
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board_panel chessBoardPanel = new board_panel();
        add(chessBoardPanel);

        setVisible(true);
    }
    
    public static board_gui board = new board_gui();

    public void display(){
        
        board_panel updated_board = new board_panel();
        board.add(updated_board);
        setVisible(true);

    }
}

class board_panel extends JPanel {

    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80; // Adjust the size as needed
    private static final String[] COORDINATES = {"a", "b", "c", "d", "e", "f", "g", "h"};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the grid of brown and white squares
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                // Calculate the position of the square
                int x = col * SQUARE_SIZE;
                int y = row * SQUARE_SIZE;

                // Alternate between brown and white squares
                if ((row + col) % 2 != 0) {
                    g.setColor(new Color(139, 69, 19)); // Brown color
                } else {
                    g.setColor(Color.WHITE);
                }

                // Draw the square
                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
            }
        }

        // Draw the column coordinates (letters) underneath the chessboard
        for (int col = 0; col < BOARD_SIZE; col++) {
            String coordinate = COORDINATES[col];
            g.setColor(new Color(139, 69, 19));
            drawText(g, col * SQUARE_SIZE + SQUARE_SIZE / 2, getHeight() - SQUARE_SIZE / 2 - 65, coordinate);
        }

        // Draw the row coordinates (numbers) to the right of the chessboard
        for (int row = 0; row < BOARD_SIZE; row++) {
            String coordinate = String.valueOf(BOARD_SIZE - row);
            drawText(g, getWidth() - SQUARE_SIZE / 2 -80, row * SQUARE_SIZE + SQUARE_SIZE / 2, coordinate);
        }

        for (chess_piece piece: chess_board.white_pieces()){
            piece.draw(g,this);
        }

        for (chess_piece piece: chess_board.black_pieces()){
            piece.draw(g,this);
        }
    }


    public void update(){
        repaint();
    }

    

    @Override
    public Dimension getPreferredSize() {
        int size = BOARD_SIZE * SQUARE_SIZE;
        return new Dimension(size + SQUARE_SIZE, size + SQUARE_SIZE); // Increase size to accommodate coordinates
    }

    private void drawText(Graphics g, int x, int y, String text) {
        Font font = new Font("Arial", Font.BOLD, 32); // Adjust the font name, style, and size as needed
        g.setFont(font);

        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g.drawString(text, x - width / 2, y + height / 2);
    }
}
