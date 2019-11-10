public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        if(A.length<3)
            return 0;
        for(int i=1;i<A.length-1;i++)
        {
            if((A[i]>A[i-1]) && (A[i]>A[i+1]))
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        PeakIndexInAMountainArray piiama = new PeakIndexInAMountainArray();
        int[] arr= {0,1,2};
        int result = piiama.peakIndexInMountainArray(arr);
        System.out.println(result);
    }
}
