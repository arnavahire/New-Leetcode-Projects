public class MergeSort {
    int[] array;

    public void mergeSort(int left, int right){
        if(left < right)
        {
            int mid = left + (right-left) / 2;

            mergeSort(left, mid);
            mergeSort(mid+1, right);
            merge(left, mid, right);
        }
    }

    // make a replica of the current array and use the pointers to handle and sort the elements
    public void merge(int left, int mid, int right)
    {
        int[] temp = new int[array.length];
        for(int i=left;i<=right;i++)
            temp[i] = array[i];
        int i=left, j=mid+1, k=left;

        while(i<mid+1 && j<right+1)
        {
            if(temp[i]<=temp[j])
            {
                array[k] = temp[i];
                i++;
            }
            else
            {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while(i<mid+1)
        {
            array[k] = temp[i];
            i++;
            k++;
        }
        while(j<right+1)
        {
            array[k] = temp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.array = new int[]{2, 4, 1, 6, 5, 3, 7, 8};
        ms.mergeSort( 0, ms.array.length-1);
        for(int i=0;i<ms.array.length;i++)
            System.out.println(ms.array[i]);

    }
}
