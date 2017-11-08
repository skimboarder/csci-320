public class ViewHelper {
    private static String[] VIEWS = { "CREATE VIEW all_new_cars_with_ac_and_heated_seats AS "+
                                     " SELECT * FROM car WHERE car.vin in ( " +
                                     " SELECT car.vin FROM car, has_features, features " +
                                     " WHERE is_new = TRUE AND is_sold = FALSE AND " +
                                     " has_features.vin = car.vin AND " +
                                     " features.feat_id = has_features.feat_id AND " +
                                     " features.feat_name in ('Heated Seats','AC') " +
                                     " GROUP BY car.vin HAVING count(*) = 2);"
                                   };

    public ViewHelper() {
    }

    public static void createViews() {
         for(String s : VIEWS) {
             System.out.println(s);
         }
    }
    

}
