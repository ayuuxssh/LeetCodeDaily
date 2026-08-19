class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        for (int [] it : reservedSeats) {
            int row = it[0];
            int col = it[1];
            mp.put(row,mp.getOrDefault(row,0)|(1<<col));
        }

        int result = (n - mp.size()) * 2;
        int grpA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int grpB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int grpC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        for (Map.Entry<Integer,Integer> it : mp.entrySet()) {
            boolean grpA1 = (it.getValue() & grpA) == 0;
            boolean grpB1 = (it.getValue() & grpB) == 0;
            boolean grpC1 = (it.getValue() & grpC) == 0;

            if (grpA1 && grpC1) {
                result += 2;
            } else if (grpA1 || grpB1 || grpC1) {
                result += 1;
            }
        }
        return result;
    }
}