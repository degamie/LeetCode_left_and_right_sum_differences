class Solution {
  
//NEw Approach
  //T(C(N) nd S(C(N))==O(N) as it requires contigous space alloc iteratively 
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;     // Total sum of all elements
        int sum2 = 0;    // Running sum of left-side elements
        int[] res = new int[nums.length]; // Result array

        // Step 1: Calculate total sum
        for (int x : nums) {
            sum += x;
        }

        // Step 2: Traverse the array and compute differences
        for (int i = 0; i < nums.length; i++) {
            // Right sum = total sum - current element - left sum
            int rightSum = sum - nums[i] - sum2;
            int leftSum = sum2;

            // Store absolute difference between left and right sums
            res[i] = Math.abs(rightSum - leftSum);

            // Update left sum for next iteration
            sum2 += nums[i];
        }

        return res;
    }
}
//old Approach
// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int[] out;
//         int[] leftSum;
//         int[] rightSum;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length-1;j++){
//             if(leftSum[i]>rightSum[i]){
//                 if(nums[i]>nums[j]){
//                     leftSum[i]+=Math.max(leftSum[j]+nums[i]);}
//                     else {leftSum[i]=0;}
//                     if(nums[j]>nums[i]){
//                     rightSum[i]+=Math.max(leftSum[j]+nums[i]);}
//                     else {rightSum[i]=0;}
//         out+=Math.max(Math.mod(leftSum[i]-rightSum[i]));
//                     }else out[i]+=0;
//                 }
//         }return out;}

// }
