class BrowserHistory {
public:
stack<string>backward;
stack<string>forward1;
    BrowserHistory(string homepage) {
        backward.push(homepage);
    }
    void visit(string url) {
        backward.push(url);
        // cout<<url<<endl;
        while(!forward1.empty())
        {
            // cout<<forward1.top()<<endl;
            forward1.pop();
        }
    }
    string back(int steps) {
      while(backward.size()>1 && steps!=0)
      {
          string ans = backward.top();
           backward.pop();
           forward1.push(ans);
        //    cout<<ans<<endl;
           steps--;
      }
      return backward.top();
    }
    
    string forward(int steps) {
    while(!forward1.empty() && steps!=0)
    {
        string ans = forward1.top();
        forward1.pop();
        backward.push(ans);
        steps--;
    }
    return backward.top();
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */