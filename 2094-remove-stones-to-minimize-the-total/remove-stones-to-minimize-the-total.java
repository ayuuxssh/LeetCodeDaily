class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int it:piles)
        {
            pq.add(it);
        }
        while(k>0)
        {
            int x = pq.poll();
            x -=(x/2);
            pq.add(x);
            k--;
        }
        int sum =0;
        while(!pq.isEmpty())
        {
            sum+=pq.poll();
        }
        return sum;
    }
}