package java_collection.DSA;

/*
 *   ( x % x == 0 )
 * */
public class primenumberCheck {

    public static void main(String[] args) {
        int num = 25;
        System.out.println("Is " + num + " prime number? \n " + primeCheckBySqureRoot(num));
        System.out.println("Is " + num + " prime number? \n " + primeCheckBy6k(num));
    }

    private static boolean primeCheckBy6k(int n) {
        /*
         * Most optimized
         * 6k -1 and 6k + 1
         * */
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 | n % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    private static boolean primeCheckBySqureRoot(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
