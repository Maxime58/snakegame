package darksouls_game;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    private final JLabel imageBattle = new JLabel();
    private final JLabel playerHpLabel = new JLabel();
    private final JLabel bossHpLabel = new JLabel();
    private final JButton attackButton = new JButton("Attack");
    private final JButton estusButton = new JButton("Drink estus");
    private final JButton dodgeButton = new JButton("Shield");
    private final JButton retryButton = new JButton("Retry");
    private JTextArea logArea = new JTextArea();

    public BattlePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //placement of components in a column y; img, health, log, buttons

        ImageIcon icon = new ImageIcon("img/fight.png");
        Image scaled = icon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        imageBattle.setIcon(new ImageIcon(scaled));
        add(imageBattle);

        JPanel statusPanel = new JPanel(new GridLayout(1, 2)); // health "icon" left and right
        statusPanel.add(playerHpLabel);
        statusPanel.add(bossHpLabel);
        add(statusPanel);

        //JTextArea and player cant change it
        logArea.setEditable(false);
        add(new JScrollPane(logArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(attackButton);
        buttonPanel.add(estusButton);
        buttonPanel.add(dodgeButton);
        add(buttonPanel);

        retryButton.setVisible(false);
        add(retryButton);
    }
    public void updateStatus(int playerHp, int bossHp) {
        playerHpLabel.setText("Knight HP: " + Math.max(playerHp, 0));
        bossHpLabel.setText("Boss HP: " + Math.max(bossHp, 0));
    }

    public void log(String text) {
        logArea.append(text + "\n");
    }

    public void disableButtons() {
        attackButton.setEnabled(false);
        estusButton.setEnabled(false);
        dodgeButton.setEnabled(false);
    }
    public JButton getAttackButton(){
        return attackButton;
    }
    public JButton getEstusButton(){
        return estusButton;
    }
    public JButton getDodgeButton(){
        return dodgeButton;
    }
    public JButton getRetryButton(){return retryButton;}
}
