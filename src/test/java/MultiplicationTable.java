public class MultiplicationTable {
    public static void main(String[] args) {
        create();
    }

    public static void create() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%dx%d=%d\t", j, i, i * j);
            }
            System.out.print("\n");
        }
    }
}
