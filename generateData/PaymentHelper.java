public class PaymentHelper implements Helper{
    
    private static String TABLE_NAME_PAYMENT = "payment";
    private static String[] TABLE_ATTR_PAYMENT = {
                                                   "payment_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "amount money " +
                                                          "NOT NULL CHECK(amount >= (0)::money)",
                                                   "trade_id integer " +
                                                          "UNIQUE REFERENCES " +
                                                          "trade_in(trade_id) " +
                                                          "ON DELETE CASCADE",
                                                   "fin_id integer " +
                                                          "UNIQUE REFERENCES " +
                                                          "financing(fin_id) " +
                                                          "ON DELETE CASCADE"
                                             };
    
    private static Payment[] PAYMENTS = { new Payment(10000),
                                           new Payment(15000, 1),
                                           new Payment(9000, 1, 2),
                                           new Payment(5000),
                                           new Payment(20000, 3),
                                           new Payment(18000, 2, 4),
                                           new Payment(18000),
                                           new Payment(15000, 5),
                                           new Payment(8000),
                                           new Payment(12000, 3, 6),
                                           new Payment(13000, 7),
                                           new Payment(9500, 4, 8),
                                           new Payment(12000),
                                           new Payment(13000, 9),
                                           new Payment(1000)
                                        };
    private static String PREFIX = "INSERT INTO payment (amount, trade_id, fin_id) " +
                                              "VALUES (";


    private static String SUFFIX = ");";

    public PaymentHelper() {
    }

    public String getName() {
        return TABLE_NAME_PAYMENT;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_PAYMENT;
    }
    
    public void populate() {
        for(Payment p : PAYMENTS) {
            String vals = "";
            if(p.trade_id == -1 && p.fin_id == -1) {
                vals += Integer.toString(p.amount) + ", null, null";
            }
            else if(p.trade_id == -1) {
                vals += Integer.toString(p.amount) + ", null, "+ Integer.toString(p.fin_id);
            }
            else if(p.fin_id == -1) {
                vals += Integer.toString(p.amount) + ", " + Integer.toString(p.trade_id) + ", null";
            } else {
                vals += Integer.toString(p.amount) + ", " + Integer.toString(p.trade_id) + ", " + Integer.toString(p.fin_id);
            }
            System.out.println(PREFIX + vals + SUFFIX);
        }

    }
    public static class Payment {
        public int amount;
        public int trade_id;
        public int fin_id;

        public Payment(int amount, int trade_id, int fin_id) {
            this.amount = amount;
            this.trade_id = trade_id;
            this.fin_id = fin_id;
        }
        public Payment(int amount, int fin_id) {
            this.amount = amount;
            this.fin_id = fin_id;
            this.trade_id = -1;
        }
        public Payment(int amount) {
            this.amount = amount;
            this.fin_id = -1;
            this.trade_id = -1;
        }
     }

}
