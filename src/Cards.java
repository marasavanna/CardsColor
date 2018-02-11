/**
 * Created by Mara on 2/11/2018.
 */
import java.util.*;

public class Cards {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] cards = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                cards[i][j] = input.nextInt();
            }
        }
        System.out.println(newSearch(cards));


    }

    private static int newSearch(int[][] cards) {
        int maxNum = -1;
        for (int[] card : cards) {
            for (int j = 0; j < 2; j++) {
                maxNum = Math.max(card[j], maxNum);
            }
        }
        int[] app = new int[maxNum + 1];
        for (int[] card : cards) {
            for (int j = 0; j < 2; j++) {
                app[card[j]]++;
            }
        }
        ArrayList<Num> nums = new ArrayList<>();
        for (int i = 0; i <= maxNum; i++) {
            if (app[i] > 0) {
                nums.add(new Num(i, app[i]));
            }
        }

        nums.sort(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o2.app - o1.app;
            }
        });
        if (nums.get(nums.size() - 1).app < cards.length / 2) {
            return -1;
        }
        for(Num x : nums) {
            if (x.app > cards.length / 2) {
                int count = 0;
                for (int i = 0; i < cards.length; i++) {
                    if (x.num == cards[i][0]) {
                        count++;
                    }
                }
                return cards.length / 2 - count + cards.length % 2;
            }
        }
        return -1;
    }


    static class Num {
        public int num;
        public int app;

        public Num(int num, int app) {
            this.num = num;
            this.app = app;
        }
    }

}
