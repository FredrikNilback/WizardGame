import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        
        Player player = new Player("Syrca", 1, 1, 1, true);
        Enemy NoMonster = new Enemy("NoMonster", 0, null, null);
        new MainMenu();
        //new GameView(player);

    }  
}
