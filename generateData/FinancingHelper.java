public class FinancingHelper implements Helper{

    private static String TABLE_NAME_FINANCING = "financing";
    private static String[] TABLE_ATTR_FINANCING = {
                                                   "fin_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "amount money " +
                                                          "NOT NULL CHECK(amount >= (0)::money)",
                                                   "type character varying(250) " +
                                                          "NOT NULL",
                                                   "name character varying(70) " +
                                                          "NOT NULL",
                                                   "addr character varying(100) " +
                                                          "NOT NULL"
                                             };
    private static Finance[] FINANCING = { new Finance(15000, "bank", "bank of america", "123 Fake St."),
                                           new Finance(4000, "dealership", "friendly", "543 False Ave."),
                                           new Finance(20000, "dealership", "friendly", "543 False Ave."),
                                           new Finance(11000, "bank", "citi bank", "822 Fiction Ct."),
                                           new Finance(15000, "bank", "citi bank", "822 Fiction Ct."),
                                           new Finance(6000, "bank", "bank of america", "123 Fake St."),
                                           new Finance(13000, "manufacture", "ford", "235 Merry Ave."),
                                           new Finance(4500, "manufacture", "ford", "235 Merry Ave."),
                                           new Finance(8000, "dealership", "friendly", "543 False Ave.")

                                          };
    private static String PREFIX = "INSERT INTO financing (amount, type, name, addr) " +
                                              "VALUES (";
    private static String SUFFIX = ");";
    
    public FinancingHelper() {
    }

    public String getName() {
        return TABLE_NAME_FINANCING;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_FINANCING;
    }
    public void populate() {
        for(Finance f : FINANCING) {
            String vals = f.amount + ", \'" + f.type + "\', \'"+f.name+"\', \'" +
                          f.addr + "\'";
            System.out.println(PREFIX + vals + SUFFIX);
        }
        
    }
    public static class Finance {
        public int amount;
        public String type;
        public String name;
        public String addr;

        public Finance(int amount, String type, String name, String addr) {
            this.amount = amount;
            this.type = type;
            this.name = name;
            this.addr = addr;
        }
     }

}
