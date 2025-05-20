package Snake;

import darksouls_game.DarkSoulsWindow;
import guessingGameGUI.GuessingGameGUI;
//import tictactoe.TicTacToe;

public class Laucher {
    public static void main(String[] args) {
        GameMenu menu = new GameMenu();

        menu.addGame("🐍 Snake", () -> new GameFrame());
        menu.addGame("🟡 Tic Tac Toe", () ->TicTacToe.main(new String[0]));
        menu.addGame("🟦 DarkSoul", () -> DarkSoulsWindow.main(new String[0]));
        menu.addGame("🟦 GuessingGame", () -> GuessingGameGUI.main(new String[0]));
    }
}
