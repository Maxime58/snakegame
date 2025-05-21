package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class GameMenu extends JFrame {
    private JPanel mainPanel = new JPanel();
    private LinkedHashMap<String, Runnable> gameLaunchers = new LinkedHashMap<>();
    private static GameMenu instance;

    public GameMenu() {
        this.setTitle("Game Boy Color Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("🎮 Game Girl Menu 🎮", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 34));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(title);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));


        // adding button for game
        this.add(mainPanel);
        this.setVisible(true);
    }

    public void addGame(String gameName, Runnable launchFunction) {
        JButton button = new JButton(gameName);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            dispose(); // close the menu
            launchFunction.run(); // launch the game
        });

        mainPanel.add(button);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        this.revalidate();
        this.repaint();
    }
}
