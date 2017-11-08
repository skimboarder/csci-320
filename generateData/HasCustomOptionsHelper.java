import java.util.Random;

public class HasCustomOptionsHelper implements Helper{

    private static GenerateData main;

    private static String TABLE_NAME_HAS_CUSTOM = "has_customization";
    private static String[] TABLE_ATTR_HAS_CUSTOM = {
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
    private static String PREFIX = "INSERT INTO has_customization (sale_id, custom_id) " +
                              "VALUES (";
    private static String SUFFIX = ");";

    public HasCustomOptionsHelper() {
    }

    public String getName() {
        return TABLE_NAME_HAS_CUSTOM;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_HAS_CUSTOM;
    }
    //public void populate() {}
    public void populate() {}    
    public void addCustomOptions(int i, Random rn, int length) {
        for(int j = 0; j < length; j++) {
            if(rn.nextBoolean())
                System.out.println(PREFIX + Integer.toString(i+1) + 
                                   ", " + Integer.toString(j+1) + 
                                   SUFFIX);
        }
    }


}
