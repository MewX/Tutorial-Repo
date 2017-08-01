import java.util.*;

public class Encryption {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String r1 = s.nextLine();
        String r2 = s.nextLine();
        String r3 = s.nextLine();
        String en = s.nextLine();
        System.out.println(new Encryption().test(r1, r2, r3, en));
    }

    public int hexCharToInt(char c) {
        int cd = Integer.valueOf(c);
        if (48 <= cd && cd <= 57) return cd - 48;
        else if (65 <= cd && cd <= 90) return cd - 65 + 10;
        else return cd - 97 + 10;
    }

    public String test(String r1, String r2, String r3, String encrypted) {
        r1 = r1.toUpperCase();// for all upper cases
        r2 = r2.toUpperCase();// for all upper cases
        r3 = r3.toUpperCase();// for all upper cases
        encrypted = encrypted.toUpperCase();// for all upper cases

        List<Integer> enc = new ArrayList<>();
        for (int i = 0; i < encrypted.length(); i ++) {
            int b1, b2, b3;
            b1 = hexCharToInt(r1.charAt(0));
            b2 = hexCharToInt(r2.charAt(0));
            b3 = hexCharToInt(r3.charAt(0));

            enc.add(b1 + b2 + b3);
            int largest = 1; // by default
            if (b1 >= b2 && b1 >= b3) largest = 1;
            else if (b2 > b1 && b2 >= b3) largest = 2;
            else if (b3 > b1 && b3 > b2) largest = 3;

            switch (largest) {
            case 1:
                r1 = r1.substring(1) + r1.substring(0, 1);
                break;
            case 2:
                r2 = r2.substring(1) + r2.substring(0, 1);
                break;
            case 3:
                r3 = r3.substring(1) + r3.substring(0, 1);
                break;
            }
        }

        LinkedList<Character> list = new LinkedList<>();
        for (int i = encrypted.length() - 1; i >= 0; i --) {
            char current = encrypted.charAt(i);

            int temp = Integer.valueOf(hexCharToInt(current));
            temp += 4 * 16;
            temp -= enc.get(i);
            temp %= 16;
            list.addFirst(Integer.toHexString(temp).charAt(0));
            System.out.println(temp + " - " + Integer.toHexString(temp).charAt(0));
        }
        System.out.println();

        for (int i = 0; i < list.size(); i ++) {
            System.out.print(list.get(i));
        }
        System.out.println();

        char [] ret = new char [list.size() >> 1];
        int count = 0;
        for (int i = 1; i < list.size(); i += 2) {
            ret[count ++] = (char)(hexCharToInt(list.get(i - 1)) * 16 +hexCharToInt(list.get(i)));
            System.out.println(Integer.valueOf(ret[count - 1]));
        }
        return new String(ret);
    }
}