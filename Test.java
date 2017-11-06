import java.util.ArrayList; 
import java.util.Random;

public class Test {

    public static String TABLE_NAME_PRACTICE = "practice";
    public static String[] TABLE_ATTR_PRACTICE = {
                                                   "practice_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "practice_int int " +
                                                          "NOT NULL"
                                                  };
    
    public static String TABLE_NAME_CAR = "car";
    public static String[] TABLE_ATTR_CAR = {
                                                   "vin integer " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "sticker_price money " +
                                                          "NOT NULL",
                                                   "make character varying(70) " +
                                                          "NOT NULL",
                                                   "model character varying(70) " +
                                                          "NOT NULL",
                                                   "year integer " +
                                                          "NOT NULL",
                                                   "color character varying(70) " +
                                                          "NOT NULL",
                                                   "is_new boolean " +
                                                          "NOT NULL",
                                                   "is_sold boolean " +
                                                          "NOT NULL",
                                                   "min_price money " +
                                                          "NOT NULL",
                                                   "mileage integer " +
                                                          "NOT NULL"
                                             };
    
    public static String TABLE_NAME_FEATURES = "features";
    public static String[] TABLE_ATTR_FEATURES = {
                                                   "feat_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "feat_name character varying(70) " +
                                                          "NOT NULL"
                                             };
    public static String[] FEATURES = {
                                       "AC", "Heated Seats", "Power Windows",
                                       "Sunroof", "Leather Seats", "Sirius XM Radio"
                                      };

    public static String TABLE_NAME_HAS_FEATURES = "has_features";
    public static String[] TABLE_ATTR_HAS_FEATURES = {
                                                   "feat_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "features(feat_id) " +
                                                          "ON DELETE CASCADE",
                                                   "vin integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "car(vin) " +
                                                          "ON DELETE CASCADE",
                                                   "PRIMARY KEY(feat_id, vin)"
                                             };

    public static String TABLE_NAME_CUSTOMER = "customer";
    public static String[] TABLE_ATTR_CUSTOMER = {
                                                   "cus_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "name character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_type character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_origin character varying(70) " +
                                                          "NOT NULL"
                                             };
    public static Customer[] CUSTOMERS = { new Customer("Frank Murray", "none", "none"),
                                           new Customer("Jan Scott", "web", "facebook.com"),
                                           new Customer("Adrian Blake", "mouth", "Emma Peake"),
                                           new Customer("Emma Peake", "web", "cars.com"),
                                           new Customer("Adam Parr", "tv ad", "channel 3")
                                          };
    public static String[] REF_ORIGINS = { "web", "mouth", "tv ad" };
    public static String[] ORIGINS_WEB = { "facebook.com", "cars.com", "carfax.com" };
    public static String[] ORIGINS_TV = { "channel 3", "channel 4", "channel 6" };
    public static String[] ORIGINS_MOUTH = { "Emma Peake", "Adam Parr", "Jim Friendly" };

    public static String TABLE_NAME_EMPLOYEE = "employee";
    public static String[] TABLE_ATTR_EMPLOYEE = {
                                                   "emp_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "emp_name character varying(70) " +
                                                          "NOT NULL",
                                                   "commission numeric(5,2) " +
                                                          "NOT NULL",
                                                   "CONSTRAINT value_is_percentage " +
                                                          "CHECK ((" +
                                                          "(commission > (1)::numeric) AND " +
                                                          "(commission < (100)::numeric) ))"
                                             };
    public static Employee[] EMPLOYEES = { new Employee("Jim Friendly", 30),
                                           new Employee("Diane Graham", 10),
                                           new Employee("Keven Greene", 10),
                                           new Employee("Joshua Fraser", 05),
                                           new Employee("Brian Morrison", 05)
                                          };
 
    public static String TABLE_NAME_PAYMENT = "payment";
    public static String[] TABLE_ATTR_PAYMENT = {
                                                   "payment_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "amount money " +
                                                          "NOT NULL",
                                                   "trade_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "trade_in(trade_id) " +
                                                          "ON DELETE CASCADE",
                                                   "fin_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "financing(fin_id) " +
                                                          "ON DELETE CASCADE"
                                             };

    public static String TABLE_NAME_FINANCING = "financing";
    public static String[] TABLE_ATTR_FINANCING = {
                                                   "fin_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "amount money " +
                                                          "NOT NULL",
                                                   "type character varying(250) " +
                                                          "NOT NULL",
                                                   "name character varying(70) " +
                                                          "NOT NULL",
                                                   "addr character varying(100) " +
                                                          "NOT NULL"
                                             };
    
    public static String TABLE_NAME_TRADE_IN = "trade_in";
    public static String[] TABLE_ATTR_TRADE_IN = {
                                                   "trade_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "vin integer " +
                                                          "NOT NULL",
                                                   "miles integer " +
                                                          "NOT NULL",
                                                   "condition character varying(250) " +
                                                          "NOT NULL",
                                                   "value money " +
                                                          "NOT NULL",
                                                   "date date " +
                                                          "NOT NULL"
                                             };
        
