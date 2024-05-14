package se.reky.hakan.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

public class GameUtilTest {
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_NullInput() {
        GameUtil gameUtil = new GameUtil();

        Assertions.assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized(null);
        });
    }
}
