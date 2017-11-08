public class WarrantyHelper implements Helper{
    
    public static String TABLE_NAME_WARRANTY = "warranty";
    public static String[] TABLE_ATTR_WARRANTY = {
                                                   "warranty_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "type character varying(70) " +
                                                          "NOT NULL",
                                                   "cost money " +
                                                          "NOT NULL CHECK(cost >= (0)::money)",
                                                   "duration integer " +
                                                          "NOT NULL CHECK(duration > 0)",
                                                   "miles integer " +
                                                          "NOT NULL CHECK(miles >= 0)"
                                             };
    public static Warranty[] WARRANTIES = { new Warranty("Standard", 0, 60, 5000),
                                            new Warranty("Extended", 100, 120, 10000),
                                            new Warranty("Limited", 0, 30, 2000)
                                          };
    private static String PREFIX = "INSERT INTO warranty (type, cost, " +
                                              "duration, miles) VALUES (";
    private static String SUFFIX = ");";
    
    public WarrantyHelper() {
    }

    public String getName() {
        return TABLE_NAME_WARRANTY;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_WARRANTY;
    }
    public void populate() {
        
        for(int i = 0; i < WARRANTIES.length; i++) {
            String val = "\'" + WARRANTIES[i].type+ "\', " + Integer.toString(WARRANTIES[i].cost)
                         + ", " + Integer.toString(WARRANTIES[i].length) + ", " +
                         Integer.toString(WARRANTIES[i].miles) + "";
            System.out.println(PREFIX + val + SUFFIX);
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

}
