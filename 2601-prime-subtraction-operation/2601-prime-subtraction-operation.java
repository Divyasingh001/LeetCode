class Solution {
    public boolean isprime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public boolean primeSubOperation(int[] nums) {
        int maxelement=Integer.MIN_VALUE;
        for(int num:nums){
            maxelement=Math.max(num,maxelement);
        }
        int previousprime[]=new int[maxelement+1];
        for(int i=2;i<=maxelement;i++){
            if(isprime(i)){
                previousprime[i]=i;
            }
            else{
                previousprime[i]=previousprime[i-1];
            }
        }
        for(int i=0;i<nums.length;i++){
            int bound;
            if(i==0){
                bound=nums[i];
            }
            else{
                bound=nums[i]-nums[i-1];
            }
            if(bound<=0){
                return false;
            }
            int largestprime=previousprime[bound-1];
            nums[i]-=largestprime;
        }
        return true;
    }
}