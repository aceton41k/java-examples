import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Log
public class MainTests {


    @BeforeEach
    void setUp() {
    }

    String[] strings = {"123", "1234"};





    @Test
    void mapStringTest() {
        String str = "awiurysjkcbsdjkfyhweuirtgadascvhbdvwekruweoituykfxzgbfdasiudjskh";
        System.out.println(process(str));
    }

    @Test
    void mapIntTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        System.out.println(process(list));
    }

    static Map<Integer, Integer> process(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i)))
                map.replace(list.get(i), map.get(list.get(i)) + 1);
            else {
                map.put(list.get(i), 1);
            }

        }
        return map;
    }

    static Map<String, Integer> process(String inputStr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < inputStr.length(); i++) {
            if (map.containsKey(inputStr.substring(i, i + 1)))
                map.replace(inputStr.substring(i, i + 1), map.get(inputStr.substring(i, i + 1)) + 1);
            else {
                map.put(inputStr.substring(i, i + 1), 1);
            }

        }
        return map;
    }

//    static String process(String inputStr) {
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i < inputStr.length(); i++) {
//            if (sb.toString().contains(inputStr.substring(i, i + 1)))
//                //sb.replace(inputStr.substring(i, i + 1)). inputStr.substring(i, i + 1))+1);
//                sb.replace(inputStr.indexOf(inputStr.substring(i, i + 1)),
//                        inputStr.indexOf(inputStr.substring(i, i + 1)) + 1, "123");
//            else {
//                sb.insert();
//            }
//
//        }
//        return outputStr;
//    }

    @Test
    public void regexpTest() {
        List<String> list = new ArrayList();
        list.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?><breakfast_menu><food><name>\n Belgian Waffles</name>\n<price>$5.95</price><description>Two of our famous Belgian Waffles with plenty of real maple syrup</description><calories>650</calories></food><food><name>Strawberry Belgian Waffles</name><price>$7.95</price><description>Light Belgian waffles covered with strawberries and whipped cream</description><calories>900</calories></food><food><name>Berry-Berry Belgian Waffles</name><price>$8.95</price><description>Light Belgian waffles covered with an assortment of fresh berries and whipped cream</description><calories>900</calories></food><food><name>French Toast</name><price>$4.50</price><description>Thick slices made from our homemade sourdough bread</description><calories>600</calories></food><food><name>Homestyle Breakfast</name><price>$6.95</price><description>Two eggs, bacon or sausage, toast, and our ever-popular hash browns</description><calories>950</calories></food></breakfast_menu>");
        list.add("<CATALOG><CD><TITLE>Empire Belgian</TITLE><ARTIST>Bob Dylan</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>Columbia</COMPANY><PRICE>10.90</PRICE><YEAR>1985</YEAR></CD><CD><TITLE>Hide your heart</TITLE><ARTIST>Bonnie Tyler</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>CBS Records</COMPANY><PRICE>9.90</PRICE><YEAR>1988</YEAR></CD><CD><TITLE>Greatest Hits</TITLE><ARTIST>Dolly Parton</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>RCA</COMPANY><PRICE>9.90</PRICE><YEAR>1982</YEAR></CD><CD><TITLE>Still got the blues</TITLE><ARTIST>Gary Moore</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Virgin records</COMPANY><PRICE>10.20</PRICE><YEAR>1990</YEAR></CD><CD><TITLE>Eros</TITLE><ARTIST>Eros Ramazzotti</ARTIST><COUNTRY>EU</COUNTRY><COMPANY>BMG</COMPANY><PRICE>9.90</PRICE><YEAR>1997</YEAR></CD><CD><TITLE>One night only</TITLE><ARTIST>Bee Gees</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Polydor</COMPANY><PRICE>10.90</PRICE><YEAR>1998</YEAR></CD><CD><TITLE>Sylvias Mother</TITLE><ARTIST>Dr.Hook</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>CBS</COMPANY><PRICE>8.10</PRICE><YEAR>1973</YEAR></CD><CD><TITLE>Maggie May</TITLE><ARTIST>Rod Stewart</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Pickwick</COMPANY><PRICE>8.50</PRICE><YEAR>1990</YEAR></CD><CD><TITLE>Romanza</TITLE><ARTIST>Andrea Bocelli</ARTIST><COUNTRY>EU</COUNTRY><COMPANY>Polydor</COMPANY><PRICE>10.80</PRICE><YEAR>1996</YEAR></CD><CD><TITLE>When a man loves a woman</TITLE><ARTIST>Percy Sledge</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>Atlantic</COMPANY><PRICE>8.70</PRICE><YEAR>1987</YEAR></CD><CD><TITLE>Black angel</TITLE><ARTIST>Savage Rose</ARTIST><COUNTRY>EU</COUNTRY><COMPANY>Mega</COMPANY><PRICE>10.90</PRICE><YEAR>1995</YEAR></CD><CD><TITLE>1999 Grammy Nominees</TITLE><ARTIST>Many</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>Grammy</COMPANY><PRICE>10.20</PRICE><YEAR>1999</YEAR></CD><CD><TITLE>For the good times</TITLE><ARTIST>Kenny Rogers</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Mucik Master</COMPANY><PRICE>8.70</PRICE><YEAR>1995</YEAR></CD><CD><TITLE>Big Willie style</TITLE><ARTIST>Will Smith</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>Columbia</COMPANY><PRICE>9.90</PRICE><YEAR>1997</YEAR></CD><CD><TITLE>Tupelo Honey</TITLE><ARTIST>Van Morrison</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Polydor</COMPANY><PRICE>8.20</PRICE><YEAR>1971</YEAR></CD><CD><TITLE>Soulsville</TITLE><ARTIST>Jorn Hoel</ARTIST><COUNTRY>Norway</COUNTRY><COMPANY>WEA</COMPANY><PRICE>7.90</PRICE><YEAR>1996</YEAR></CD><CD><TITLE>The very best of</TITLE><ARTIST>Cat Stevens</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Island</COMPANY><PRICE>8.90</PRICE><YEAR>1990</YEAR></CD><CD><TITLE>Stop</TITLE><ARTIST>Sam Brown</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>A and M</COMPANY><PRICE>8.90</PRICE><YEAR>1988</YEAR></CD><CD><TITLE>Bridge of Spies</TITLE><ARTIST>T'Pau</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Siren</COMPANY><PRICE>7.90</PRICE><YEAR>1987</YEAR></CD><CD><TITLE>Private Dancer</TITLE><ARTIST>Tina Turner</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>Capitol</COMPANY><PRICE>8.90</PRICE><YEAR>1983</YEAR></CD><CD><TITLE>Midt om natten</TITLE><ARTIST>Kim Larsen</ARTIST><COUNTRY>EU</COUNTRY><COMPANY>Medley</COMPANY><PRICE>7.80</PRICE><YEAR>1983</YEAR></CD><CD><TITLE>Pavarotti Gala Concert</TITLE><ARTIST>Luciano Pavarotti</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>DECCA</COMPANY><PRICE>9.90</PRICE><YEAR>1991</YEAR></CD><CD><TITLE>The dock of the bay</TITLE><ARTIST>Otis Redding</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>Stax Records</COMPANY><PRICE>7.90</PRICE><YEAR>1968</YEAR></CD><CD><TITLE>Picture book</TITLE><ARTIST>Simply Red</ARTIST><COUNTRY>EU</COUNTRY><COMPANY>Elektra</COMPANY><PRICE>7.20</PRICE><YEAR>1985</YEAR></CD><CD><TITLE>Red</TITLE><ARTIST>The Communards</ARTIST><COUNTRY>UK</COUNTRY><COMPANY>London</COMPANY><PRICE>7.80</PRICE><YEAR>1987</YEAR></CD><CD><TITLE>Unchain my heart</TITLE><ARTIST>Joe Cocker</ARTIST><COUNTRY>USA</COUNTRY><COMPANY>EMI</COMPANY><PRICE>8.20</PRICE><YEAR>1987</YEAR></CD></CATALOG>");
        List<String> result = list.stream().filter(z -> z.matches("([.|\\s\\S]*)Belgian([.|\\s\\S]*)")).collect(Collectors.toList());
    }


    @Test
    public void runnableTest() {
        new Thread(() -> System.out.println("Thread started")).start();
    }

    @Test
    public void lambdaTest() {
        String[] array1 = {"мама", "мыла", "раму"};
        String[] array2 = {"я", "очень", "люблю", "java"};
        String[] array3 = {"мир", "труд", "май"};
        Set set = new HashSet();
        set.size();

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

        arrays.sort((o1, o2) -> o2.length - o1.length);
        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.get(i).length; j++) {
                System.out.print(arrays.get(i)[j] + " ");
            }
            System.out.println("");
        }
    }

    public void useFunc(FuncInt a) {
        System.out.println("Ща здесь ченить сделаем...");
    }

    @Test
    void anotherLambdaTest() {
        useFunc((x, y) -> {
            return x > y;
        });
    }

    @Test
    public void genTest() {
        List<String> list = new ArrayList<>();
        list.add("123");
        SomeType<?> st = new SomeType<>();
        st.test(list);
    }

    public static class SomeType<T> {
        public <E> void test(Collection<E> collection) {
            for (E element : collection) {
                System.out.println(element);
            }
        }

        public void test(List<Integer> collection) {
            for (Integer element : collection) {
                System.out.println(element);
            }
        }
    }

//    void porky() {
//        Box.Cat cat = new Box.Cat();
//        log.log(Level.
//                WARNING, String.valueOf(cat.age));
//    }

    @Test
    void serializeTest() throws IOException {
        ByteCat cat = new ByteCat("Мася", 10);
        log.info(cat.toString());

        FileOutputStream fileOutputStream =
                new FileOutputStream("src/test/resources/Cat.info");
        ObjectOutputStream outputStream =
                new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(cat);
        outputStream.close();
        fileOutputStream.close();

        System.out.println("Serialized successfully.");
    }


}


