class SquareOfDigits {
    public static void main(String[] args) {
        System.out.println(new SquareOfDigits().getMax(new String[] {"12", "34"}));
        System.out.println(new SquareOfDigits().getMax(new String[] {"1255", "3455"}));
        System.out.println(new SquareOfDigits().getMax(new String[] {"42101", "22100", "22101"}));
        System.out.println(new SquareOfDigits().getMax(new String[] {"1234567890"}));
        System.out.println(new SquareOfDigits().getMax(new String[] {"9785409507",
                "2055103694",
                "0861396761",
                "3073207669",
                "1233049493",
                "2300248968",
                "9769239548",
                "7984130001",
                "1670020095",
                "8894239889",
                "4053971072"}));
    }

    public int getMax(String[] data) {
        int result = 1;
        // brute-force
        for (int y = 0; y < data.length; y ++) { // top-left corner
            for (int x = 0; x < data[0].length() - 1; x ++) {

                // calculate right & bottom direction only
                for (int xr = x + 1; xr < data[0].length(); xr ++) { // search from x+1
                    // so, other points are defined as well
                    int distance = xr - x;
                    if (y + distance >= data.length) break;

                    // compare (x, y), (x + d, y), (x, y + d), (x + d, y + d)
                    if (data[y].charAt(x) == data[y].charAt(xr) && data[y].charAt(xr) == data[y+distance].charAt(x)
                            && data[y+distance].charAt(x) == data[y+distance].charAt(xr)) {
                        if (distance + 1 > result) result = distance + 1;
                    }
                }
            }
        }
        return result * result;
    }
}