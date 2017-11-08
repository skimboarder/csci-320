import java.util.Random;

public class CustomerHelper implements Helper{
    private static String TABLE_NAME_CUSTOMER = "customer";
    private static String[] TABLE_ATTR_CUSTOMER = {
                                                   "cus_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "name character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_type character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_origin character varying(70) " +
                                                          "NOT NULL"
                                             };
    private static Customer[] CUSTOMERS = { new Customer("Frank Murray", "none", "none"),
                                           new Customer("Jan Scott", "web", "facebook.com"),
                                           new Customer("Adrian Blake", "mouth", "Emma Peake"),
                                           new Customer("Emma Peake", "web", "cars.com"),
                                           new Customer("Adam Parr", "tv ad", "channel 3")
                                          };




    private static String[] REF_ORIGINS = { "web", "mouth", "tv ad" };
    private static String[] ORIGINS_WEB = { "facebook.com", "cars.com", "carfax.com" };
    private static String[] ORIGINS_TV = { "channel 3", "channel 4", "channel 6" };
    private static String[] ORIGINS_MOUTH = { "Emma Peake", "Adam Parr", "Jim Friendly" };

    private static String PREFIX = "INSERT INTO customer (name, ref_type, ref_origin) " +
                                              "VALUES (";
    private static String SUFFIX = ");";
    
    public CustomerHelper() {
    }

    public String getName() {
        return TABLE_NAME_CUSTOMER;
    }
    public String[] getAttributes() { 
        return TABLE_ATTR_CUSTOMER;
    }
    public static Customer[] getCustomers() {
        return CUSTOMERS;
    }
    public void populate() {
        
        for(int i = 0; i < CUSTOMERS.length; i++) {
            String val = "\'" + CUSTOMERS[i].name+ "\', \'" + CUSTOMERS[i].ref_type
                         + "\', \'" + CUSTOMERS[i].ref_origin + "\'";
            System.out.println(PREFIX + val + SUFFIX);
        }
    }
    public static int getRandomId(Random rn) {
        return rn.nextInt(CUSTOMERS.length - 1) + 1;
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
