package Basics.JavaSlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.EmptyBorder;

public class JavaSlotGUI extends JFrame {

    private int balance = 100;
    private String[] symbols = {"🍒", "🍉", "🍋", "⭐"};

    // Componenti GUI
    private JLabel balanceLabel;
    private JLabel[] slotLabels = new JLabel[3];
    private JTextField betField;
    private JButton spinButton;
    private JTextArea messageArea;
    private JPanel slotPanel;

    public JavaSlotGUI() {
        setTitle("🎰 JAVASLOT 🎰");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        // Panel principale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(34, 139, 34));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(34, 139, 34));
        JLabel titleLabel = new JLabel("🍒🍉 JAVASLOT 🍋⭐");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.YELLOW);
        headerPanel.add(titleLabel);

        // Balance panel
        JPanel balancePanel = new JPanel();
        balancePanel.setBackground(new Color(34, 139, 34));
        balanceLabel = new JLabel("Saldo: € " + balance);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 24));
        balanceLabel.setForeground(Color.WHITE);
        balancePanel.add(balanceLabel);

        // Slot panel (i 3 simboli)
        slotPanel = new JPanel();
        slotPanel.setLayout(new GridLayout(1, 3, 10, 0));
        slotPanel.setBackground(new Color(34, 139, 34));
        slotPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        for (int i = 0; i < 3; i++) {
            slotLabels[i] = new JLabel("❓", SwingConstants.CENTER);
            slotLabels[i].setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
            slotLabels[i].setOpaque(true);
            slotLabels[i].setBackground(Color.WHITE);
            slotLabels[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
            slotPanel.add(slotLabels[i]);
        }

        // Control panel (scommessa e bottone)
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(34, 139, 34));
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JLabel betLabel = new JLabel("Scommessa:");
        betLabel.setFont(new Font("Arial", Font.BOLD, 18));
        betLabel.setForeground(Color.WHITE);

        betField = new JTextField(8);
        betField.setFont(new Font("Arial", Font.PLAIN, 18));
        betField.setText("10");

        spinButton = new JButton("🎰 SPIN!");
        spinButton.setFont(new Font("Arial", Font.BOLD, 20));
        spinButton.setBackground(new Color(255, 215, 0));
        spinButton.setForeground(Color.BLACK);
        spinButton.setFocusPainted(false);
        spinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        controlPanel.add(betLabel);
        controlPanel.add(betField);
        controlPanel.add(spinButton);

        // Message area
        messageArea = new JTextArea(4, 40);
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 14));
        messageArea.setBackground(new Color(240, 240, 240));
        messageArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JScrollPane scrollPane = new JScrollPane(messageArea);

        // Aggiungi tutto al panel principale
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(34, 139, 34));
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(balancePanel, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(slotPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBackground(new Color(34, 139, 34));
        bottomPanel.add(controlPanel, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Action listener per il bottone
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spin();
            }
        });

        // Enter key per girare
        betField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spin();
            }
        });

        addMessage("Benvenuto! Saldo iniziale: € " + balance);
        addMessage("Piazza la tua scommessa e premi SPIN!");
    }

    private void spin() {
        // Validazione input
        int bet;
        try {
            bet = Integer.parseInt(betField.getText());
        } catch (NumberFormatException ex) {
            addMessage("❌ Inserisci un numero valido!");
            return;
        }

        if (bet > balance) {
            addMessage("❌ Fondi insufficienti!");
            return;
        }

        if (bet <= 0) {
            addMessage("❌ Scommessa non valida! (almeno 1 €)");
            return;
        }

        // Disabilita il bottone durante lo spin
        spinButton.setEnabled(false);
        balance -= bet;
        updateBalance();

        addMessage("\n🎰 SPINNING...");

        // Animazione dello spin
        Timer animationTimer = new Timer(100, null);
        final int[] counter = {0};

        animationTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostra simboli casuali durante l'animazione
                for (int i = 0; i < 3; i++) {
                    slotLabels[i].setText(symbols[new Random().nextInt(symbols.length)]);
                }

                counter[0]++;

                // Ferma l'animazione dopo 15 iterazioni
                if (counter[0] >= 15) {
                    animationTimer.stop();
                    showResult(bet);
                }
            }
        });

        animationTimer.start();
    }

    private void showResult(int bet) {
        // Genera risultato finale
        String[] row = spinRow(symbols);

        for (int i = 0; i < 3; i++) {
            slotLabels[i].setText(row[i]);
        }

        int payout = getPayout(row, bet);

        if (payout > 0) {
            addMessage("🎉 HAI VINTO € " + payout + "!");
            balance += payout;
        } else {
            addMessage("😢 Hai perso € " + bet);
        }

        updateBalance();

        // Controlla game over
        if (balance <= 0) {
            addMessage("\n💥 SALDO TERMINATO | GAME OVER 💥");
            spinButton.setEnabled(false);

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Il tuo saldo è terminato!\nVuoi ricominciare?",
                    "Game Over",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                resetGame();
            }
        } else {
            spinButton.setEnabled(true);
        }
    }

    private void resetGame() {
        balance = 100;
        updateBalance();
        messageArea.setText("");
        addMessage("🎮 Nuovo gioco! Saldo iniziale: € " + balance);

        for (int i = 0; i < 3; i++) {
            slotLabels[i].setText("❓");
        }

        spinButton.setEnabled(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Saldo: € " + balance);
    }

    private void addMessage(String message) {
        messageArea.append(message + "\n");
        messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }

    private String[] spinRow(String[] symbols) {
        Random random = new Random();
        String[] row = new String[3];

        for(int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }

    private int getPayout(String[] row, int bet) {
        if(row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch(row[0]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }

        if(row[0].equals(row[1]) || row[1].equals(row[2])) {
            return switch(row[1]) {
                case "🍒" -> bet * 1;
                case "🍉" -> bet * 2;
                case "🍋" -> bet * 3;
                case "⭐" -> bet * 4;
                default -> 0;
            };
        }

        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JavaSlotGUI());
    }
}