import java.util.Scanner;

class ColourfulLights {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();
        s.close();

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == result.charAt(result.length() - 1)) {
                if (str.length() == i + 1) {
                    result.append(getRemain(c));
                } else {
                    result.append(getRemain(c, str.charAt(i + 1)));
                }
            } else {
                result.append(c);
            }
        }
        System.out.println(result);
    }

    private static char getRemain(char c) {
        switch (c) {
            case 'R':
                return 'G';
            case 'G':
                return 'B';
            case 'B':
                return 'R';
        }
        return 'R';
    }

    private static char getRemain(char c1, char c2) {
        switch (c1) {
            case 'R':
                return c2 == 'G' ? 'B' : 'G';
            case 'G':
                return c2 == 'B' ? 'R' : 'B';
            case 'B':
                return c2 == 'R' ? 'G' : 'R';
        }
        return 'R';
    }
}
