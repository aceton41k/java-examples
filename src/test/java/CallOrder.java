public class CallOrder {
    public static void main(String[] args) {
        new Child();
    }

    static class Parent {
        static {
            System.out.println("1. Parent static section");
        }
        public Parent() {
            System.out.println("3. Parent constructor");
            parent_method();
        }
        public void parent_method() {
            System.out.println("Parent method (won't call)");
        }
    }
    static class Child extends Parent {
        static {
            System.out.println("2. Child static section");
        }
        public Child() {
            super();
            System.out.println("5. Child constructor");
        }
        @Override
        public void parent_method() {
            System.out.println("4. Overridden parent method");
        }
    }
}
