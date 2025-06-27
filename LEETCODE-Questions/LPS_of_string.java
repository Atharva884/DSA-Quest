// "static void main" must be defined in a public class.
public class Main {
    public static int LPSOfString(String s, int n){
        HashMap<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n-1; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<=i; j++){
                sb.append(s.charAt(j));
            }

            map.put(sb.toString(), sb.length());
        }

        for(int i=n-1; i>0; i--){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<n; j++){
                sb.append(s.charAt(j));
            }
            
            if(map.containsKey(sb.toString())){
                max = Math.max(max, map.get(sb.toString()));
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        int ans = LPSOfString(s, s.length());
        System.out.println(ans);
    }
}
