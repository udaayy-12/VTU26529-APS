class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int j=0;
        while(i-j!=k){
            while(!dq.isEmpty() && dq.peekFirst()<nums[i]){
                dq.removeFirst();
            }
            if(dq.isEmpty() || dq.peekFirst()>=nums[i]){
                dq.addFirst(nums[i]);
            }
            i++;
        }
        int [] ans=new int[nums.length-k+1];
        ans[j]=dq.peekLast();
        while(i!=nums.length){
            if(dq.peekLast()==nums[j] ){
                dq.removeLast();
            }
            j++;
            while(!dq.isEmpty() && dq.peekFirst()<nums[i]){
                dq.removeFirst();
            }
            if(dq.isEmpty() || dq.peekFirst()>=nums[i]){
                dq.addFirst(nums[i]);
            }
            i++;
            ans[j]=dq.peekLast();
        }
        return ans;
    }
}