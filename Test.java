import java.util.ArrayList;
public class Test {

    private static String TABLE_NAME_PRACTICE = "practice";
    private static String[] TABLE_ATTR_PRACTICE = {"practice_id serial NOT NULL PRIMARY KEY",
                                        "practice_int int NOT NULL"};

    public static void main(String args[]) {

        ArrayList<Table> tables = new ArrayList<Table>();
        
        tables.add(new Table(TABLE_NAME_PRACTICE, TABLE_ATTR_PRACTICE));
 /*System.out.println("DROP TABLE IF EXSISTS practice;");
        System.out.println("CREATE TABLE practice(cus_id serial NOT NULL PRIMARY KEY, name character varying(70) NOT NULL, ref_origin character varying(100) NOT NULL, ref_type character varying(70) NOT NULL);");*/

        for(int i = 0; i <= tables.size() - 1; i++) {
            if(tables.get(i) != null)
               createTable(tables.get(i));
        }

        //pulateSales();
        populatePractice();
        
        /*populateFeatures();
        populateCars();
        populateCarFeatures();

        populateEmployees();

        populateWarrantys();

        populateCustomer();

        populateCustomOptions();

        populateSalesPaymentsAndCustoms();*/

    }

    public static void populatePractice() {
        for(int i = 0; i < 100; i++) {
            System.out.printf("INSERT INTO practice (practice_int) VALUES (%d);", i);
            System.out.println();
        }
    }

    public static void createTable(Table t) {

        System.out.printf("DROP TABLE IF EXISTS %s \n;", t.name);
        String str = "";
        str += "CREATE TABLE " + t.name + " ( ";
        for(int i = 0; i < t.attributes.length; i++) {
            str += t.attributes[i];
            if(i < t.attributes.length - 1)
               str += ", ";
        }
        str += " );";
        System.out.println(str);
    }

    public static class Table {
    	public String name;
        public String[] attributes;

    	public Table(String name, String[] attributes) {
        	this.name = name;
	        this.attributes = attributes;
        }
    }
}
