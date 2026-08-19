class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int,unordered_set<int>>mp;
        for(auto it:reservedSeats)
        {
            int row = it[0];
            int col = it[1];
            mp[row].insert(col);
        }

        int result = (n-mp.size())*2;
        for(auto &[row,booked]:mp)
        {
            auto isAvail = [&](int seat)
            {
                return booked.find(seat)==booked.end();
            };

            bool grpA = isAvail(2) && isAvail(3) && isAvail(4) && isAvail(5);
            bool grpB = isAvail(4) && isAvail(5) && isAvail(6) && isAvail(7);
            bool grpC = isAvail(6) && isAvail(7) && isAvail(8) && isAvail(9);

            if(grpA  && grpC)
            {
                result+=2;
            }
            else if(grpA || grpB || grpC)
            {
                result+=1;
            }
        }
        return result;
    }
};