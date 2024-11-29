class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int initial = -1;
        int fin = -1;

        int i = 0;
        while(i < n-1){
            if(nums[i+1] < nums[i]){
                initial = i;
                break;
            }
            i++;
        }

        if(initial == -1){
            return 0;
        }

        int j = n-1;
        while(j > 0){
            if(nums[j-1] > nums[j]){
                fin = j;
                break;
            }
            j--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int k=initial; k<=fin; k++){
            min = Math.min(nums[k], min);
            max = Math.max(nums[k], max);
        }

        while (initial >= 0 && nums[initial] > min) {
            initial--;
        }
        initial++;

        while (fin < n && nums[fin] < max) {
            fin++;
        }
        fin--;

        return fin - initial + 1;
    }
}