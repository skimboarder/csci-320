import java.util.ArrayList;

public class TableHelper {

    private static ArrayList<Helper> helpers;
    public static EmployeeHelper employee;
    public static CustomOptionsHelper custOpts;
    public static HasCustomOptionsHelper hasCustom;
    public static CarHelper car;
    public static FeaturesHelper features;
    public static HasFeaturesHelper hasFeatures;
    public static CustomerHelper cust;
    public static PaymentHelper payment;
    public static FinancingHelper financing;
    public static TradeinHelper tradein;
    public static WarrantyHelper warranty;
    public static SaleHelper sale;
 

    public TableHelper(ArrayList<Helper> helpers, HasFeaturesHelper hasFeatures,SaleHelper sale,
                       CarHelper car, FeaturesHelper features, TradeinHelper tradein,
                       CustomOptionsHelper custOpts, HasCustomOptionsHelper hasCustom, 
                       FinancingHelper financing, PaymentHelper payment,
                       EmployeeHelper employee, CustomerHelper cust) {
        this.helpers = helpers;

        this.hasFeatures = hasFeatures;
        this.sale = sale;
        this.car = car;
        this.features = features;
        this.tradein = tradein;
        this.custOpts = custOpts;
        this.hasCustom = hasCustom;
        this.financing = financing;
        this.payment = payment;
        this.employee = employee;
        this.cust = cust;
    }
    
    public static void populateTables() {
        
        for(Helper h : helpers) {
            h.populate();
        }

        hasFeatures.giveCarsFeatures(car.getVins(), features.getFeatures());
        sale.populateSales(tradein, custOpts, hasCustom, financing, payment,car, employee, cust);
       
 
    }
    public static void createTables() {
        ArrayList<Table> tables = new ArrayList<Table>();
        for(Helper h : helpers) {
            tables.add(new Table(h.getName(), h.getAttributes()));
        }

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
    
    public static class Table {
    	public String name;
        public String[] attributes;

    	public Table(String name, String[] attributes) {
        	this.name = name;
	        this.attributes = attributes;
        }
    }

}
