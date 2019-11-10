/* Catch: Bit Manipulation

Num1 XOR 0 -> Num1
Num1 XOR Num1 -> 0

*/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int i=0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] arr = {2, 2, 1, 1, 4};
        System.out.println("Single Number: " + sn.singleNumber(arr));
    }
}
