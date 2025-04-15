package java_collection.DSA.MostAsked;

/*
 * Write a code to reverse a number
 * */
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("reverse of number:" + number + "is " + reverseNumByUsingString(number));
        System.out.println("reverse of number:" + number + "is " + reverseNum(number));
    }

    private static int reverseNum(int number) {
        int result = 0;
        while (number != 0){
            result = result*10+(number%10);
            number/=10;
        }
        return result;
    }

    private static String reverseNumByUsingString(int number) {
        String result = "";
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}
