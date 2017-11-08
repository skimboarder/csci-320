import java.util.Random;

public class EmployeeHelper implements Helper{
    
    private static String TABLE_NAME_EMPLOYEE = "employee";
    private static String[] TABLE_ATTR_EMPLOYEE = {
                                                   "emp_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "emp_name character varying(70) " +
                                                          "NOT NULL",
                                                   "commission numeric(5,2) " +
                                                          "NOT NULL", 
                                                   "role character varying(70) "+
                                                          "NOT NULL",
                                                   "CONSTRAINT value_is_percentage " +
                                                          "CHECK ((" +
                                                          "(commission >= (0)::numeric) AND " +
                                                          "(commission < (100)::numeric) ))"
                                             };
    private static Employee[] EMPLOYEES = { new Employee("Jim Friendly", 30, "Manager"),
                                           new Employee("Diane Graham", 10, "sales"),
                                           new Employee("Keven Greene", 10, "sales"),
                                           new Employee("Joshua Fraser", 05, "sales"),
                                           new Employee("Brian Morrison", 00, "sec"),
                                           new Employee("Casey Smith", 10, "sales"),
                                           new Employee("Chase Jones", 10, "sales"),
                                           new Employee("Mike Doe", 20, "sales"),
                                           new Employee("Connor Davis", 15, "sales"),
                                           new Employee("Ariana Buck", 15, "sales")
                                          };

    private static String INSERT_PREFIX = "INSERT INTO employee (emp_name, commission, role) " +
                                              "VALUES (";

    private static String INSERT_SUFFIX = ");";
 

    public EmployeeHelper() {
    
    }


    public void populate() {
        
        for(int i = 0; i < EMPLOYEES.length; i++) {
            String val = "\'" + EMPLOYEES[i].name+ "\', " +
                         EMPLOYEES[i].commission+", \'"+EMPLOYEES[i].role+"\'";
            System.out.println(INSERT_PREFIX + val + INSERT_SUFFIX);
        }
    }

    public String getName() {
        return TABLE_NAME_EMPLOYEE; 
    }
    
    public String[] getAttributes() {
        return TABLE_ATTR_EMPLOYEE;
    }
   
    public static Employee[] getEmployees() {
        return EMPLOYEES;
    } 

    public static int getRandomId(Random rn) {
        return rn.nextInt(EMPLOYEES.length - 1) + 1;
    }
    private static class Employee {
        public String name;
        public int commission;
        public String role;
        
        public Employee(String name, int commission, String role) {
            this.name = name;
            this.commission = commission;
            this.role = role;
        }
     }

}
