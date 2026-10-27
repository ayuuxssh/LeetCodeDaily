class LRUCache {
public:
vector<pair<int,int>>v;
unordered_map<int,int>mp;
int cap ;
    LRUCache(int capacity) {
        cap = capacity;
    }
    
    int get(int key) {
        if(mp.find(key)==mp.end())
        {
            return -1;
        }
        // cout<<key<<" "<<mp[key]<<endl;
        auto it = find(v.begin(),v.end(),make_pair(key,mp[key]));
        v.erase(it);
        v.push_back({key,mp[key]});
        return mp[key];
    }
    
    void put(int key, int value) {
         if(mp.find(key)!=mp.end())
         {
            auto it = find(v.begin(),v.end(),make_pair(key,mp[key]));
            v.erase(it);
         }
         else if(v.size()==cap)
         {
            auto it = v.begin();
            //  cout<<it->first<<endl;
            mp.erase(it->first);
            v.erase(it);
            
         }
         v.push_back({key,value});
         mp[key]=value;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */