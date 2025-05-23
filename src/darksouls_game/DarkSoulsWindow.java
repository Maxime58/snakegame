package darksouls_game;

import javax.swing.*;
import java.awt.*;

public class DarkSoulsWindow extends JFrame {
    private final CardLayout cardLayout = new CardLayout(); //smooth transition
    private final JPanel mainPanel = new JPanel(cardLayout); // first intro dan battle
    private final BattleManager battle; //hang af van andere objecten
    private final IntroPanel introPanel = new IntroPanel();
    private final BattlePanel battlePanel = new BattlePanel();

    public DarkSoulsWindow() {
        Player player = new Player();
        Boss boss = new Boss();
        battle = new BattleManager(player, boss);

        // Panel with buttons
        battlePanel.getAttackButton().addActionListener(e -> handleAction("attack"));
        battlePanel.getEstusButton().addActionListener(e -> handleAction("heal"));
        battlePanel.getDodgeButton().addActionListener(e -> handleAction("dodge"));
        battlePanel.getRetryButton().addActionListener(e -> {
            dispose(); //restart game end close old window
            new DarkSoulsWindow();
        });
        //Screen, icon, exit
        setTitle("Dark Souls Mini");
        setSize(600, 500); //x-dimension and y-dimension
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("img/256x256.png");
        setIconImage(icon.getImage());

        battlePanel.updateStatus(battle.getPlayerHp(), battle.getBossHp());
        battlePanel.log("You woke up by the bonfire... Forward into battle!");

        setVisible(true); // my screen

        mainPanel.add(introPanel, "intro");
        mainPanel.add(battlePanel, "battle");
        add(mainPanel);
        startIntroSequence();
    }

    private void startIntroSequence() {
        cardLayout.show(mainPanel, "intro");
        introPanel.setImage("img/bonfire.png");
        introPanel.setSubtitle("You woke up by the bonfire...");
        Timer t1 = new Timer(3500, e1 -> {
            introPanel.setImage("img/dark.png");
            introPanel.setSubtitle("You are going to the dark...");

            Timer t2 = new Timer(3500, e2 -> {
                introPanel.setImage("img/fight.png");
                introPanel.setSubtitle("for the battle!");
                Timer t3 = new Timer(3500, e3 -> {
                    startBattleUI();
                });
                t3.setRepeats(false);
                t3.start();
            });
            t2.setRepeats(false);
            t2.start();
        });
        t1.setRepeats(false);
        t1.start();
    }

    public void handleAction(String action) {
        if (battle.isGameOver()) return; //nothing do if game finish

        switch (action) {
            case "attack" -> battlePanel.log(battle.playerAttack());
            case "heal" -> battlePanel.log(battle.playerHeal());
            case "dodge" -> battlePanel.log(battle.playerDodge());
        }

        if (!battle.isGameOver()) {
            battlePanel.log(battle.bossTurn()); //attack of boss if knight is alive
        }

        battlePanel.updateStatus(battle.getPlayerHp(), battle.getBossHp()); //update hp

        if (battle.isGameOver()) {
            if (battle.playerWon()) {
                battlePanel.log("VICTORY" + "\nSouls received: 500");
            } else {
                battlePanel.log("YOU DIED");
            }
            battlePanel.disableButtons();
            new Timer(1000, e -> {
                battlePanel.getRetryButton().setVisible(true);
                battlePanel.revalidate(); //update panel
                battlePanel.repaint();
            }).start();
        }
    }

    private void startBattleUI() {
        cardLayout.show(mainPanel, "battle"); //after intro to battle
        battlePanel.updateStatus(battle.getPlayerHp(), battle.getBossHp()); //update hp
        battlePanel.log("Hint: knight has 3 estus (heal). " +
                "You can use a shield to protect yourself! " +
                "\nRules: this is a turn based battle! After your choice the boss will attack you immediately!" +
                "\nHe is coming... attack!");
    }

    public static void main(String[] args) {
        new DarkSoulsWindow();
    }
}



