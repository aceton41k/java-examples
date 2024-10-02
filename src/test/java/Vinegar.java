public class Vinegar {
    public static void main(String[] args) {
        AppInitializer.init(); // Вызов статического метода init
    }
}

class AppInitializer {
    public static void init() {
        MyObject obj = new MyObject(); // Создание объекта через конструктор
        // Дальнейшая логика
    }
}

class MyObject {
    public MyObject() {
        // Конструктор класса MyObject
    }
}
