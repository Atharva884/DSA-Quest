class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: target){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // System.out.println(map);

        for(int num: arr){
            if(!map.containsKey(num)){
                return false;
            }

            if(map.get(num) == 1){
                map.remove(num);
            }else{
                map.put(num, map.get(num) - 1);
            }
        }

        return true;
    }
}