    public static String TABLE_NAME_SALE = "sale";
    public static String[] TABLE_ATTR_SALE = {
                                                   "sale_id integer " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "is_approved boolean " +
                                                          "NOT NULL",
                                                   "price money " +
                                                          "NOT NULL",
                                                   "date date " +
                                                          "NOT NULL",
                                                   "emp_requested boolean " +
                                                          "NOT NULL",
                                                   "tax_rate numeric(5,2) " +
                                                          "NOT NULL",
                                                   "license_fee money " +
                                                          "NOT NULL",
                                                   "cus_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "customer(cus_id) " +
                                                          "ON DELETE CASCADE",
                                                   "vin integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "car(vin) " +
                                                          "ON DELETE CASCADE",
                                                   "emp_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "employee(emp_id) " +
                                                          "ON DELETE CASCADE",
                                                   "payment_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "payment(payment_id) " +
                                                          "ON DELETE CASCADE",
                                                   "warranty_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "warranty(warranty_id) " +
                                                          "ON DELETE CASCADE",
                                                   "CONSTRAINT value_is_percentage " +
                                                          "CHECK ((" +
                                                          "(tax_rate > (1)::numeric) AND " +
                                                          "(tax_rate < (100)::numeric) ))"
                                             };
    
    public static String TABLE_NAME_WARRANTY = "warranty";
    public static String[] TABLE_ATTR_WARRANTY = {
                                                   "warranty_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "type character varying(70) " +
                                                          "NOT NULL",
                                                   "cost money " +
                                                          "NOT NULL",
                                                   "duration integer " +
                                                          "NOT NULL",
                                                   "miles integer " +
                                                          "NOT NULL"
                                             };
    public static Warranty[] WARRANTIES = { new Warranty("Standard", 0, 60, 5000),
                                            new Warranty("Extended", 100, 120, 10000),
                                            new Warranty("Limited", 0, 30, 2000)
                                          };

    public static String TABLE_NAME_CUSTOM_OPTIONS = "customization_options";
    public static String[] TABLE_ATTR_CUSTOM_OPTIONS = {
                                                   "custom_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "custom_name character varying(70) " +
                                                          "NOT NULL",
                                                   "cost integer " +
                                                          "NOT NULL"
                                             };
    public static String[] CUSTOM_OPTIONS = {
                                       "Sound System", "Paint Trim", "Alarm System",
                                       "Weather Coating"
                                      };

    public static String TABLE_NAME_HAS_CUSTOM = "has_customization";
    public static String[] TABLE_ATTR_HAS_CUSTOM = {
                                                   "custom_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "customization_options(custom_id) " +
                                                          "ON DELETE CASCADE",
                                                   "sale_id integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "sale(sale_id) " +
                                                          "ON DELETE CASCADE",
                                                   "PRIMARY KEY(custom_id, sale_id)"
                                             };
    public static int CAR_YEAR_START = 1997;
    public static int CAR_YEAR_END = 2017;
    public static void main(String args[]) {

        ArrayList<Table> tables = new ArrayList<Table>();
        
        tables.add(new Table(TABLE_NAME_CUSTOM_OPTIONS, TABLE_ATTR_CUSTOM_OPTIONS));
        tables.add(new Table(TABLE_NAME_FEATURES, TABLE_ATTR_FEATURES));
        tables.add(new Table(TABLE_NAME_CUSTOMER, TABLE_ATTR_CUSTOMER));
        tables.add(new Table(TABLE_NAME_EMPLOYEE, TABLE_ATTR_EMPLOYEE));
        tables.add(new Table(TABLE_NAME_TRADE_IN, TABLE_ATTR_TRADE_IN));
        tables.add(new Table(TABLE_NAME_FINANCING, TABLE_ATTR_FINANCING));
        tables.add(new Table(TABLE_NAME_PAYMENT, TABLE_ATTR_PAYMENT));
        tables.add(new Table(TABLE_NAME_CAR, TABLE_ATTR_CAR));
        tables.add(new Table(TABLE_NAME_WARRANTY, TABLE_ATTR_WARRANTY));
        tables.add(new Table(TABLE_NAME_SALE, TABLE_ATTR_SALE));
        tables.add(new Table(TABLE_NAME_HAS_FEATURES, TABLE_ATTR_HAS_FEATURES));
        tables.add(new Table(TABLE_NAME_HAS_CUSTOM, TABLE_ATTR_HAS_CUSTOM));

        for(int i = 0; i <= tables.size() - 1; i++) {
            if(tables.get(i) != null)
               createTable(tables.get(i));
        }

        //pulateSales();
        //populatePractice();
        
        populateFeatures();
        populateCustomOptions();
        populateWarranties();
        populateCustomers();
        populateEmployees();
        populateCars();
        /*populateCarFeatures();

        populateEmployees();

        populateWarrantys();

        populateCustomer();

        populateCustomOptions();

        populateSalesPaymentsAndCustoms();*/

    }

