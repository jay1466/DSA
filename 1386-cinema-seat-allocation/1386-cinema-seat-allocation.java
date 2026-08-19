class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int s = seat[1];

            if (s >= 2 && s <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << s));
            }
        }

        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {
            boolean left = (mask & ((1 << 2) | (1 << 3) | (1 << 4) | (1 << 5))) == 0;
            boolean middle = (mask & ((1 << 4) | (1 << 5) | (1 << 6) | (1 << 7))) == 0;
            boolean right = (mask & ((1 << 6) | (1 << 7) | (1 << 8) | (1 << 9))) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}