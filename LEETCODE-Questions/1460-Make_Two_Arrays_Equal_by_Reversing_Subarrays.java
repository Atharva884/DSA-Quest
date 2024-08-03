class Solution {
    // TC: O(2N), SC: O(N)
    // public boolean canBeEqual(int[] target, int[] arr) {
    //     int n = target.length;

    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for(int num: target){
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }

    //     for(int num: arr){
    //         if(!map.containsKey(num)){
    //             return false;
    //         }

    //         if(map.get(num) == 1){
    //             map.remove(num);
    //         }else{
    //             map.put(num, map.get(num) - 1);
    //         }
    //     }

    //     return true;
    // }

    // TC: O(2N) * O(1001), SC: O(1001)
    public boolean canBeEqual(int[] target, int[] arr){
        int[] freq = new int[1001];

        for(int num: arr){
            freq[num]++;
        }

        for(int num: target){
            freq[num]--;
        }

        for(int num: freq){
            if(num != 0){
                return false;
            }
        }

        return true;
    }
}