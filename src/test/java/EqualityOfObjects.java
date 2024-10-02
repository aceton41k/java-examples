public class EqualityOfObjects {
    public static void main(String[] args) {
        var classA = new ClassA();
        var classB = new ClassB();
        var classC = new ClassA();
        var classA2 = new ClassA();
        System.out.printf("Class A hash: %d\n", classA.hashCode());
        System.out.printf("Class B hash: %d\n", classB.hashCode());
        System.out.printf("Class C hash: %d\n", classC.hashCode());
        System.out.printf("Overridden equals of classes A and C: %b\n", classA.equals(classC));
        System.out.printf("Equality '==' of classes A and C: %b", classA == classC);
        System.out.println(classA == classA2);
    }

    static class ClassA {
        int size;
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ClassA) {
                return this.size == ((ClassA) obj).size;
            }
            else return false;
        }
    }

    static class ClassB {
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
