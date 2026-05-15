package com.dsapattern;

public class PreFixLeet {
        int prefix[];

        public PreFixLeet(int[] nums) {
            prefix=new int[nums.length];
            prefix[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                prefix[i]=prefix[i-1]+nums[i];
            }
            for(int i=0;i<prefix.length;i++){
                System.out.print(prefix[i]+" ");
            }

        }

        public int sumRange(int left, int right) {

            int sum;
            if(left==0){
                sum=prefix[right];
                // System.out.println(sum);
            }
            else{
                sum=prefix[right]-prefix[left-1];
                // System.out.println(sum);

            }
            return sum;
        }
        public static void main(String[]args){
            int[]nums={-2, 0, 3, -5, 2, -1};

            PreFixLeet n=new PreFixLeet(nums);
            n.sumRange(0,2);
            n.sumRange(2,5);
            n.sumRange(0,5);

        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

