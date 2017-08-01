import java.util.*;

class Partners {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] a = line.split(",");
            System.out.println(new Partners().calc(Integer.valueOf(a[0]),
                Integer.valueOf(a[1]), Integer.valueOf(a[2]), Integer.valueOf(a[3]), Integer.valueOf(a[4])));
        }
    }

    private class Pair {
        public int aid, bid, count;
        public Pair(int a, int b, int c) {
            aid = a;
            bid = b;
            count = c;
        }
    }

    public int calc(int X, int A, int B, int numA, int numB) {
        // use simulation
        List<Pair> list = new ArrayList<>();
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int a = 1; a <= numA; a ++) {
            mapA.put(a, 0);
            for (int b = 1; b <= numB; b ++) {
                mapB.put(b, 0);
                list.add(new Pair(a, b, 0));
            }
        }

        // start simulating
        int count = 0;
        for (Pair p : list) {
            while (p.count <= X && mapA.get(p.aid) <= A && mapB.get(p.bid) <= B) {
                if (p.count != X && mapA.get(p.aid) != A && mapB.get(p.bid) != B) {
                    p.count ++;
                    mapA.put(p.aid, mapA.get(p.aid) + 1);
                    mapB.put(p.bid, mapB.get(p.bid) + 1);
                } else break;
            }
            // System.err.format("a(%d), b(%d), count(%d)\n", p.aid, p.bid, p.count);
            count += p.count;
        }
        return count;
    }

}