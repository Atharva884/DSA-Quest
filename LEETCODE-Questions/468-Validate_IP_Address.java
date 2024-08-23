class Solution {
    public static boolean isIPv4Address(String address, int n){
        int count = 0;
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();

            // Form the number until we encounter "."
            while(i < n && address.charAt(i) != '.'){
                if (!Character.isDigit(address.charAt(i))) return false;
                sb.append(address.charAt(i));
                i++;
            }

            // Check for dots
            if(i < n && address.charAt(i) == '.') count++;

            // Check if there is number
            if(sb.length() <= 0) return false;

            // Check if it lies in the range
             int num;
            try {
                num = Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                return false; // If the number is too large to parse, it's invalid
            }
            if(num < 0 || num > 255) return false;

            // Check if there are leading zeroes
            if(sb.length() > 1 && sb.charAt(0) == '0') return false;
        }


        return (count == 3 && address.charAt(n-1) != '.');
    }

    public static boolean isIPv6Address(String address, int n){
         // IPv6 address contains 7 semicolons and xi length should
        // be from 1 to 4 and it should contain a-f or A-F
        int semiColons = 0;

        for(int i=0; i<n; i++){

            StringBuilder sb = new StringBuilder();

            int count = 0;
            while(i < n && address.charAt(i) != ':'){
                int digit = (int) address.charAt(i);
                
                if(Character.isDigit(address.charAt(i))){
                    if(address.charAt(i) - '0' < 0 || address.charAt(i) - '0' > 9){
                        return false;
                    }
                }else if(Character.isUpperCase(address.charAt(i))){
                    if(digit < 65 || digit > 70){
                        return false;
                    }
                }else if(Character.isLowerCase(address.charAt(i))){
                    if(digit < 97 || digit > 102){
                        return false;
                    }
                }
                
                sb.append(address.charAt(i));

                i++;
                count++;
            }

            // Check if it is semicolon
            if(i < n && address.charAt(i) == ':') semiColons++;

            // Check if there is substring between two semicolons
            if(sb.length() <= 0) return false;

            // Digit should be 1 to 4
            if(count < 1 || count > 4) return false;
        }


        return (semiColons == 7 && address.charAt(n-1) != ':');
    }

    public String validIPAddress(String queryIP) {
        int n = queryIP.length();

        for(int i=0; i<n; i++){
            if(queryIP.charAt(i) == '.'){
                if(isIPv4Address(queryIP, n)){
                    return "IPv4";
                }
            }else if(queryIP.charAt(i) == ':'){
                if(isIPv6Address(queryIP, n)){
                    return "IPv6";
                }
            }
        }

        return "Neither";
    }
}