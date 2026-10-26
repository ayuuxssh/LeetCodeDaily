class RandomizedSet {
public:
 vector<int>v;
    RandomizedSet() {
    }
    
    bool insert(int val) {
        if(find(v.begin(),v.end(),val)!=v.end())
        {
            return false;
        }
        v.push_back(val);
        return true;
    }
    
    bool remove(int val) {
        if(find(v.begin(),v.end(),val)==v.end())
        {
            return false;
        }
        auto it = find(v.begin(),v.end(),val);
        v.erase(it);
        return true;
    }
    
    int getRandom() {
        int x = rand()%v.size();
        return v[x];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */