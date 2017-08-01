import java.util.*;

public class VolumeGuess {
    private class Condition {
        public int box1, box2, smallest;
        public Condition(int b1, int b2, int s) {
            box1 = b1;
            box2 = b2;
            smallest = s;
        }
    }

    public int correctVolume(String[] queries, int numberOfBoxes, int ithBox) {
        List<Condition> list = new ArrayList<>(); // save the condition with "ithBox" only
        for (String q : queries) {
            String[] temp = q.split(",");
            Condition con = new Condition(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
            if (con.box1 == ithBox || con.box2 == ithBox) list.add(con);
        }

        list.sort((a, b) -> a.smallest - b.smallest); // sort it first, so I can pick the consecutive same two+ values
        return list.get(list.size() - 1).smallest;
    }

    public static void main(String[] args) {
        System.out.println(new VolumeGuess().correctVolume(new String[] {"1,2,10","1,3,10","2,3,20"}, 3, 1));
        System.out.println(new VolumeGuess().correctVolume(new String[] {"1,02,10","2,3,010","1,3,20"}, 3, 2));
        System.out.println(new VolumeGuess().correctVolume(new String[] {"1,2,31","1,3,9","1,4,31","2,4,32","3,4,9","3,2,9"}, 4, 1));
        System.out.println(new VolumeGuess().correctVolume(new String[] {"1,2,31","1,3,9","1,4,31","2,4,32","3,4,9","3,2,9"}, 4, 3));
    }
}