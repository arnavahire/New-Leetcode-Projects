public class KthLargestElementInAnArray {


    // Using Basic Quick Sort

    public int findKthLargestUsingQuickSort(int[] nums, int k) {
        int[] sortedArray = quickSort1(nums, 0, nums.length-1);
        return sortedArray[nums.length - k];
    }

    public int[] quickSort1(int[] nums, int start, int end)
    {
        if(start < end)
        {
            // first get all elements that are less than pivot on left side of pivot and then place pivot at required place, and after that, call sort on either sides of pivot
            int pivot_index = partition1(nums, start, end);
            quickSort1(nums, start, pivot_index - 1);
            quickSort1(nums, pivot_index + 1, end);
        }
        return nums;// else return nums array as it is, if start == end of start > end cause that will happen only if there is 1 element in the array or 0 element and it will always be sorted in those cases
    }

    public int partition1(int[] nums, int start, int end)
    {
        int pivot = nums[end];
        int pivotIndex = start;
        for(int i=start; i<end;i++)
        {
            if(nums[i]<=pivot)
            {
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                pivotIndex++;
            }
        }

        int temp = pivot;
        nums[end] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        return pivotIndex;
    }

    // More optimized solution using Quick sort.
    // Here we will see if the pivot_index is less than or greater than the index which will return our kth largest number
    // depending upon that we will only apply quicksort at that index which needs to be sorted to return the value

    // This solution will be O(n) and not O(n.logn) because here we will be recursively solving only 1 half of the array and not entire array depending upon the k value

    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = quickSort(nums, 0, nums.length-1, k);
        return sortedArray[nums.length - k];
    }

    public int[] quickSort(int[] nums, int start, int end, int k)
    {
        if(start < end)
        {
            // first get all elements that are less than pivot on left side of pivot and then pllace pivot at required place, an after that, call sort on either sides of pivot
            int pivot_index = partition(nums, start, end);
            if(pivot_index > nums.length - k)
                quickSort(nums, start, pivot_index - 1, k);
            else if(pivot_index < nums.length - k)
                quickSort(nums, pivot_index + 1, end, k);
        }
        return nums;// else return nums array as it is, if start == end of start > end cause that will happen only if there is 1 element in the array or 0 element and it will always be sorted in those cases
    }

    public int partition(int[] nums, int start, int end)
    {
        int pivot = nums[end];
        int pivotIndex = start;
        for(int i=start; i<end;i++)
        {
            if(nums[i]<=pivot)
            {
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                pivotIndex++;
            }
        }

        int temp = pivot;
        nums[end] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        return pivotIndex;
    }

}
