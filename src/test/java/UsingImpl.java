import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class UsingImpl implements SomeImpl, AnotherImpl {
    @Override
    public void go() {

    }

    @Test
    void goTest() {
        go();
    }
    /**
    Есть строка вида "aaabbcccd".
    Задача посчитать количество каждой буквы и вывести.
    Например : "3a2b3c1d"
     */
    @Test
    //TODO доделать
    void findSymbolsHomeWorkYandex() {
        String inputStr = "aaabbcccd";
        HashSet<String> set = new HashSet<>();

        for (int i=0; i< inputStr.length(); i++) {

        }
    }
}
