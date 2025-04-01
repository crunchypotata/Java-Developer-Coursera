public class PrinterNumbers {
    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 != 0 && sumOfDigits(i) < 10) {
                System.out.println(i);
            }
        }
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}