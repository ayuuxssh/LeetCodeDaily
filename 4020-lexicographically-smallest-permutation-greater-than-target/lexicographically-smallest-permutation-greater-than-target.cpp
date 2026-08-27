class Solution {
public:
    
    bool solve(string&target,vector<int>freq,int index,bool greater,string &ans,string &result)
    {
        if(index==target.length())
        {
            if(greater)
            {
                ans =result;
                return true;
            }
            return false;
        }

        for(char c='a';c<='z';c++)
        {
            if(freq[c-'a']==0)
            {
              continue;
            }
            if(greater==false && c<target[index])
            {
                continue;
            }
            result.push_back(c);
            freq[c-'a']--;
             bool isGreater = greater || c>target[index];
            if(solve(target,freq,index+1,isGreater,ans,result))
            {
                return true;
            }
            result.pop_back();
            freq[c-'a']++;
        }
        return false;
    }
    string lexGreaterPermutation(string s, string target) {
        vector<int>freq(26,0);
        int n = s.length();
        for(auto &it:s)
        {
            freq[it-'a']++;
        }
        string ans="";
        string result;
        solve(target,freq,0,false,ans,result);
        return ans;
    }
};