class Solution {
    public static int sumOfDigit(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;

            num = num / 10;
        }

        return sum;
    }

    public String smallestNumber(int s, int d) {
        int startPoint = (int) Math.pow(10, d - 1);
        int endPoint = (int) Math.pow(10, d) - 1;

        for (int i = startPoint; i <= endPoint; i++) {
            if (sumOfDigit(i) == s) {
                return Integer.toString(i);
            }
        }

        return "-1";
    }
}