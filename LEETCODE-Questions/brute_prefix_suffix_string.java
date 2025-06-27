// "static void main" must be defined in a public class.
public class Main {
    public static void prefixAndSuffix(String s, int n){
        System.out.println("Prefix String -> All substring starting from 0th idx");   
        System.out.println();

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Suffix String -> All substring ending at last idx");   
        System.out.println();        

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        prefixAndSuffix(s, s.length());   
    }
}
