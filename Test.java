import java.util.ArrayList; 
public class Test {
    private static String TABLE_NAME_PRACTICE = "practice";
    private static String[] TABLE_ATTR_PRACTICE = {
                                                   "practice_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "practice_int int " +
                                                          "NOT NULL"
                                                  };
    
    private static String TABLE_NAME_CAR = "car";
    private static String[] TABLE_ATTR_CAR = {
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
                                                   "is_new boolean " +
                                                          "NOT NULL",
                                                   "is_sold boolean " +
                                                          "NOT NULL",
                                                   "min_price money " +
                                                          "NOT NULL",
                                                   "mileage integer " +
                                                          "NOT NULL"
                                             };
    
    private static String TABLE_NAME_FEATURES = "features";
    private static String[] TABLE_ATTR_FEATURES = {
                                                   "feat_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "feat_name character varying(70) " +
                                                          "NOT NULL"
                                             };

    private static String TABLE_NAME_HAS_FEATURES = "has_features";
    private static String[] TABLE_ATTR_HAS_FEATURES = {
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

    private static String TABLE_NAME_CUSTOMER = "customer";
    private static String[] TABLE_ATTR_CUSTOMER = {
                                                   "cus_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "name character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_origin character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_type character varying(70) " +
                                                          "NOT NULL"
                                             };

    private static String TABLE_NAME_EMPLOYEE = "employee";
    private static String[] TABLE_ATTR_EMPLOYEE = {
                                                   "emp_id integer " +
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
 
    private static String TABLE_NAME_PAYMENT = "payment";
    private static String[] TABLE_ATTR_PAYMENT = {
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

    private static String TABLE_NAME_FINANCING = "financing";
    private static String[] TABLE_ATTR_FINANCING = {
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
    
    private static String TABLE_NAME_TRADE_IN = "trade_in";
    private static String[] TABLE_ATTR_TRADE_IN = {
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
        
    private static String TABLE_NAME_SALE = "sale";
    private static String[] TABLE_ATTR_SALE = {
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
    
    private static String TABLE_NAME_WARRANTY = "warranty";
    private static String[] TABLE_ATTR_WARRANTY = {
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

    private static String TABLE_NAME_CUSTOM_OPTIONS = "customization_options";
    private static String[] TABLE_ATTR_CUSTOM_OPTIONS = {
                                                   "custom_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "custom_name character varying(70) " +
                                                          "NOT NULL"
                                             };

    private static String TABLE_NAME_HAS_CUSTOM = "has_customization";
    private static String[] TABLE_ATTR_HAS_CUSTOM = {
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
        
        /*populateFeatures();
        populateCars();
        populateCarFeatures();

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
}
