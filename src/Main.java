import Snake.GameFrame;
import Snake.GameMenu;
import darksouls_game.DarkSoulsWindow;
import guessingGameGUI.MainApp;
import tictactoe.TicTacToe;

public class Main {
    public static void main(String[] args) {
        GameMenu menu = new GameMenu();

        menu.addGame("🐍 Snake", () -> new GameFrame());
        menu.addGame("🟡 Tic Tac Toe", () -> TicTacToe.main(new String[0]));
        menu.addGame("🟦 DarkSoul", () -> DarkSoulsWindow.main(new String[0]));
        menu.addGame("🟦 GuessingGame", () -> MainApp.main(new String[0]));

    }
}
