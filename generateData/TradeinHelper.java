public class TradeinHelper implements Helper{

    public static String TABLE_NAME_TRADE_IN = "trade_in";
    public static String[] TABLE_ATTR_TRADE_IN = {
                                                   "trade_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "vin integer " +
                                                          "NOT NULL " +
                                                          "REFERENCES " +
                                                          "car(vin)", 
                                                   "mileage integer " +
                                                          "NOT NULL CHECK(mileage >= 0)",
                                                   "condition character varying(250) " +
                                                          "NOT NULL",
                                                   "value money " +
                                                          "NOT NULL CHECK(value >= (0)::money)"
                                             };
    public static Tradein[] TRADEINS = { new Tradein(222222, 25000, "good", 5000),
                                         new Tradein(333333, 50000, "good", 5000),
                                         new Tradein(555555, 5000, "excellent", 6000),
                                         new Tradein(121212, 10000, "fair", 5000)

                                       };
    private static String PREFIX = "INSERT INTO trade_in (vin, mileage, condition, value) " +
                                              "VALUES (";
    private static String SUFFIX = ");";

    public TradeinHelper() {
    }

    public String getName() {
        return TABLE_NAME_TRADE_IN;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_TRADE_IN;
    }

    public void populate() {
        for(Tradein t : TRADEINS) {
            String vals = t.vin + ", " + t.miles + ", \'"+t.condition+"\', " +
                          t.value;
            System.out.println(PREFIX + vals + SUFFIX);
        }
        
    }
    
    public static class Tradein{
        public int vin;
        public int miles;
        public String condition;
        public int value;

        public Tradein(int vin, int miles, String cond, int val) {
            this.vin = vin;
            this.miles = miles;
            this.condition = cond;
            this.value = val;
        }
     }


}
