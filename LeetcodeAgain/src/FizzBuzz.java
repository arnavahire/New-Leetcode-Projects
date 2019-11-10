import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        List<String> res = new ArrayList<>();
        while (n>0)
        {
            if(n%5==0 && n%3==0)
                result.add("FizzBuzz");
            else if(n%5==0)
                result.add("Buzz");
            else if(n%3==0)
                result.add("Fizz");
            else
                result.add(String.valueOf(n));
            n--;
        }
        for(int i=result.size()-1;i>=0;i--)
            res.add(result.get(i));
        return res;
    }

    public static void main(String[] args) {
        int n=15;
        FizzBuzz fb = new FizzBuzz();
        List<String> result = fb.fizzBuzz(n);
        System.out.println(result);
    }
}
