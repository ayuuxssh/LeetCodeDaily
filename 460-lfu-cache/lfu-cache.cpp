class LFUCache {
public:
    unordered_map<int, pair<list<pair<int, int>>::iterator, int>> mp;
    map<int, list<pair<int, int>>> freq;
    int n;
    LFUCache(int capacity) { n = capacity; }
    void make(int key) { return; }
    int get(int key) {
        if (mp.find(key) == mp.end()) {
            return -1;
        }
        auto& it = *(mp[key].first);
        int count = it.second;
        freq[count].erase(mp[key].first);
        if (freq[count].empty()) {
            freq.erase(count);
        }
        count++;
        freq[count].push_front({key, count});
        mp[key] = {freq[count].begin(), mp[key].second};
        return mp[key].second;
    }

    void put(int key, int value) {
        if (mp.find(key) != mp.end()) {
            auto& it = *(mp[key].first);
            int count = it.second;
            freq[count].erase(mp[key].first);
            if (freq[count].empty()) {
                freq.erase(count);
            }
            count++;
            freq[count].push_front({key, count});
            mp[key] = {freq[count].begin(), value};
            return;
        } else if (mp.size() == n) {
            auto it = freq.begin();
            int del = it->second.back().first;
            int count = it->second.back().second;
            it->second.pop_back();
            if (freq[count].empty()) {
                freq.erase(count);
            }
            mp.erase(del);
        }

        freq[1].push_front({key, 1});
        mp[key] = {freq[1].begin(), value};
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */