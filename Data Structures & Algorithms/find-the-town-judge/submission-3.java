class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] f=new int[n+1];
        for(int[] arr: trust){
            f[arr[0]]--;
            f[arr[1]]++;

        }
        for(int i=1; i<=n;i++){
            if(f[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}