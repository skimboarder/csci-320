public final class Constants {

    public Constants() { }

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
                                                   "ref_origin character varying(70) " +
                                                          "NOT NULL",
                                                   "ref_type character varying(70) " +
                                                          "NOT NULL"
                                             };

    public static String TABLE_NAME_EMPLOYEE = "employee";
    public static String[] TABLE_ATTR_EMPLOYEE = {
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

    public static String TABLE_NAME_CUSTOM_OPTIONS = "customization_options";
    public static String[] TABLE_ATTR_CUSTOM_OPTIONS = {
                                                   "custom_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "custom_name character varying(70) " +
                                                          "NOT NULL"
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



}
