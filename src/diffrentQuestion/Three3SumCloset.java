package diffrentQuestion;

import java.util.Arrays;

public class Three3SumCloset {

	public static void main(String[] args) {
		int nums[] = {1,1,1,0};
		int target = -100;
		
        Arrays.sort(nums);
        
        int closet_sum = Integer.MAX_VALUE;
        
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        for(int i = 0;i<len-2;i++){
            if(i!= 0 && nums[i]== nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = len-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                
                if(Math.abs(target - sum)<diff){
                    diff = Math.abs(target-sum);
                    closet_sum = sum;
                    j++;
                    while(j<k && nums[j]==nums[j-1]){j++;}
                }
                else if(sum > diff) {
                	k--;
                }else if(sum < diff) {
                	j++;
                }
            }
        }
        System.out.println(closet_sum);
	}

}
