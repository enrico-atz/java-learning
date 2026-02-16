package basics.bankingprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingProgramGUI extends JFrame implements ActionListener {

    private double balance = 0;

    // Componenti grafici
    private JLabel balanceLabel;
    private JButton showBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;
    private JPanel mainPanel;

    public BankingProgramGUI() {
        // Configurazione finestra principale
        setTitle("Simple Bank");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la finestra

        // Pannello principale
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Titolo
        JLabel titleLabel = new JLabel("SIMPLE BANK", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel);

        // Label saldo
        balanceLabel = new JLabel("Saldo: € 0,00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(balanceLabel);

        // Bottoni
        showBalanceButton = new JButton("Mostra Saldo");
        depositButton = new JButton("Depositare");
        withdrawButton = new JButton("Prelevare");
        exitButton = new JButton("Esci");

        // Stile bottoni
        styleButton(showBalanceButton);
        styleButton(depositButton);
        styleButton(withdrawButton);
        styleButton(exitButton);

        // Aggiungi listener ai bottoni
        showBalanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Aggiungi bottoni al pannello
        mainPanel.add(showBalanceButton);
        mainPanel.add(depositButton);
        mainPanel.add(withdrawButton);
        mainPanel.add(exitButton);

        // Aggiungi pannello alla finestra
        add(mainPanel);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setFocusPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showBalanceButton) {
            showBalance();
        }
        else if (e.getSource() == depositButton) {
            deposit();
        }
        else if (e.getSource() == withdrawButton) {
            withdraw();
        }
        else if (e.getSource() == exitButton) {
            exit();
        }
    }

    private void showBalance() {
        JOptionPane.showMessageDialog(
                this,
                String.format("Il tuo saldo è: € %,.2f", balance),
                "Saldo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void deposit() {
        String input = JOptionPane.showInputDialog(
                this,
                "Inserisci l'importo da depositare:",
                "Depositare",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input != null && !input.isEmpty()) {
            try {
                double amount = Double.parseDouble(input.replace(",", "."));

                if (amount < 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Non puoi depositare una somma negativa.",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    balance += amount;
                    updateBalanceLabel();
                    JOptionPane.showMessageDialog(
                            this,
                            String.format("Hai depositato: € %,.2f", amount),
                            "Deposito Effettuato",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Importo non valido!",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void withdraw() {
        String input = JOptionPane.showInputDialog(
                this,
                "Inserisci l'importo da prelevare:",
                "Prelevare",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input != null && !input.isEmpty()) {
            try {
                double amount = Double.parseDouble(input.replace(",", "."));

                if (amount < 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Non puoi prelevare una somma negativa.",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (amount > balance) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Fondi insufficienti!",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    balance -= amount;
                    updateBalanceLabel();
                    JOptionPane.showMessageDialog(
                            this,
                            String.format("Hai prelevato: € %,.2f", amount),
                            "Prelievo Effettuato",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Importo non valido!",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void updateBalanceLabel() {
        balanceLabel.setText(String.format("Saldo: € %,.2f", balance));
    }

    private void exit() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Sei sicuro di voler uscire?",
                "Conferma Uscita",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    this,
                    "Arrivederci!",
                    "Simple Bank",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Esegui l'interfaccia grafica nel thread EDT
        SwingUtilities.invokeLater(() -> new BankingProgramGUI());
    }
}