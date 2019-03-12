import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Tours {
    private static double diff = 0.00000000001;

    static class Trip {
        public double ratio = Double.MAX_VALUE;
        public int city, cost;

        public Trip(int city, int cost) {
            this.city = city;
            this.cost = cost;
            this.ratio = 1.0 * cost / city;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nCities = new int[n];
        int[] costs = new int[n];

        for (int i = 0; i < n; i++) {
            nCities[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            costs[i] = s.nextInt();
        }
        s.close();

        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trips.add(new Trip(nCities[i], costs[i]));
        }
        trips.sort((t1, t2) -> {
            if (aEqualsB(t1.ratio, t2.ratio)) {
                return t2.city - t1.city;
            } else {

                return aSmallerThanB(t1.ratio, t2.ratio) ? -1 : 1;
            }
        });

        double c = Double.MAX_VALUE;
        Trip a = null;
        Trip b = null;

//        int max = trips.size() > 200 ? 200 : trips.size();
//        for (int i = 0; i < max; i++) {
//            Trip t1 = trips.get(i);
//            System.out.format("*** %d %d\n", t1.city, t1.cost);
//            for (int j = i + 1; j < max; j++) {
//                Trip t2 = trips.get(j);
//                double cost = 1.0 * (t1.cost + t2.cost) / (t1.city + t2.city);
//                if (aSmallerThanB(cost, c)) {
//                    a = t1;
//                    b = t2;
//                    c = cost;
//                } else if (aEqualsB(cost, c) && (a.city + b.city < t1.city + t2.city)) {
//                    a = t1;
//                    b = t2;
//                    c = cost;
//                }
//            }
//        }

        // compare first 2
        if (aSmallerThanB(trips.get(0).ratio, trips.get(1).ratio)) {
            Trip t1 = trips.get(0);
            for (int j = 1; j < trips.size(); j++) {
                Trip t2 = trips.get(j);
                double cost = 1.0 * (t1.cost + t2.cost) / (t1.city + t2.city);
                if (aSmallerThanB(cost, c)) {
                    a = t1;
                    b = t2;
                    c = cost;
                } else if (aEqualsB(cost, c) && (a.city + b.city < t1.city + t2.city)) {
                    a = t1;
                    b = t2;
                    c = cost;
                }
            }
        } else {
            int count = 1;
            for (int i = 1; i < trips.size(); i++) {
                if (aEqualsB(trips.get(i).ratio, trips.get(0).ratio)) {
                    count ++;
                } else {
                    break;
                }
            }

            a = trips.get(0);
            b = trips.get(1);
            c = 1.0 * (b.cost + a.cost) / (b.city + a.city);

//            for (int i = count - 1; i >= 0; i--) {
                Trip t1 = trips.get(count - 1);
                for (int j = count; j < trips.size(); j++) {
                    Trip t2 = trips.get(j);
                    double cost = 1.0 * (t1.cost + t2.cost) / (t1.city + t2.city);
                    if (aSmallerThanB(cost, c)) {
                        a = t1;
                        b = t2;
                        c = cost;
                    } else if (aEqualsB(cost, c) && (a.city + b.city < t1.city + t2.city)) {
                        a = t1;
                        b = t2;
                        c = cost;
                    }
                }
//            }
        }

        // try elimination first
//        List<Trip> shortList = new ArrayList<>();
//        for (int i = 0; i < trips.size() - 1; i++) {
//            if (aSmallerThanB(trips.get(i).ratio, trips.get(i + 1).ratio)) {
//                shortList.add(trips.get(i));
//            }
//        }
//        shortList.add(trips.get(trips.size() - 1));
//
//        for (int i = 0; i < shortList.size(); i++) {
//            Trip t1 = trips.get(i);
//            for (int j = i + 1; j < shortList.size(); j++) {
//                Trip t2 = trips.get(j);
//                double cost = 1.0 * (t1.cost + t2.cost) / (t1.city + t2.city);
//                if (aSmallerThanB(cost, c)) {
//                    a = t1;
//                    b = t2;
//                    c = cost;
//                } else if (aEqualsB(cost, c) && (a.city + b.city < t1.city + t2.city)) {
//                    a = t1;
//                    b = t2;
//                    c = cost;
//                }
//            }
//        }
//        if (a == null) {
//            a = trips.get(0);
//            b = trips.get(1);
//        }

        System.out.format("%d %d\n", a.city + b.city, a.cost + b.cost);



//        double bestRatio = Double.MAX_VALUE; // smallest
//        int city = 0;
//        int cost = 0;
//        double bestRatio2 = Double.MAX_VALUE; // 2nd smallest
//        int city2 = 0;
//        int cost2 = 0;
//
//        for (int i = 0; i < n; i++) {
//            double temp = 1.0 * costs[i] / nCities[i];
//
//            if (aSmallerThanB(temp, bestRatio2)) {
//                if (aSmallerThanB(temp, bestRatio) || city == 0) {
//                    bestRatio2 = bestRatio;
//                    city2 = city;
//                    cost2 = cost;
//
//                    bestRatio = temp;
//                    city = nCities[i];
//                    cost = costs[i];
//                } else {
//                    bestRatio2 = temp;
//                    city2 = nCities[i];
//                    cost2 = costs[i];
//                }
//            } else if (aEqualsB(temp, bestRatio2) && city2 < nCities[i]) {
//                if (aEqualsB(temp, bestRatio) && city < nCities[i] || city == 0) {
//                    bestRatio2 = bestRatio;
//                    city2 = city;
//                    cost2 = cost;
//
//                    bestRatio = temp;
//                    city = nCities[i];
//                    cost = costs[i];
//                } else {
//                    bestRatio2 = temp;
//                    city2 = nCities[i];
//                    cost2 = costs[i];
//                }
//            }
//
//
//            // tune the two
//            if (aEqualsB(bestRatio, bestRatio2) && city < city2) {
//                // swap
//                int t = city;
//                city = city2;
//                city2 = t;
//
//                t = cost;
//                cost = cost2;
//                cost2 = t;
//            }
//        }
//        System.out.format("%d %d\n", city + city2, cost + cost2);

    }

    private static boolean aSmallerThanB(double a, double b) {
        return a < b - diff;
    }

    private static boolean aEqualsB(double a, double b) {
        return a < b + diff && a > b - diff;
    }

}
