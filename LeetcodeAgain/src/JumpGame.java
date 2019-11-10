import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // You have already reached the end if the array length is 1 or less than that
        if(nums.length<=1 || nums == null)
            return true;

        //Let the first number be max
        int max = nums[0];

        for(int i=0;i<nums.length;i++)
        {
            if(max <=i && nums[i] == 0)
                return false;

            if((i+nums[i]) > max)
                max = i + nums[i];

            if(max >= nums.length-1)
                return true;
        }

        // if in the loop our max doesn't reach the end, it means that the jumps weren't enough to reach the end, hencce return false
        return false;
    }

    /* JumpGame variation where you have to get the total number of jumps made and on which indices did the jump happen */
    public boolean canJumpVariation(int[] nums) {
        // we will need a list where we can append the jumps and also a counter to store the jump count
        List<Integer> jumps = new ArrayList<>();
        int jumpCount = 0;

        if(nums==null || nums.length<=1)
            return true;

        int max = nums[0];
        jumps.add(0);

        for(int i=0;i<nums.length;i++)
        {
            if(max<=i && nums[i]==0)
                return false;

            if((i+nums[i]) > max)
            {
                max = i + nums[i];
                jumps.add(i);
                jumpCount++;
            }

            if(max >= nums.length-1)
            {
                jumpCount++;
                jumps.add(nums.length-1);
                for(int x=0;x<jumps.size();x++)
                {
                    System.out.print(jumps.get(x)+" ");
                }
                System.out.println();
                System.out.println(jumpCount);
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        JumpGame jg=new JumpGame();
        int[] nums={2,3,1,1,2,4,2,0,1,1};
        boolean result=jg.canJumpVariation(nums);
        System.out.println(result);

    }
}
