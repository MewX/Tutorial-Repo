public class Inchworm {
    // calc the largest common divider
    private int gcd(int a, int b) {
        int temp = a % b;
        if (temp != 0) return gcd(b, temp);
        else return b;
    }

    // calc the least common multiply using Euclidean Algorithm
    private int lcm(int a, int b) {
        return a * b / gcd(a, b); 
    }

    public int lunchtime(int branch, int rest, int leaf) {
        // target position is a rest and leaf position
        // System.out.format("lcm(%d, %d) = %d\n", rest, leaf, lcm(rest, leaf));
        return branch / lcm(rest, leaf) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Inchworm().lunchtime(11, 2, 4));
        System.out.println(new Inchworm().lunchtime(12, 6, 4));
        System.out.println(new Inchworm().lunchtime(20, 3, 7));
        System.out.println(new Inchworm().lunchtime(21, 7, 3));
        System.out.println(new Inchworm().lunchtime(15, 16, 5));
        System.out.println(new Inchworm().lunchtime(1000, 3, 7));
        System.out.println(new Inchworm().lunchtime(1000, 7, 3));
    }
}