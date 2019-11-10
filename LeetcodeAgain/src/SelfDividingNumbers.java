import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int j=left;j<right+1;j++)
        {
            boolean res = is_number_self_divisible(j);
            if(res==true)
                result.add(j);
        }
        return result;
    }

    public boolean is_number_self_divisible(int number)
    {
        int i = number;
        while(i!=0)
        {
            int digit = i%10;
            if(digit==0)
                return false;
            if(number%digit!=0)
                return false;
            else
                i=i/10;
        }
        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers sdn = new SelfDividingNumbers();
        int left = 1;
        int right = 22;
        List<Integer> result = sdn.selfDividingNumbers(left, right);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }
}
