import java.util.Random;
import java.util.ArrayList;

public class CarHelper implements Helper{

    private static String TABLE_NAME_CAR = "car";
    private static String[] TABLE_ATTR_CAR = {
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

    public static String PREFIX = "INSERT INTO car (vin, sticker_price, make, model, " +
                                          "year, color, is_new, is_sold, " +
                                          "min_price, mileage) VALUES (";
    public static String SUFFIX = ");";
    
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
    public static ArrayList<Integer> CAR_VINS = new ArrayList<Integer>();


    private static int CAR_YEAR_START  = 1997;
    private static int CAR_YEAR_END = 2017;

    public CarHelper() {

    }
   
    public String getName() {
        return TABLE_NAME_CAR;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_CAR; 
    }
    public static Car[] getCars() {
        return CARS;
    }
    public void populate() {
        String make = "Ford";
        String[] colors = {"red", "black", "silver", "white"};
        String[] models = {"mustang", "focus", "fusion", "taurus"};

        for(Car c : CARS) {
            String vals = Integer.toString(c.vin)+", "+c.sticker_price+", \'"+
                               c.make+"\', \'"+c.model+"\', "+Integer.toString(c.year) +
                               ", \'"+c.color+"\', "+c.is_new+", "+c.is_sold+", "+c.min_price +
                               ", "+c.mileage;
            System.out.println(PREFIX + vals + SUFFIX);
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

                System.out.println(PREFIX + vals + SUFFIX);
            }
        } 
        

    }

    public static ArrayList<Integer> getVins() {
        return CAR_VINS;
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

}
