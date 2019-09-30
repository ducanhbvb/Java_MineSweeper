import java.util.Scanner;

public class MineSweeper {
    static int[][] All_result;

    public static void sum(int a, int i, int j) {
        int[][] coordinatesAround = {{i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1}, {i, j + 1}, {i + 1, j + 1}, {i + 1, j}, {i + 1, j - 1}, {i, j - 1}};
        int[] diaChi = coordinatesAround[a];
        int diaChi_i = diaChi[0];
        int diaChi_j = diaChi[1];
        All_result[diaChi_i][diaChi_j]++;
    }

    public static void ArrayMine(int i, int j) {
        for (int k = 0; k < 8; k++) {
            sum(k, i, j);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input Max Current");
        int maxCurrent = sc.nextInt();
        System.out.println("input Max Column");
        int maxColumn = sc.nextInt();
        String[][] randomMineSweeper = new String[maxCurrent][maxColumn];
        All_result = new int[maxCurrent + 2][maxColumn + 2];
        String mine = "*";
        String zero = ".";
        for (int i = 0; i < randomMineSweeper.length; i++) {
            for (int j = 0; j < randomMineSweeper[i].length; j++) {
                int random = (int) (Math.random() * 1.3);
                if (random == 1) {
                    randomMineSweeper[i][j] = mine;
                } else {
                    randomMineSweeper[i][j] = zero;
                }
            }
        }
        for (int i = 0; i < randomMineSweeper.length; i++) {
            for (int j = 0; j < randomMineSweeper[i].length; j++) {
                System.out.print(randomMineSweeper[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < randomMineSweeper.length; i++) {
            for (int j = 0; j < randomMineSweeper[i].length; j++) {
                if (randomMineSweeper[i][j] == mine) {
                    All_result[i + 1][j + 1] = 10;
                    ArrayMine(i + 1, j + 1);
                }
            }
        }
        System.out.println();
        for (int i = 1; i < All_result.length - 1; i++) {
            for (int j = 1; j < All_result[i].length - 1; j++) {
                if (All_result[i][j] > 9) {
                    System.out.print(mine + " ");
                    continue;
                }
                System.out.print(All_result[i][j] + " ");
            }
            System.out.println();
        }
    }
}



