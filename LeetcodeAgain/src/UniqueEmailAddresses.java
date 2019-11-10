import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if(emails.length==0)
            return 0;
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        for(int i=0;i<emails.length;i++)
        {
            sb = new StringBuilder();
            char[] e = emails[i].toCharArray();
            int j=0;
            while(j<e.length && e[j]!='@')
            {
                if(e[j]=='.')
                    j++;
                else if(e[j]=='+')
                {
                    while(e[j]!='@')
                        j++;
                }
                else
                {
                    sb.append(e[j]);
                    j++;
                }
            }
            while(j<e.length)
            {
                sb.append(e[j]);
                j++;
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses uea= new UniqueEmailAddresses();
        String[] str = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int result = uea.numUniqueEmails(str);
        System.out.println(result);
    }
}
