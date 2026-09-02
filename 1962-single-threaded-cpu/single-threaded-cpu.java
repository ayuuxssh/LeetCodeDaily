class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[0], b[0]);
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];
            list.add(new int[] { start, end, i });
        }
        List<Integer> ans = new ArrayList<>();
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        long time = list.get(0)[0];
        int taskidx = 0;
        int residx = 0;
        int []res = new int[n];
        while (residx < n) {
            if (pq.isEmpty() && time < list.get(taskidx)[0]) {
                time = list.get(taskidx)[0];
            }
            while (taskidx < n && time >= list.get(taskidx)[0]) {
                pq.add(new int[] { list.get(taskidx)[1], list.get(taskidx)[0], list.get(taskidx)[2] });
                taskidx++;
            }
            int[] ans1 = pq.poll();
            time += ans1[0];
            res[residx++] = ans1[2];
        }
        return res;
    }

}