import java.util.*;

class Employee{
    String name;
    int salary;
}
public class SortingEmployees {

    public List<Employee> sortEmployees(int n, List<Employee> list)
    {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.salary==o2.salary)
                    return o1.name.compareTo(o2.name);

                else if (o1.salary < o2.salary)
                    return -1;
                else return 1;
            }
        });
        return list;
    }


    public static void main(String[] args) {
        System.out.println("Enter number of Employees");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println("Enter employee info");
        Scanner scan2 = new Scanner(System.in);
        String s2 = scan2.nextLine();
        int n = Integer.valueOf(s);
        String[] splits = s2.split(" ");
        List<Employee> list = new ArrayList<>();
        for(int i=0;i<splits.length;i++)
        {
            Employee e = new Employee();
            if(i%2==0){
                e.name=splits[i];
                i++;
            }
            if(i%2!=0)
            {
                e.salary= Integer.valueOf(splits[i]);
                list.add(e);
            }
        }
        SortingEmployees se = new SortingEmployees();
        List<Employee> output = se.sortEmployees(n, list);
        for(Employee emp : output)
            System.out.println(emp.name + " " + emp.salary);
    }
}
