package basics.rps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RPS_GUI extends JFrame {

    private JLabel titleLabel;
    private JLabel roundLabel;
    private JLabel scoreLabel;
    private JLabel resultLabel;
    private JLabel computerChoiceLabel;

    private JButton sassoButton;
    private JButton cartaButton;
    private JButton forbiceButton;
    private JButton resetButton;

    private int round;
    private int score;
    private Random random;
    private String[] choices = {"sasso", "carta", "forbice"};

    public RPS_GUI() {
        random = new Random();
        round = 0;
        score = 0;

        setTitle("Sasso - Carta - Forbice");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Panel superiore con titolo e info
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(52, 73, 94));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("SASSO - CARTA - FORBICE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        roundLabel = new JLabel("Round: 1/5");
        roundLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        roundLabel.setForeground(Color.WHITE);
        roundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        scoreLabel = new JLabel("Punteggio: 0");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(titleLabel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        topPanel.add(roundLabel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(scoreLabel);

        // Panel centrale con risultati
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        computerChoiceLabel = new JLabel("Fai la tua mossa!");
        computerChoiceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        computerChoiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(computerChoiceLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(resultLabel);

        // Panel inferiore con bottoni
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 2, 15, 15));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));

        sassoButton = createGameButton("🪨 SASSO", new Color(231, 76, 60));
        cartaButton = createGameButton("📄 CARTA", new Color(52, 152, 219));
        forbiceButton = createGameButton("✂️ FORBICE", new Color(46, 204, 113));
        resetButton = createGameButton("🔄 NUOVA PARTITA", new Color(149, 165, 166));

        resetButton.setEnabled(false);

        bottomPanel.add(sassoButton);
        bottomPanel.add(cartaButton);
        bottomPanel.add(forbiceButton);
        bottomPanel.add(resetButton);

        // Aggiungi action listeners
        sassoButton.addActionListener(new GameButtonListener("sasso"));
        cartaButton.addActionListener(new GameButtonListener("carta"));
        forbiceButton.addActionListener(new GameButtonListener("forbice"));
        resetButton.addActionListener(e -> resetGame());

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createGameButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private class GameButtonListener implements ActionListener {
        private String playerChoice;

        public GameButtonListener(String choice) {
            this.playerChoice = choice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            playRound(playerChoice);
        }
    }

    private void playRound(String playerChoice) {
        round++;

        String computerChoice = choices[random.nextInt(3)];

        computerChoiceLabel.setText("CPU ha scelto: " + computerChoice.toUpperCase());

        if (playerChoice.equals(computerChoice)) {
            resultLabel.setText("PAREGGIO");
            resultLabel.setForeground(new Color(243, 156, 18));
        } else if ((playerChoice.equals("sasso") && computerChoice.equals("forbice")) ||
                (playerChoice.equals("carta") && computerChoice.equals("sasso")) ||
                (playerChoice.equals("forbice") && computerChoice.equals("carta"))) {
            resultLabel.setText("HAI VINTO!");
            resultLabel.setForeground(new Color(46, 204, 113));
            score++;
        } else {
            resultLabel.setText("HAI PERSO!");
            resultLabel.setForeground(new Color(231, 76, 60));
        }

        roundLabel.setText("Round: " + round + "/5");
        scoreLabel.setText("Punteggio: " + score);

        if (round == 5) {
            endGame();
        }
    }

    private void endGame() {
        sassoButton.setEnabled(false);
        cartaButton.setEnabled(false);
        forbiceButton.setEnabled(false);
        resetButton.setEnabled(true);

        String message = "PARTITA TERMINATA!\n\nPunteggio finale: " + score + "/5";
        JOptionPane.showMessageDialog(this, message, "Fine Partita", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetGame() {
        round = 0;
        score = 0;

        roundLabel.setText("Round: 1/5");
        scoreLabel.setText("Punteggio: 0");
        computerChoiceLabel.setText("Fai la tua mossa!");
        resultLabel.setText(" ");

        sassoButton.setEnabled(true);
        cartaButton.setEnabled(true);
        forbiceButton.setEnabled(true);
        resetButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RPS_GUI());
    }
}