    public static void createTable(Table t) {
        System.out.printf("DROP TABLE IF EXISTS %s CASCADE; \n", t.name);
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
    public static void populateEmployees() {
        String prefix = "INSERT INTO employee (emp_name, commission) " +
                                              "VALUES (";
        String suffix = ");";
        
        for(int i = 0; i < EMPLOYEES.length; i++) {
            String val = "\'" + EMPLOYEES[i].name+ "\', " +
                         EMPLOYEES[i].commission;
            System.out.println(prefix + val + suffix);
        }
    }
    
    public static void populateCustomers() {
        String prefix = "INSERT INTO customer (name, ref_type, ref_origin) " +
                                              "VALUES (";
        String suffix = ");";
        
        for(int i = 0; i < CUSTOMERS.length; i++) {
            String val = "\'" + CUSTOMERS[i].name+ "\', \'" + CUSTOMERS[i].ref_type
                         + "\', \'" + CUSTOMERS[i].ref_origin + "\'";
            System.out.println(prefix + val + suffix);
        }
    }

    public static void populateWarranties() {
        String prefix = "INSERT INTO warranty (type, cost, " +
                                              "duration, miles) VALUES (";
        String suffix = ");";
        
        for(int i = 0; i < WARRANTIES.length; i++) {
            String val = "\'" + WARRANTIES[i].type+ "\', " + Integer.toString(WARRANTIES[i].cost)
                         + ", " + Integer.toString(WARRANTIES[i].length) + ", " +
                         Integer.toString(WARRANTIES[i].miles) + "";
            System.out.println(prefix + val + suffix);
        }
    }


    public static void populateFeatures() {
        String prefix = "INSERT INTO features (feat_id, feat_name) VALUES (";

        String suffix = ");";

        for(int i = 0; i < FEATURES.length; i++) {
            String val = Integer.toString(i) + ", \'" + FEATURES[i] + "\'";
            System.out.println(prefix + val + suffix);
        }
        
    }
    
    public static void populateCustomOptions() {
        String prefix = "INSERT INTO customization_options (custom_id, custom_name,"
                                                  + " cost) VALUES (";

        String suffix = ");";

        Random rn = new Random();

        for(int i = 0; i < FEATURES.length; i++) {
            int p = rn.nextInt(500) + 25;
            String val = Integer.toString(i) + ", \'" + FEATURES[i] + "\', "+
                         Integer.toString(p);
            System.out.println(prefix + val + suffix);
        }
        
    }

    public static void populateCars() {
        String prefix = "INSERT INTO car (vin, sticker_price, make, model, " +
                                          "year, color, is_new, is_sold, " +
                                          "min_price, mileage) VALUES (";

        String suffix = ");";

        String make = "Ford";
        String[] colors = {"red", "black", "silver", "white"};
        String[] models = {"mustang", "focus", "fusion", "taurus"};


        Random rn = new Random();
        for(int i = CAR_YEAR_START; i < CAR_YEAR_END; i++) {
            for(String s : models) {
                int vin = 100000 + rn.nextInt(900000);
                String color = colors[rn.nextInt(3)];
                String sPrice = Integer.toString(rn.nextInt(15000) + 5000);
                double mPrice = (rn.nextInt(50) * .01);
                String mileage = "0";
              
                String vals = Integer.toString(vin)+", "+sPrice+", \'"+
                              make+"\', \'"+s+"\', "+Integer.toString(i)+ ", \'"+color+
                              "\', true, false, " + Double.toString(mPrice).substring(0,3) +
                              ", "+mileage;

                System.out.println(prefix + vals + suffix);
            }
        } 
        

    }

    public static void populatePractice() {
        for(int i = 0; i < 100; i++) {

            System.out.printf("INSERT INTO practice (practice_int) VALUES (%d);", i);
            System.out.println();
        }
    }

    public static class Table {
    	public String name;
        public String[] attributes;

    	public Table(String name, String[] attributes) {
        	this.name = name;
	        this.attributes = attributes;
        }
    }

    public static class Warranty {
        public String type;
        public int cost;
        public int length;
        public int miles;

        public Warranty(String type, int cost, int length, int miles) {
            this.type = type;
            this.cost = cost;
            this.length = length;
            this.miles = miles;
        }
    }

    public static class Employee {
        public String name;
        public int commission;

        public Employee(String name, int commission) {
            this.name = name;
            this.commission = commission;
        }
     }

    public static class Customer {
        public String name;
        public String ref_type;
        public String ref_origin;

        public Customer(String name, String ref_type, String ref_origin) {
            this.name = name;
            this.ref_type = ref_type;
            this.ref_origin = ref_origin;
        }
     }
}
