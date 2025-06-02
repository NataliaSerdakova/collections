import java.util.ArrayList;
import java.util.List;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    private Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = findByName(playerName1);
        Player p2 = findByName(playerName2);

        if (p1 == null || p2 == null) {
            throw new NotRegisteredException("Один или оба игнрока не зарегистрированы");
        }

        if (p1.getStrength() > p2.getStrength()) {
            return 1; // первый выигрывает
        } else if (p2.getStrength() > p1.getStrength()) {
            return 2; // второй выигрывает
        } else {
            return 0; // ничья
        }
    }
}
