import java.util.*;

public class FriendlySequences {
    public static void main(String[] args) {
        System.out.println(new FriendlySequences().count(new int[] {112, 12, 21, 354, 534345, 345, 2221}));
        System.out.println(new FriendlySequences().count(new int[] {10, 1100, 10101, 111, 1111, 11111, 11, 1, 111}));
        System.out.println(new FriendlySequences().count(new int[] {0, 0, 0, 0}));
        System.out.println(new FriendlySequences().count(new int[] {123456890, 213456890, 198654320}));
        System.out.println(new FriendlySequences().count(new int[] {9}));
    }

    private boolean compareTwoTables(boolean[] t0, boolean[] t1) {
        // they must have the same lengths
        for (int i = 0; i < t0.length; i ++) {
            if (t0[i] != t1[i]) return false;
        }
        return true;
    }

    private void resetTable(boolean[] t) {
        for (int i = 0; i < t.length; i ++) t[i] = false;
    }

    private void fillTable(boolean[] t, int number) {
        // assume table is already set
        String temp = Integer.toString(number);
        for (int i = 0; i < temp.length(); i ++) t[(int)temp.charAt(i) - (int)'0'] = true;
    }

    public int count(int[] array) {
        if (array.length == 0) return 0;

        // tables for comparing
        boolean[] table0 = new boolean[10], table1 = new boolean[10];
        resetTable(table0);
        resetTable(table1);

        int count = 0, beg = 0;
        fillTable(table0, array[0]);
        for (int i = 1; i < array.length; i ++) {
            fillTable(table1, array[i]);
            if (!compareTwoTables(table0, table1)) {
                // update count
                // diff = i - beg
                //  ==> diff - 1 + diff - 2 + ... + 1 == (diff - 1) * diff / 2
                // e.g. diff = 4 ==> 3 + 2 + 1        == 3 * 4 / 2
                //      diff = 5 ==> 4 + 3 + 2 + 1    == 4 * 5 / 2
                count += (i - beg - 1) * (i - beg) / 2;

                // swap and reset table1
                boolean[] temp = table0;
                table0 = table1;
                table1 = temp;
                beg = i;
            }
            resetTable(table1); // reset table1 in every round
        }

        return count + (array.length - beg - 1) * (array.length - beg) / 2;
    }
}
