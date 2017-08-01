class ElevatorLimit {
    private static void out(int[] arr) {
        if (arr.length == 0) System.out.println("()");
        else System.out.format("(%d, %d)\n", arr[0], arr[1]);
    }

    public static void main(String[] args) {
        out(new ElevatorLimit().getRange(new int[] {1, 0}, new int[] {0, 1}, 1));
        out(new ElevatorLimit().getRange(new int[] {1, 0}, new int[] {0, 1}, 2));
        out(new ElevatorLimit().getRange(new int[] {0, 1}, new int[] {1, 0}, 1));
        out(new ElevatorLimit().getRange(new int[] {0, 2}, new int[] {1, 0}, 1));
        out(new ElevatorLimit().getRange(new int[] {6, 85, 106, 1, 199, 76, 162, 141}, new int[] {38, 68, 62, 83, 170, 12, 61, 114}, 668));
        out(new ElevatorLimit().getRange(new int[] {179, 135, 104, 90, 97, 186, 187, 47, 152, 100, 119, 28, 193, 11, 103, 100,
                179, 11, 80, 163, 50, 131, 103, 50, 142, 51, 112, 62, 69, 72, 88, 3, 162,
                93, 190, 85, 79, 86, 146, 71, 65, 131, 179, 119, 66, 111},
                new int[] {134, 81, 178, 168, 86, 128, 1, 165, 62, 46, 188, 70, 104, 111, 3, 47, 144,
                69, 163, 21, 101, 126, 169, 84, 146, 165, 198, 1, 65, 181, 135, 99, 100,
                195, 171, 47, 16, 54, 79, 69, 6, 97, 154, 80, 151, 76}, 954));
        out(new ElevatorLimit().getRange(new int[] {2}, new int[] {3}, 2));

        // maxPeople < 0 case
        out(new ElevatorLimit().getRange(new int[] {295, 752, 84, 439, 607, 581}, new int[] {558, 664, 644, 2, 564, 451}, 948));
    }

    public int[] getRange(int[] enter, int[] exit, int physicalLimit) {
        // simulate
        int maxPeople = Integer.MIN_VALUE, minPeople = Integer.MAX_VALUE;
        int currentPeople = 0;
        for (int i = 0; i < enter.length; i ++) {
            currentPeople -= exit[i];
            if (currentPeople < minPeople) minPeople = currentPeople;
            currentPeople += enter[i];
            if (currentPeople > maxPeople) maxPeople = currentPeople;
        }

        // limitation on maxPeople and minPeople
        if (maxPeople - minPeople > physicalLimit || -minPeople > physicalLimit) return new int[0];
        else return new int[] {-minPeople, maxPeople < 0 ? physicalLimit : physicalLimit - maxPeople};
    }
}
