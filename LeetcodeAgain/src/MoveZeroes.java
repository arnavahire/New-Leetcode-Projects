public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[count] = nums[i];
                count++;
            }
        }
        while(count < nums.length)
        {
            nums[count] = 0;
            count++;
        }
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");

    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] arr = {0,1,0,3,12};
        mz.moveZeroes(arr);

    }
}
