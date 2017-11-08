public class FeaturesHelper implements Helper{
    
    private static String TABLE_NAME_FEATURES = "features";
    private static String[] TABLE_ATTR_FEATURES = {
                                                   "feat_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "feat_name character varying(70) " +
                                                          "NOT NULL"
                                             };
    private static String[] FEATURES = {
                                       "AC", "Heated Seats", "Power Windows",
                                       "Sunroof", "Leather Seats", "Sirius XM Radio"
                                      };
        
    private static String PREFIX = "INSERT INTO features (feat_id, feat_name) VALUES (";

    private static String SUFFIX = ");";

    public FeaturesHelper() {
    }

    public String getName() {
        return TABLE_NAME_FEATURES;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_FEATURES;
    }
    public static String[] getFeatures() {
        return FEATURES;
    }
    public void populate() {

        for(int i = 0; i < FEATURES.length; i++) {
            String val = Integer.toString(i) + ", \'" + FEATURES[i] + "\'";
            System.out.println(PREFIX + val + SUFFIX);
        }
        
    }


}
