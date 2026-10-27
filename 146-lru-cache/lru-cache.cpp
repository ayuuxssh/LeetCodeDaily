class LRUCache {
public:
list<int>dll;
unordered_map<int,pair<list<int>::iterator,int>>mp;
int cap ;
    LRUCache(int capacity) {
        cap = capacity;
    }
    
    int get(int key) { // O(2N)
        if(mp.find(key)==mp.end())
        {
            return -1;
        }
        // cout<<key<<" "<<mp[key]<<endl;
       auto it = mp[key].first;
       dll.erase(it);
       dll.push_front(key);
       mp[key]={dll.begin(),mp[key].second};
       return mp[key].second;
    }
    
    void put(int key, int value) { //O(2N)
         if(mp.find(key)!=mp.end())
         {
            auto it= mp[key].first;
            dll.erase(it);
         }
         else if(dll.size()==cap)
         {
            int k = dll.back();
            //  cout<<it->first<<endl;
            dll.pop_back();
           mp.erase(k);
            
         }
        dll.push_front(key);
         mp[key]={dll.begin(),value};
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */