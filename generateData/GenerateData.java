import java.util.ArrayList; 
import java.util.Random;

public class GenerateData {

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
                                                          "NOT NULL CHECK(sticker_price > (0)::money)",
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
                                                   "min_price numeric(5,2) " +
                                                          "NOT NULL CHECK(min_price >= (0)::numeric)",
                                                   "mileage integer " +
                                                          "NOT NULL"
                                             };
    
    public static Car[] CARS = { new Car(555555, 10000, "ford", "fusion", 2010, "silver", true, false, 70, 0),
                                 new Car(666666, 15000, "ford", "focus", 2012, "black", true, false, 50, 0),
                                 new Car(777777, 9000, "ford", "mustang", 2003, "white", true, false, 90, 0),
                                 new Car(111111, 5000, "ford", "bronco", 1977, "silver", true, false, 70, 0),
                                 new Car(222222, 20000, "ford", "taurus", 2013, "black", true, false, 50, 0),
                                 new Car(333333, 18000, "ford", "fiesta", 2003, "white", true, false, 90, 0),
                                 new Car(444444, 18000, "ford", "mustang", 2011, "silver", true, false, 80, 0),
                                 new Car(121212, 15000, "ford", "focus", 2013, "black", true, false, 50, 0),
                                 new Car(232323, 8000, "ford", "mustang", 2004, "white", true, false, 80, 0),
                                 new Car(343434, 12000, "ford", "fusion", 2005, "silver", true, false, 70, 0),
                                 new Car(454545, 13000, "ford", "focus", 2016, "black", true, false, 50, 0),
                                 new Car(565656, 9500, "ford", "escape", 2000, "white", true, false, 70, 0),
                                 new Car(676767, 12000, "ford", "explorer", 2010, "silver", true, false, 70, 0),
                                 new Car(787878, 13000, "ford", "explorer", 2016, "black", true, false, 50, 0),
                                 new Car(898989, 1000, "ford", "escape", 2001, "white", true, false, 60, 0)

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


    public static String TABLE_NAME_PAYMENT = "payment";
    public static String[] TABLE_ATTR_PAYMENT = {
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
    
    public static Payment[] PAYMENTS = { new Payment(10000),
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

    public static String TABLE_NAME_EMPLOYEE = "employee";
    public static String[] TABLE_ATTR_EMPLOYEE = {
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
    public static Employee[] EMPLOYEES = { new Employee("Jim Friendly", 30, "Manager"),
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
 

    public static String TABLE_NAME_FINANCING = "financing";
    public static String[] TABLE_ATTR_FINANCING = {
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
    public static Finance[] FINANCING = { new Finance(15000, "bank", "bank of america", "123 Fake St."),
                                           new Finance(4000, "dealership", "friendly", "543 False Ave."),
                                           new Finance(20000, "dealership", "friendly", "543 False Ave."),
                                           new Finance(11000, "bank", "citi bank", "822 Fiction Ct."),
                                           new Finance(15000, "bank", "citi bank", "822 Fiction Ct."),
                                           new Finance(6000, "bank", "bank of america", "123 Fake St."),
                                           new Finance(13000, "manufacture", "ford", "235 Merry Ave."),
                                           new Finance(4500, "manufacture", "ford", "235 Merry Ave."),
                                           new Finance(8000, "dealership", "friendly", "543 False Ave.")

                                          };
    
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
        
    public static String TABLE_NAME_SALE = "sale";
    public static String[] TABLE_ATTR_SALE = {
                                                   "sale_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "is_approved boolean " +
                                                          "NOT NULL",
                                                   "price money " +
                                                          "NOT NULL CHECK (price > (0)::money)",
                                                   "date date " +
                                                          "NOT NULL CHECK (date < CURRENT_DATE)",
                                                   "emp_requested boolean " +
                                                          "NOT NULL",
                                                   "tax_rate numeric(5,2) " +
                                                          "NOT NULL",
                                                   "license_fee money " +
                                                          "NOT NULL CHECK(license_fee >= (0)::money)",
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
                                                          "NOT NULL UNIQUE " +
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
                                                          "(tax_rate >= (0)::numeric) AND " +
                                                          "(tax_rate < (100)::numeric) ))"
                                             };
    
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

    public static String TABLE_NAME_CUSTOM_OPTIONS = "customization_options";
    public static String[] TABLE_ATTR_CUSTOM_OPTIONS = {
                                                   "custom_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "custom_name character varying(70) " +
                                                          "NOT NULL",
                                                   "cost money " +
                                                          "NOT NULL CHECK(cost >= (0)::money)"
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

    public static String[] VIEWS = { "CREATE VIEW all_new_cars_with_ac_and_heated_seats AS "+
                                     " SELECT * FROM car WHERE car.vin in ( " +
                                     " SELECT car.vin FROM car, has_features, features " +
                                     " WHERE is_new = TRUE AND is_sold = FALSE AND " +
                                     " has_features.vin = car.vin AND " +
                                     " features.feat_id = has_features.feat_id AND " +
                                     " features.feat_name in ('Heated Seats','AC') " +
                                     " GROUP BY car.vin HAVING count(*) = 2);"
                                   };
    public static String[] TRIGGER_FUNCTIONS = { "create or replace function trade_in_vin_new_or_not() returns trigger as $BODY$ begin if(new.vin = (select vin from car where new.vin = vin)) then update car set is_sold = false, is_new = false, mileage = new.mileage where vin = new.vin; else insert into car(vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) values (NEW.vin, 5000, 'Toyota', 'Camry', 1997, 'Grey', false, false, 10, new.mileage); end if; return new; end $BODY$ language plpgsql;",
"create or replace function update_car_on_sale() returns trigger as $BODY$ begin if(new.vin = (select vin from car where new.vin = vin)) then update car set is_sold = true where vin = new.vin; end if; return new; end $BODY$ language plpgsql;"
                                               };

    public static String[] TRIGGERS = { "CREATE TRIGGER update_vin_on_trade_in AFTER INSERT ON trade_in FOR EACH ROW EXECUTE PROCEDURE trade_in_vin_new_or_not();",
                                        "CREATE TRIGGER on_car_sale AFTER INSERT ON sale FOR EACH ROW EXECUTE PROCEDURE update_car_on_sale();"

    };

    public static String[] STORED_PROCS = { "create or replace function calculate_profits(id int) returns money as $$ BEGIN return (SELEct sum(PRICE) FROM SALE WHERE EMP_ID = ID) * (SElect commission from employee where emp_id = id) / 100; END; $$ language plpgsql;" };

    public static int CAR_YEAR_START = 1997;
    public static int CAR_YEAR_END = 2017;
  

    public static ArrayList<Integer> CAR_VINS = new ArrayList<Integer>();
 
    public static void main(String args[]) {

        createTables();

        populateTables();
        
    }

    public static void createTables() {
        ArrayList<Table> tables = new ArrayList<Table>();
        
        tables.add(new Table(TABLE_NAME_CUSTOM_OPTIONS, TABLE_ATTR_CUSTOM_OPTIONS));
        tables.add(new Table(TABLE_NAME_FEATURES, TABLE_ATTR_FEATURES));
        tables.add(new Table(TABLE_NAME_CUSTOMER, TABLE_ATTR_CUSTOMER));
        tables.add(new Table(TABLE_NAME_EMPLOYEE, TABLE_ATTR_EMPLOYEE));
        tables.add(new Table(TABLE_NAME_CAR, TABLE_ATTR_CAR));
        tables.add(new Table(TABLE_NAME_TRADE_IN, TABLE_ATTR_TRADE_IN));
        tables.add(new Table(TABLE_NAME_FINANCING, TABLE_ATTR_FINANCING));
        tables.add(new Table(TABLE_NAME_PAYMENT, TABLE_ATTR_PAYMENT));
        tables.add(new Table(TABLE_NAME_WARRANTY, TABLE_ATTR_WARRANTY));
        tables.add(new Table(TABLE_NAME_SALE, TABLE_ATTR_SALE));
        tables.add(new Table(TABLE_NAME_HAS_FEATURES, TABLE_ATTR_HAS_FEATURES));
        tables.add(new Table(TABLE_NAME_HAS_CUSTOM, TABLE_ATTR_HAS_CUSTOM));

        for(int i = 0; i <= tables.size() - 1; i++) {
            if(tables.get(i) != null)
               createTable(tables.get(i));
        }

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

    public static void populateTables() {
        createViews();
        createTriggerFunctions();
        createTriggers();
        populateFeatures();
        populateCustomOptions();
        populateWarranties();
        populateCustomers();
        populateEmployees();
        populateCars();
        populateSalesPaymentsAndCustoms();
        giveCarsFeatures();
        createStoredProcs();
    }
    
    public static void createStoredProcs() {
         for(String s : STORED_PROCS) {
             System.out.println(s);
         }
    }

    public static void createTriggerFunctions() {
         for(String s : TRIGGER_FUNCTIONS) {
             System.out.println(s);
         }
    }

    public static void createTriggers() {
         for(String s : TRIGGERS) {
             System.out.println(s);
         }
    }
   

    public static void createViews() {
         for(String s : VIEWS) {
             System.out.println(s);
         }
    }

    public static void giveCarsFeatures() {
        String prefix = "INSERT INTO has_features (vin, feat_id) " +
                                              "VALUES (";

        String suffix = ");";

        Random rn = new Random();

        for(int i = 0; i < CAR_VINS.size() - 1; i++) {
            for(int j = 0; j < FEATURES.length - 1; j++) {
                String val = "";
                if(rn.nextBoolean()) {
                    val += Integer.toString(CAR_VINS.get(i)) + ", " + j;
                }
                if(!val.equals(""))
                    System.out.println(prefix + val + suffix);
            }
        }


    }

    public static void populateSalesPaymentsAndCustoms() {
        String prefix = "INSERT INTO sale (is_approved, price, date, " +
                                           "emp_requested, tax_rate, " +
                                           "license_fee, cus_id, vin, " +
                                           "emp_id, payment_id, warranty_id" +
                                              ") VALUES (";

        String suffix = ");";

        String customPrefix = "INSERT INTO has_customization (sale_id, custom_id) " +
                              "VALUES (";

        populateTradeins();
        populateFinances();
        populatePayments();
        Random rn = new Random();
        double tax_rate = .05;
        String date = "01/01/2017";

        for(int i = 0; i < CARS.length; i++) {
            int vin = CARS[i].vin;
            int cus_id = rn.nextInt(CUSTOMERS.length - 1) + 1;
            int emp_id = rn.nextInt(EMPLOYEES.length - 1) + 1;
            int payment_id = i+1;
            int warranty_id = rn.nextInt(2) + 1;
            boolean emp_requested = rn.nextBoolean();
            boolean is_approved = false;
            int price = CARS[i].sticker_price;
            int license_fee = rn.nextInt(250) + 25;

            String vals = is_approved + ", " + Integer.toString(price) + ", \'" +
                          date + "\', " + emp_requested + ", "+ Double.toString(tax_rate) +
                          ", " + Integer.toString(license_fee) + ", " + Integer.toString(cus_id) + 
                          ", " + Integer.toString(vin) + ", " + Integer.toString(emp_id) + 
                          ", " + Integer.toString(payment_id) + ", " + Integer.toString(warranty_id);

            System.out.println(prefix + vals + suffix);
            for(int j = 0; j < CUSTOM_OPTIONS.length; j++) {
                if(rn.nextBoolean())
                    System.out.println(customPrefix + Integer.toString(i+1) + ", " + Integer.toString(j+1) + ");");
            }

        }

    }

    public static void populatePayments() {
        String prefix = "INSERT INTO payment (amount, trade_id, fin_id) " +
                                              "VALUES (";

        String suffix = ");";
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
            System.out.println(prefix + vals + suffix);
        }

    }

    public static void populateTradeins() {
        String prefix = "INSERT INTO trade_in (vin, mileage, condition, value) " +
                                              "VALUES (";
        String suffix = ");";
        for(Tradein t : TRADEINS) {
            String vals = t.vin + ", " + t.miles + ", \'"+t.condition+"\', " +
                          t.value;
            System.out.println(prefix + vals + suffix);
        }
        
    }
    public static void populateFinances() {
        String prefix = "INSERT INTO financing (amount, type, name, addr) " +
                                              "VALUES (";
        String suffix = ");";
        for(Finance f : FINANCING) {
            String vals = f.amount + ", \'" + f.type + "\', \'"+f.name+"\', \'" +
                          f.addr + "\'";
            System.out.println(prefix + vals + suffix);
        }
        
    }

    public static void populateEmployees() {
        String prefix = "INSERT INTO employee (emp_name, commission, role) " +
                                              "VALUES (";
        String suffix = ");";
        
        for(int i = 0; i < EMPLOYEES.length; i++) {
            String val = "\'" + EMPLOYEES[i].name+ "\', " +
                         EMPLOYEES[i].commission+", \'"+EMPLOYEES[i].role+"\'";
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
        String prefix = "INSERT INTO customization_options (custom_name,"
                                                  + " cost) VALUES (";

        String suffix = ");";

        Random rn = new Random();

        for(int i = 0; i < CUSTOM_OPTIONS.length; i++) {
            int p = rn.nextInt(500) + 25;
            String val = "\' " + CUSTOM_OPTIONS[i] + "\', "+
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

        for(Car c : CARS) {
            String vals = Integer.toString(c.vin)+", "+c.sticker_price+", \'"+
                               c.make+"\', \'"+c.model+"\', "+Integer.toString(c.year) +
                               ", \'"+c.color+"\', "+c.is_new+", "+c.is_sold+", "+c.min_price +
                               ", "+c.mileage;
            System.out.println(prefix + vals + suffix);
        }

        Random rn = new Random();
        for(int i = CAR_YEAR_START; i < CAR_YEAR_END; i++) {
            for(String s : models) {
                int vin = 100000 + rn.nextInt(900000);
                CAR_VINS.add(vin);
                String color = colors[rn.nextInt(3)];
                String sPrice = Integer.toString(rn.nextInt(15000) + 5000);
                double mPrice = rn.nextInt(50);
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
        public String role;
        public Employee(String name, int commission, String role) {
            this.name = name;
            this.commission = commission;
            this.role = role;
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
    public static class Car {
        public int vin;
        public int sticker_price;
        public String make;
        public String model;
        public int year;
        public String color;
        public boolean is_new;
        public boolean is_sold;
        public double min_price;
        public int mileage;

        public Car(int vin, int s_price, String make, String model, int year,
                        String color, boolean is_new, boolean is_sold, double min_price, int mileage) {
            this.vin = vin;
            this.sticker_price = s_price;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.is_new = is_new;
            this.is_sold = is_sold;
            this.min_price = min_price;
            this.mileage = mileage;
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
