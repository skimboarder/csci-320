import java.util.Random;
import java.util.ArrayList;

public class HasFeaturesHelper implements Helper{
    private static String PREFIX = "INSERT INTO has_features (vin, feat_id) " +
                                              "VALUES (";

    private static String SUFFIX = ");";

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
    public HasFeaturesHelper() {
    }

    public String getName() {
        return TABLE_NAME_HAS_FEATURES;
    }
    public String[] getAttributes() {
        return TABLE_ATTR_HAS_FEATURES;
    }
    public void populate() {}    
    public void giveCarsFeatures(ArrayList<Integer> vins, String[] features) {

        Random rn = new Random();
         
        for(int i = 0; i < vins.size() - 1; i++) {
            for(int j = 0; j < features.length - 1; j++) {
                String val = "";
                if(rn.nextBoolean()) {
                    val += Integer.toString(vins.get(i)) + ", " + j;
                }
                if(!val.equals(""))
                    System.out.println(PREFIX + val + SUFFIX);
            }
        }
    }

}
