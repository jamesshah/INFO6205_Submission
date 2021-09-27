//import java.util.ArrayList;
//import java.util.List;
//
//
//class Solution {
//
//    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        List<List<Integer>> res = threeSum(nums);
//
//        res.forEach((list)  ->
//        {
//            list.forEach((n)->System.out.println(n));
//        }
//        );
//    };
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
//
//        int len = nums.length;
//        for(int i =0; i < len - 2; i++){
//            for(int j = i+1; j < len - 1; j++){
//                for(int k = j+1; k < len; k++){
//                    if((nums[i] + nums[j] + nums[k]) == 0){
//                        ArrayList<Integer> temp = new ArrayList<Integer>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        res.add(temp);
//                    }
//                }
//            }
//        }
//
//        return res;
//    }
//}