class Solution {
    static int[] st;
    int size;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> rank = new HashMap<>();
        int id = 0;
        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, id++);
            }
        }
        size = id;
        st = new int[4 * size];
        Integer[] ans = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            int r = rank.get(nums[i]);
            ans[i] = query(0, 0, size - 1, 0, r - 1); 
            update(0, 0, size - 1, r, 1);    
        }
        return Arrays.asList(ans);
    }
    public void update(int idx, int l, int r, int i, int val) {
        if (l == r) {
            st[idx] += val;
            return;
        }
        int mid = (l + r) / 2;
        if (i <= mid) {
            update(2 * idx + 1, l, mid, i, val);
        } else {
            update(2 * idx + 2, mid + 1, r, i, val);
        }
        st[idx] = st[2 * idx + 1] + st[2 * idx + 2];
    }
    public int query(int idx, int l, int r, int qs, int qe) {
        if (r < qs || l > qe) return 0; 
        if (l >= qs && r <= qe) return st[idx]; 
        int mid = (l + r) / 2;
        int left = query(2 * idx + 1, l, mid, qs, qe);
        int right = query(2 * idx + 2, mid + 1, r, qs, qe);
        return left + right;
    }
}