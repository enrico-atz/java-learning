package basics.diceroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRollerGUI extends JFrame implements ActionListener {

    private Random random = new Random();
    private JTextField numDiceField;
    private JButton rollButton;
    private JButton resetButton;
    private JPanel dicePanel;
    private JLabel totalLabel;

    public DiceRollerGUI() {
        // Configurazione finestra
        setTitle("Dice Roller");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Pannello superiore (input)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Numero di dadi da lanciare:");
        label.setFont(new Font("Arial", Font.PLAIN, 14));

        numDiceField = new JTextField(5);
        numDiceField.setFont(new Font("Arial", Font.PLAIN, 14));

        rollButton = new JButton("Lancia Dadi");
        rollButton.setFont(new Font("Arial", Font.BOLD, 14));
        rollButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.addActionListener(this);

        topPanel.add(label);
        topPanel.add(numDiceField);
        topPanel.add(rollButton);
        topPanel.add(resetButton);

        // Pannello centrale (dadi)
        dicePanel = new JPanel();
        dicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        dicePanel.setBorder(BorderFactory.createTitledBorder("Risultati"));
        dicePanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(dicePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Pannello inferiore (totale)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        totalLabel = new JLabel("Totale: 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bottomPanel.add(totalLabel);

        // Aggiungi pannelli alla finestra
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton) {
            rollDice();
        } else if (e.getSource() == resetButton) {
            reset();
        }
    }

    private void rollDice() {
        try {
            int numOfDice = Integer.parseInt(numDiceField.getText());

            if (numOfDice <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Devi lanciare almeno 1 dado!",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (numOfDice > 20) {
                JOptionPane.showMessageDialog(
                        this,
                        "Massimo 20 dadi alla volta!",
                        "Errore",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Pulisci il pannello
            dicePanel.removeAll();
            int total = 0;

            // Lancia i dadi
            for (int i = 1; i <= numOfDice; i++) {
                int roll = random.nextInt(1, 7);
                total += roll;

                // Crea pannello per ogni dado
                JPanel singleDiePanel = new JPanel();
                singleDiePanel.setLayout(new BorderLayout());
                singleDiePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                singleDiePanel.setBackground(Color.WHITE);

                JLabel dieLabel = new JLabel("Dado " + i);
                dieLabel.setFont(new Font("Monospaced", Font.BOLD, 10));
                dieLabel.setHorizontalAlignment(SwingConstants.CENTER);

                JTextArea dieArea = new JTextArea(getDieAscii(roll));
                dieArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                dieArea.setEditable(false);
                dieArea.setBackground(Color.WHITE);

                singleDiePanel.add(dieLabel, BorderLayout.NORTH);
                singleDiePanel.add(dieArea, BorderLayout.CENTER);

                dicePanel.add(singleDiePanel);
            }

            // Aggiorna totale
            totalLabel.setText("Totale: " + total);

            // Refresh
            dicePanel.revalidate();
            dicePanel.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Inserisci un numero valido!",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void reset() {
        numDiceField.setText("");
        dicePanel.removeAll();
        totalLabel.setText("Totale: 0");
        dicePanel.revalidate();
        dicePanel.repaint();
    }

    private String getDieAscii(int roll) {
        return switch (roll) {
            case 1 -> """
                 -------
                |       |
                |   ●   |
                |       |
                 -------
                """;
            case 2 -> """
                 -------
                | ●     |
                |       |
                |     ● |
                 -------
                """;
            case 3 -> """
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
                """;
            case 4 -> """
                 -------
                | ●   ● |
                |       |
                | ●   ● |
                 -------
                """;
            case 5 -> """
                 -------
                | ●   ● |
                |   ●   |
                | ●   ● |
                 -------
                """;
            case 6 -> """
                 -------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                 -------
                """;
            default -> "Errore";
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceRollerGUI());
    }
}
