class Solution {
public:
    int minOperations(string &s1, string &s2) {
        int n = s1.length();
        int count =0;
        bool ischanged = false;
        for(int i=0;i<n;i++)
            {
                char c = s1[i];
                char c1 = s2[i];
                if(ischanged)
                {
                    c='0';
                    ischanged = false;
                }
                if(c==c1)
                {
                    continue;
                }
                else if(c=='0' && c1=='1')
                    {
                        count++;
                    }
                    else if(c=='1' && c1=='0')
                    {
                        if(i==n-1)
                        {
                            if(n==1)
                            {
                            return -1;
                            }
                            count+=2;
                        }
                        else
                        {
                        if(s1[i+1]=='1')
                        {
                            count+=1;
                        }
                        else
                        {
                            count+=2;
                        }
                        ischanged = true;
                    }
                    }
                    
            }
        return count;
    }
};