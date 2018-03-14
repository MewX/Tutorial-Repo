import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (s.hasNextLine()) {
            String temp = s.nextLine().trim();
            if (temp.length() > 0)
                input.add(temp);
        }
        new Matrix().run(input);
    }

    void run(ArrayList<String> input) {
        out:
        for (int idx = 0; idx < input.size(); idx++) {
            String current = input.get(idx);
            String[] rows = current.split(";");
            int[][] mat = new int[rows.length][]; //[height][weigth]
            int x = rows[0].split(",").length;
            for (int i = 0; i < rows.length; i ++) {
                String[] nums = rows[i].split(",");
                mat[i] = new int[x];
                for (int j = 0; j < nums.length; j ++) {
                    mat[i][j] = Integer.valueOf(nums[j]);
                }
            }

            // copy the matrix
            int[][] copy = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    copy[i][j] = mat[j][i];
                }
            }

            // compare
            for (int i = 0; i < mat.length; i ++) {
                for(int j = 0; j < mat[i].length; j ++) {
                    if (mat[i][j] != copy[i][j]) {
                        System.out.println("Not symmetric");
                        continue out;
                    }
                }
            }
            System.out.println("Symmetric");
        }


    }
}
