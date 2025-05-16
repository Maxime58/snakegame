package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 80;
    GamePanel (){}
    public void startGame(){}
    public void paintCoponent(Graphics g){}
    public void draw (Graphics g){}
    public void move (){}
    public void checkApple(){}
    public void gameOver(Graphics g){}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public class MuKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){}
    }
    // all the methodes i'll we availible here

}
