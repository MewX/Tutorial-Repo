import java.util.*;

public class Moon {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i ++) {
            String temp = s.nextLine().trim();
            input.add(temp);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        s.close();

        int max = Integer.MIN_VALUE;
        String str = "";
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                str = e.getKey();
            }
        }
        System.out.println(str);
        System.out.println(max);
    }
}
