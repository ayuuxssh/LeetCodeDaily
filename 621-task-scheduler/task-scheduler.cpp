class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int m = tasks.size();
        vector<int> freq(26, 0);
        priority_queue<int> pq;
        for (auto& it : tasks) {
            freq[it - 'A']++;
        }
        for (auto& it : freq) {
            if (it > 0) {
                pq.push(it);
            }
        }
        int time = 0;
        while (!pq.empty()) {
            vector<int> ans;
            for (int i = 1; i <= n + 1; i++) {
                if (!pq.empty()) {
                    int freq1 = pq.top();
                    pq.pop();
                    freq1--;
                    ans.push_back(freq1);
                }
            }
            for (auto& it : ans) {
                if (it > 0) {
                    pq.push(it);
                }
            }
            if (pq.empty()) {

                time += ans.size();
            } else {
                time += (n + 1);
            }
        }
        return time;
    }
};