class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void rev(int[] nums, int i, int n){
        int a = i;
        int b = n;

        while(a < b){
            swap(nums, a, b);

            a++;
            b--;
        }
    }

    public int findBreakdown(int[] nums, int n){
        int idx = -1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        return idx;
    }

    public int findGreatest(int[] nums, int n, int idx){
        for(int i=n-1; i>=idx; i--){
            if(nums[i] > nums[idx]){
                return i;
            }
        }

        return -1;
    }

    public int[] makeArray(int n){
        List<Integer> temp = new ArrayList<>();

        while(n != 0){
            temp.add(n % 10);

            n = n/10;
        }

        int len = temp.size();
        int[] arr = new int[len];
        int i = len-1;
        for(int num: temp){
            arr[i--] = num;
        }

        return arr;
    }

    public int convertToDigit(int[] nums, int n){
        long digit = 0;

        for(int i=0; i<n; i++){
            digit = digit * 10 + nums[i];
        }

        if(digit > Integer.MAX_VALUE) return -1;
        return (int) digit;  
    }

    // Optimal Approach
    // TC: O(logN), SC: O(logN) -> We can actually reduce the space and 
    // optimized it to O(1), instead of adding the digit to list and then array.
    public int nextGreaterElement(int n) {
        int[] nums = makeArray(n);

        int n1 = nums.length;

        int idx = findBreakdown(nums, n1);

        if(idx == -1){
            return -1;
        }

        int numIdx = findGreatest(nums, n1, idx);

        swap(nums, idx, numIdx);

        rev(nums, idx+1, n1-1);

        int ans = convertToDigit(nums, n1);
        
        return ans;
    }
}
