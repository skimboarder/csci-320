import java.util.Random;

public class SaleHelper implements Helper{
    private static String TABLE_NAME_SALE = "sale";
    private static String[] TABLE_ATTR_SALE = {
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
    private static String PREFIX = "INSERT INTO sale (is_approved, price, date, " +
                                           "emp_requested, tax_rate, " +
                                           "license_fee, cus_id, vin, " +
                                           "emp_id, payment_id, warranty_id" +
                                              ") VALUES (";

    private static String SUFFIX = ");";

    public SaleHelper() {
    }
    public String getName() {
        return TABLE_NAME_SALE;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_SALE;
    }
    public void populate() {}
    public void populateSales(TradeinHelper tradein, CustomOptionsHelper custOpts, HasCustomOptionsHelper hasCustom,
                                   FinancingHelper financing, PaymentHelper payment,
                                   CarHelper car, EmployeeHelper employee, CustomerHelper cust) {


        Random rn = new Random();
        double tax_rate = .05;
        String date = "01/01/2017";
        CarHelper.Car[] cars = car.getCars();
        for(int i = 0; i < cars.length; i++) {
            int vin = cars[i].vin;
            int cus_id = cust.getRandomId(rn);
            int emp_id = employee.getRandomId(rn);            
            int payment_id = i+1;
            int warranty_id = rn.nextInt(2) + 1;
            boolean emp_requested = rn.nextBoolean();
            boolean is_approved = false;
            int price = cars[i].sticker_price;
            int license_fee = rn.nextInt(250) + 25;

            String vals = is_approved + ", " + Integer.toString(price) + ", \'" +
                          date + "\', " + emp_requested + ", "+ Double.toString(tax_rate) +
                          ", " + Integer.toString(license_fee) + ", " + Integer.toString(cus_id) + 
                          ", " + Integer.toString(vin) + ", " + Integer.toString(emp_id) + 
                          ", " + Integer.toString(payment_id) + ", " + Integer.toString(warranty_id);

            System.out.println(PREFIX + vals + SUFFIX);
            hasCustom.addCustomOptions(i, rn, custOpts.getOptions().length);
           

        }

    }



}
