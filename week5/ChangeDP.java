import java.util.Scanner;

public class ChangeDP {

    private static int[] getMinChangeList(int money) {
        int[] coins = {1,3,4};
        int[] MinNumCoins = new int[money+1];
        MinNumCoins[0] = 0;

        for (int m=1;m<=money;m++){
            // printIntArr(MinNumCoins);
            MinNumCoins[m] = Integer.MAX_VALUE;
            for (int c : coins){
                if (m >= c){
                    int NumCoins = MinNumCoins[m - c] + 1;
                    if (NumCoins < MinNumCoins[m]){
                        MinNumCoins[m] = NumCoins;
                    }
                }
            }
        }
        return MinNumCoins;
    }

    public static int getChange(int money){
        int[] changeList = getMinChangeList(money);
        // printIntArr(changeList);
        return changeList[money];
    }

    private static void printIntArr(int[] arr){
        String str = "";
        for (int el : arr){
            str = str.concat(" ").concat(String.valueOf(el));
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();

    }
}

