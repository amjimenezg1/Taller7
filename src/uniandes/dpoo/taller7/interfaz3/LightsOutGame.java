package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class LightsOutGame extends JFrame {
    public LightsOutGame() {
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        TopPanel topPanel = new TopPanel();
        RightPanel rightPanel = new RightPanel();
        BottomPanel bottomPanel = new BottomPanel();
        BoardPanel boardPanel = new BoardPanel(5);

        add(topPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(boardPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LightsOutGame frame = new LightsOutGame();
            frame.setVisible(true);
        });
    }
}

class TopPanel extends JPanel {
    public TopPanel() {
        setLayout(new FlowLayout());

        add(new JLabel("Tamaño"));

        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        add(sizeComboBox);

        add(new JLabel("Dificultad"));

        JRadioButton easyButton = new JRadioButton("Fácil");
        JRadioButton mediumButton = new JRadioButton("Medio");
        JRadioButton hardButton = new JRadioButton("Difícil");

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyButton);
        difficultyGroup.add(mediumButton);
        difficultyGroup.add(hardButton);

        add(easyButton);
        add(mediumButton);
        add(hardButton);
    }
}

class RightPanel extends JPanel {
    public RightPanel() {
        setLayout(new GridLayout(4, 1, 10, 10));

        add(new JButton("NUEVO"));
        add(new JButton("REINICIAR"));
        add(new JButton("TOP-10"));
        add(new JButton("CAMBIAR JUGADOR"));
    }
}

class BottomPanel extends JPanel {
    public BottomPanel() {
        setLayout(new FlowLayout());

        add(new JLabel("Jugadas:"));
        JTextField movesField = new JTextField("0", 5);
        movesField.setEditable(false);
        add(movesField);

        add(new JLabel("Jugador:"));
        JTextField playerField = new JTextField(10);
        add(playerField);
    }
}

class BoardPanel extends JPanel {
    private int gridSize;

    public BoardPanel(int gridSize) {
        this.gridSize = gridSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / gridSize;
        int cellHeight = height / gridSize;

        g2d.setColor(Color.YELLOW);

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int x = i * cellWidth;
                int y = j * cellHeight;
                g2d.fillRect(x, y, cellWidth, cellHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, cellWidth, cellHeight);
                g2d.setColor(Color.YELLOW);
            }
        }
    }

    public void setGridSize(int newSize) {
        this.gridSize = newSize;
        repaint();
    }
}