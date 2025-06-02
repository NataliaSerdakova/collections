import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


public class GameTest {

    @Test
    public void testRoundFirstPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Natalya", 10);
        Player p2 = new Player(2, "Ilya", 5);
        game.register(p1);
        game.register(p2);

        int result = game.round("Natalya", "Ilya");
        Assertions.assertEquals(1, result); // первый выигрывает
    }

    @Test
    public void testRoundSecondPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Natalya", 4);
        Player p2 = new Player(2, "Ilya", 8);
        game.register(p1);
        game.register(p2);

        int result = game.round("Natalya", "Ilya");
        Assertions.assertEquals(2, result); // второй выигрывает
    }

    @Test
    public void testRoundDraw() {
        Game game = new Game();
        Player p1 = new Player(1, "Natalya", 7);
        Player p2 = new Player(2, "Ilya", 7);
        game.register(p1);
        game.register(p2);

        int result = game.round("Natalya", "Ilya");
        Assertions.assertEquals(0, result); // ничья
    }

    @Test
    public void testRoundPlayerNotRegisteredThrows() {
        Game game = new Game();
        Player p1 = new Player(1, "Natalya", 10);

        // Не регистрируем второго игрока
        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Natalya", "Unknown");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Unknown", "Natalya");
        });

        // И оба не зарегистрированы
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Unknown1", "Unknown2");
        });
    }

    @Test
    public void testRegisterDuplicateDoesNotAddAgain() {
        Game game = new Game();
        Player p = new Player(1, "Ilya", 10);
        game.register(p);
        game.register(p);
        // Проверяем что список содержит только одного игрока:
        Assertions.assertEquals(1, ((ArrayList<Player>) game.players).size());
    }

    @Test
    public void testGetId() {
        Player player = new Player(15, "Ilya", 50);
        Assertions.assertEquals(15, player.getId());
    }

}
