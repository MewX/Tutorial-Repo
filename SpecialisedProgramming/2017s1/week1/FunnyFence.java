public class FunnyFence {
    public static void main(String[] args) {
        System.out.println(new FunnyFence().getLength("|-|-|"));
        System.out.println(new FunnyFence().getLength("-|-|-|-"));
        System.out.println(new FunnyFence().getLength("||||||"));
        System.out.println(new FunnyFence().getLength("|-||-|-"));
        System.out.println(new FunnyFence().getLength("|-|---|-|---|-|"));
        System.out.println(new FunnyFence().getLength("|||-||--|--|---|-||-|-|-|--||---||-||-||-|--||"));
    }

    int getLength(String s) {
        if (s.length() == 0) return 0;

        int longest = 0, count = 1;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) != s.charAt(i - 1)) count ++;
            else {
                if (longest < count) longest = count;
                count = 1;
            }
        }
        return longest > count ? longest : count;
    }
}
