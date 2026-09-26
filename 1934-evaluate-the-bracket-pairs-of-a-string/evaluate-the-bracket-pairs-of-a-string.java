class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mp = new HashMap<>();
        int n = knowledge.size();
        for (int i = 0; i < n; i++) {
            String st = knowledge.get(i).get(0);
            String st1 = knowledge.get(i).get(1);
            mp.put(st, st1);
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                i++;
                if (mp.containsKey(sb.toString())) {
                    ans.append(mp.get(sb.toString()));
                } else {
                    ans.append("?");
                }
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}