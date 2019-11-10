import java.util.HashMap;
import java.util.Map;

public class RobotReturnToOrigin {
    /*Method 1: Brute Force*/

//    public boolean judgeCircle(String moves) {
//        moves = moves.toUpperCase();
//        int lCount=0, rCount=0, uCount=0, dCount=0;
//        for(int i=0;i<moves.length();i++)
//        {
//            if(moves.charAt(i)=='R')
//                rCount++;
//            if(moves.charAt(i)=='L')
//                lCount++;
//            if(moves.charAt(i)=='U')
//                uCount++;
//            if(moves.charAt(i)=='D')
//                dCount++;
//        }
//        if((lCount==rCount) && (uCount==dCount))
//            return true;
//        return false;
//    }

    /* Method 2: Optimized*/
    public boolean judgeCircle(String moves) {
        moves = moves.toUpperCase();
        int up=0, left=0;
        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='R')
                left--;
            if(moves.charAt(i)=='L')
                left++;
            if(moves.charAt(i)=='U')
                up++;
            if(moves.charAt(i)=='D')
                up--;
        }
        return up == 0 && left == 0;
    }
    public static void main(String[] args) {
        RobotReturnToOrigin rrto = new RobotReturnToOrigin();
        String str = "LR";
        boolean result = rrto.judgeCircle(str);
        System.out.println(result);
    }
}
