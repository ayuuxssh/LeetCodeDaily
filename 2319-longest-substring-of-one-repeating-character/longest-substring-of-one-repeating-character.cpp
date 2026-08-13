class Solution {
private:
    struct Node {
        int maxlen;
        int pre;
        int suff;
        char left;
        char right;
        Node() : maxlen(0), pre(0), suff(0), left(' '), right(' ') {};

        Node(int maxlen, int pre, int suff, char left, char right) {
            this->maxlen = maxlen;
            this->pre = pre;
            this->suff = suff;
            this->left = left;
            this->right = right;
        }
    };
    class SegmentTree {
    public:
        vector<Node> segment;

        SegmentTree(int n) { segment.resize(4 * n); }

        Node merge(Node& left, Node& right, int leftlen, int rightlen) {
            Node res;
            res.maxlen = max(left.maxlen, right.maxlen);
            res.left = left.left;
            res.right = right.right;
            res.pre = left.pre;
            res.suff = right.suff;
            if (left.right == right.left) {
                res.maxlen = max(res.maxlen, left.suff + right.pre);
            }
            if (left.pre == leftlen && left.right == right.left) {
                res.pre += right.pre;
            }
            if (right.suff == rightlen && left.right == right.left) {
                res.suff += left.suff;
            }
            return res;
        }

        void build(string&s, int start, int end, int index) {
            if (start == end) {
                segment[index] = Node(1, 1, 1, s[start], s[end]);
                return;
            }
            int mid = start + (end - start) / 2;
            build(s, start, mid, 2 * index + 1);
            build(s, mid + 1, end, 2 * index + 2);
            segment[index] =
                merge(segment[2 * index + 1], segment[2 * index + 2],
                      mid - start + 1, end - mid);
        }
        void update(string&s, int start, int end, int index, int pos,
                    char val) {
            if (start == end) {
                s[pos] = val;
                segment[index] = Node(1, 1, 1, s[pos], s[pos]);
                return;
            }
            int mid = start + (end - start) / 2;
            if (pos > mid) {
                update(s, mid + 1, end, 2 * index + 2, pos, val);
            } else {
                update(s, start, mid, 2 * index + 1, pos, val);
            }
            segment[index] =
                merge(segment[2 * index + 1], segment[2 * index + 2],
                      mid - start + 1, end - mid);
        }
    };

public:
    vector<int> longestRepeating(string s, string queryCharacters,
                                 vector<int>& queryIndices) {
        int n = s.length();
        SegmentTree sb(n);
        sb.build(s, 0, n - 1, 0);
        int q = queryIndices.size();
        vector<int> ans(q);
        for (int i = 0; i < q; i++) {
            sb.update(s, 0, n - 1, 0, queryIndices[i], queryCharacters[i]);
            ans[i] = sb.segment[0].maxlen;
        }
        return ans;
    }
};