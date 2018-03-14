import org.jcp.xml.dsig.internal.dom.DOMUtils;

import java.util.*;

public class Slalom {
    private static final double MAX_DOUBLE = 99999999.9;
    private static class Gate {
        int yLow, yHight;

        Gate(int y1, int y2) {
            yLow = Math.min(y1, y2);
            yHight = Math.max(y1, y2);
        }
    }

    private class Line {
        double b, k;

        Line(int x1, int y1, int x2, int y2) {
            if (x1 < x2) {
                k = (1.0 * y2 - 1.0 * y1) / (1.0 * x2 - 1.0 * x1);
            } else {
                k = (1.0 * y1 - 1.0 * y2) / (1.0 * x1 - 1.0 * x2);
            }
            b = y1 - k * x1;
        }

        double calcY(int x) {
            return k * x + b;
        }

        double calcX(double y) {
            return (y - b) / k;
        }

        double dist(int x1, int x2) {
            double y1 = calcY(x1);
            double y2 = calcY(x2);
            return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }
    }

    public static void main(String[] args) {
        int noCase = 0;

        Scanner s = new Scanner(System.in);
        noCase = s.nextInt();
        // TODO:
        for (int c = 0; c < noCase; c ++) {
            int N, S;
            N = s.nextInt();
            S = s.nextInt();

            ArrayList<Gate> gates = new ArrayList<>();
            for (int i = 0; i < N; i ++) {
                int y1, y2;
                y1 = s.nextInt();
                y2 = s.nextInt();
                gates.add(new Gate(y1, y2));
            }

            System.out.printf("%.4f\n", new Slalom().calc(N, S, gates));
        }
    }

    double calc(int N, int S, ArrayList<Gate> gates) {
        // shortest path
        double best = Double.MAX_VALUE;
        for (int x = 0; x < N; x ++) {
            double temp = dfs(0, S, x + 1, gates.get(x).yLow, gates);
            best = Math.min(best, temp);

            double temp2 = dfs(0, S, x + 1, gates.get(x).yHight, gates);
            best = Math.min(best, temp2);

            if (temp > MAX_DOUBLE && temp2 > MAX_DOUBLE) break;
        }
        return best;
    }

    double dfs(int xStart, int yStart, int xEnd, int yEnd, ArrayList<Gate> gates) {
        if (xStart == gates.size()) return 0;
//        System.out.format("xs: %d, ys: %d, xe: %d, ye: %d\n", xStart, yStart, xEnd, yEnd);

        // return distance
        double best = Double.MAX_VALUE;
        Line line = new Line(xStart, yStart, xEnd, yEnd);
        if (!validateThisLine(line, xStart, xEnd, gates)) {
            return best;
        }

        // valid
        double distToNow = line.dist(xStart, xEnd);
        if (xStart == gates.size() - 1) return distToNow;
        for (int i = xEnd + 1; i <= gates.size(); i ++) {
            // TODO: buggy here
            double temp = dfs(xEnd, yEnd, i, gates.get(i - 1).yHight, gates);
            double temp2 = dfs(xEnd, yEnd, i, gates.get(i - 1).yLow, gates);
            System.out.format("temp: %.4f, temp2: %.4f\n", temp, temp2);
            if (temp > MAX_DOUBLE && temp2 > MAX_DOUBLE) continue;

            if (temp < MAX_DOUBLE) best = Math.min(best, distToNow + temp);
            if (temp2 < MAX_DOUBLE) best = Math.min(best, distToNow + temp2);
            System.out.format("best: %.4f\n", best);

            if (!possibleUsingThisLine(line, i, gates.get(i - 1))) {
                return best;
            }

        }
        return best;
    }

    boolean validateThisLine(Line line, int xStart, int xEnd, ArrayList<Gate> gates) {
        // (xStart, xEnd)!!!
        for (int i = xStart + 1; i < xEnd; i ++) {
            if (!possibleUsingThisLine(line, i, gates.get(i - 1)))
                return false;
        }
        return true;
    }

    boolean possibleUsingThisLine(Line line, int x, Gate gate) {
        double y = line.calcY(x);
        return gate.yLow <= y && y <= gate.yHight;
    }
}
