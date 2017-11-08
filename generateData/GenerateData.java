import java.util.ArrayList; 
import java.util.Random;

public class GenerateData {

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
    public static ViewHelper views;
    public static StoredProcHelper sProcs;
    public static TriggersHelper trigs;
    public static TableHelper table;

    public static ArrayList<Helper> helpers;
 
    public static void main(String args[]) {
        initHelpers();

        // Create the tables
        table.createTables();

        // Create the Triggers and their Functions
        trigs.createTriggerFunctions();
        trigs.createTriggers();

        // Create the Views
        views.createViews();

        // Fill Tables with data
        table.populateTables();

        // Create the Stored Procedures
        sProcs.createStoredProcs(); 
    }

    public static void initHelpers() {
        helpers = new ArrayList<Helper>();

        employee = new EmployeeHelper();
        helpers.add(employee); 

        custOpts = new CustomOptionsHelper();
        helpers.add(custOpts);

        hasCustom = new HasCustomOptionsHelper();
        helpers.add(hasCustom);

        car = new CarHelper();
        helpers.add(car);

        features = new FeaturesHelper();
        helpers.add(features);

        hasFeatures = new HasFeaturesHelper();
        helpers.add(hasFeatures);

        cust = new CustomerHelper();
        helpers.add(cust);

        payment = new PaymentHelper();
        helpers.add(payment);

        financing = new FinancingHelper();
        helpers.add(financing);

        tradein = new TradeinHelper();
        helpers.add(tradein);

        warranty = new WarrantyHelper();
        helpers.add(warranty);

        sale = new SaleHelper();
        helpers.add(sale);

        views = new ViewHelper();

        trigs = new TriggersHelper();

        sProcs = new StoredProcHelper();

        table = new TableHelper(helpers, hasFeatures, sale, car, features, tradein, custOpts, hasCustom, financing, payment, employee, cust);

    }
}
