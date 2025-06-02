import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class GameTest {

    @Test
    public void testRoundFirstPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Наталья", 10);
        Player p2 = new Player(2, "Илья", 5);
        game.register(p1);
        game.register(p2);

        int expected = 1;
        int actual = game.round("Наталья", "Илья");

        Assertions.assertEquals(expected, actual); // первый выигрывает
    }

    @Test
    public void testRoundSecondPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Наталья", 4);
        Player p2 = new Player(2, "Илья", 8);
        game.register(p1);
        game.register(p2);

        int expected = 2;
        int actual = game.round("Наталья", "Илья");

        Assertions.assertEquals(expected, actual); // второй выигрывает
    }

    @Test
    public void testRoundDraw() {
        Game game = new Game();
        Player p1 = new Player(1, "Наталья", 7);
        Player p2 = new Player(2, "Илья", 7);
        game.register(p1);
        game.register(p2);

        int expected = 0;
        int actual = game.round("Наталья", "Илья");

        Assertions.assertEquals(expected, actual); // ничья
    }

    @Test
    public void testRoundPlayerNotRegisteredThrows() {
        Game game = new Game();
        Player p1 = new Player(1, "Наталья", 10);

        // Не регистрируем второго игрока
        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Наталья", "Коля"));
    }

    @Test
    public void testRoundPlayerNotRegisteredThrows1() {
        Game game = new Game();
        Player p1 = new Player(1, "Наталья", 10);

        // Не регистрируем второго игрока
        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Наталья"));
    }

    @Test
    public void testGetId() {
        Player player = new Player(15, "Ilya", 50);
        Assertions.assertEquals(15, player.getId());
    }
}
