public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        for(int i=1; i <= n && i > 0; i*=3) {
            if(n==i) return true;
        }
        return false;
    }
}
