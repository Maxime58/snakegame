package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 80;
    static final int GAME_UNITS = (WIDTH*HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){}
    }
    GamePanel (){
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.CYAN);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        newApple();               // génère une première pomme aléatoire
        running = true;           // on indique que le jeu est en cours
        timer = new Timer(DELAY, this); // crée un timer qui appelle actionPerformed() à chaque "tick"
        timer.start();
    }
    public void paintCoponent(Graphics g){
        super.paintComponent(g); //
        draw(g);
    }
    public void draw (Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);


    }
    public void move (){}
    public void checkApple(){}
    public void gameOver(Graphics g){}
    public void newApple() {
        appleX = random.nextInt((int)(WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // all the methodes i'll we availible here

}
