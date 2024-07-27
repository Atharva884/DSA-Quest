
import java.util.*;

class Solution {
    public static int[] convertToNewSys(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] newSys = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num == 0) {
                newSys[i] = mapping[0];
            } else {
                int res = 0;
                int k = 0;
                while (num != 0) {
                    int lastDigit = num % 10; // extraction of last digit
                    res += mapping[lastDigit] * (int) Math.pow(10, k);
                    num = num / 10; // removal of last digit
                    k++;
                }
                newSys[i] = res;
            }

        }

        return newSys;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;

        int[] newSys = convertToNewSys(mapping, nums);
        Integer[] index = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return newSys[a] - newSys[b]; // sorting in increasing order
            }
        });

        int[] res = new int[n];
        int i = 0;

        for (int ind : index) {
            res[i++] = nums[ind];
        }

        return res;
    }
}