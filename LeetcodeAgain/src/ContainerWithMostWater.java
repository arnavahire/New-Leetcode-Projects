public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int maxArea = 0;

        while(left < right)
        {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int minHeight = Math.min(leftHeight, rightHeight);
            int width = right - left;

            area = width * minHeight;

            maxArea = Math.max(maxArea, area);

            if(minHeight == leftHeight)
                left++;
            else
                right--;
        }

        return maxArea;
    }

}
