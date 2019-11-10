public class TrappingRainWater {
    public int trap(int[] height) {

        // return 0 for null or empty array
        if(height == null || height.length==0)
            return 0;

        int leftMax = 0;
        int rightMax = 0;

        // create an array to store the left Max height and the right Max height at each index
        int[] leftMaxArray = new int[height.length];
        int[] rightMaxArray = new int[height.length];

        //Initialize leftMax Height and rightMax Height to be 0 so that no rain water is trapped at the beginning and end

        leftMaxArray[0] = leftMax; // let the leftMax be 0 initially

        // calculate leftMax at every index by comparing the previous leftMax and the previous element
        for(int i=1; i<height.length; i++)
        {
            leftMax = Math.max(height[i-1], leftMax);
            leftMaxArray[i] = leftMax;
        }

        rightMaxArray[height.length-1] = rightMax; // let the rightMax be 0 initially

        // calculate rightMax at every index by comparing the previous leftMax and the previous element. Calculcate rightMax from opposite direction

        for(int i=height.length-2; i>=0; i--)
        {
            rightMax = Math.max(height[i+1], rightMax);
            rightMaxArray[i] = rightMax;
        }

        int sum = 0;

        // calculate the trapped water by adding the left and right max at every index and subtracting the value at that index.
        // if value <=0 dont add it to the sum, else add it
        for(int i=0;i<height.length;i++)
        {
            int trappedWater = Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
            if(trappedWater<=0)
                continue;
            else
                sum+=trappedWater;
        }

        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("Answer: "+trw.trap(height));
    }
}
