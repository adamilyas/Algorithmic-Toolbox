import java.util.*;

class EditDistance {

    public static int getEditDistance(String s, String t){
        int[][] dpTable = EditDistanceTable(s, t);
        return dpTable[s.length()-1][t.length()-1];
    }

    private static int[][] EditDistanceTable(String s, String t) {
        int[][] dpTable = new int[s.length()][t.length()];
        for (int i=0;i<s.length();i++){

            for (int j=0;j<t.length();j++){

                if (i == 0){
                    dpTable[i][j] = j; // insert all of string2
                } else if (j == 0){
                    dpTable[i][j] = i; // insert all of string1
                } else if (s.charAt(i-1) == t.charAt(j-1)){
                    dpTable[i][j] = dpTable[i-1][j-1]; // no changes from previous substring
                } else {
                    dpTable[i][j] = 1 + Collections.min(
                        Arrays.asList(
                            dpTable[i][j-1],  // Insert
                            dpTable[i-1][j],  // Remove 
                            dpTable[i-1][j-1] // Replace 
                    )); 
                }
            }
        }
        return dpTable;
    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(getEditDistance(s, t));
        scan.close();
    }

}
