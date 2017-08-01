public class Elections {
    int visit(String[] likelihoods) {
        int idxLowest = 0;
        double lowestRate = 1.0;
        for (int i = 0; i < likelihoods.length; i ++) {
            int count1 = 0;
            for (int j = 0; j < likelihoods[i].length(); j ++) {
                if (likelihoods[i].charAt(j) == '1') count1 ++;
            }

            double temp = count1 * 1.0 / likelihoods[i].length();
            if (temp < lowestRate) {
                lowestRate = temp;
                idxLowest = i;
            }
        }
        return idxLowest;
    }

    public static void main(String[] args) {
        System.out.println(new Elections().visit(new String[] {"1222","1122","1222"}));
        System.out.println(new Elections().visit(new String[] {"1222111122","2222222111","11111222221222222222"}));
        System.out.println(new Elections().visit(new String[] {"111","112","121","122","211","212","221","222"}));
        System.out.println(new Elections().visit(new String[] {"1122","1221","1212","2112","2121","2211"}));
        System.out.println(new Elections().visit(new String[] {"11112222111121","1211221212121","112111222","11122222222111","112121222","1212122211112"}));
    }
}
