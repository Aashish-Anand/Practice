package diffrentQuestion;

public class FirstMissingNumber {

	public static int missing(int nums[], int len) {
		int flag = 0;
		int flag0=0;
        for(int i = 0;i<len;i++){
            if(nums[i]<0 || nums[i]>len){
                nums[i] = Integer.MAX_VALUE;
                flag = 1;
            }
            if(nums[i] == 1){
                flag =1;
            }
            if(nums[i] == 0) {
            	flag0= 1;
            }
        }
        if(flag == 0){
            return 1;
        }
        
        for(int i = 0;i<len;i++) {
            if(Math.abs(nums[i])<len ) {
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
        }
        int i=0;
        for(i = 0;i<len;i++) {
            if(nums[i] > 0&& i!=0){
                return i;
            }
        }
        //System.out.println(i);
        return flag0==1?len:len+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int nums[] = {1,0,2};
		int nums[] = {1};
		//int nums[] = {3,4,-1,1};

        int len = nums.length;
        
        System.out.println(missing(nums,len));
	}

}
