import java.util.Random;

public class CustomOptionsHelper implements Helper{
    
    private static String TABLE_NAME_CUSTOM_OPTIONS = "customization_options";
    private static String[] TABLE_ATTR_CUSTOM_OPTIONS = {
                                                   "custom_id serial " +
                                                          "NOT NULL PRIMARY KEY",
                                                   "custom_name character varying(70) " +
                                                          "NOT NULL",
                                                   "cost money " +
                                                          "NOT NULL CHECK(cost >= (0)::money)"
                                             };
    private static String[] CUSTOM_OPTIONS = {
                                       "Sound System", "Paint Trim", "Alarm System",
                                       "Weather Coating"
                                      };

    private static String PREFIX = "INSERT INTO customization_options (custom_name,"
                                                  + " cost) VALUES (";
 
    private static String SUFFIX = ");";


    public CustomOptionsHelper() {
    }

    public String getName() {
        return TABLE_NAME_CUSTOM_OPTIONS;
    }

    public String[] getAttributes() {
        return TABLE_ATTR_CUSTOM_OPTIONS;
    }

    public static String[] getOptions() {
        return CUSTOM_OPTIONS;
    }

    public void populate() {
        Random rn = new Random();

        for(int i = 0; i < CUSTOM_OPTIONS.length; i++) {
            int p = rn.nextInt(500) + 25;
            String val = "\'" + CUSTOM_OPTIONS[i] + "\', "+
                         Integer.toString(p);
            System.out.println(PREFIX + val + SUFFIX);
        }
        
    }


}
