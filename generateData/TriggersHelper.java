public class TriggersHelper {
    private static String[] TRIGGER_FUNCTIONS = { "create or replace function trade_in_vin_new_or_not() returns trigger as $BODY$ begin if(new.vin = (select vin from car where new.vin = vin)) then update car set is_sold = false, is_new = false, mileage = new.mileage where vin = new.vin; else insert into car(vin, sticker_price, make, model, year, color, is_new, is_sold, min_price, mileage) values (NEW.vin, 5000, 'Toyota', 'Camry', 1997, 'Grey', false, false, 10, new.mileage); end if; return new; end $BODY$ language plpgsql;",
"create or replace function update_car_on_sale() returns trigger as $BODY$ begin if(new.vin = (select vin from car where new.vin = vin)) then update car set is_sold = true where vin = new.vin; end if; return new; end $BODY$ language plpgsql;"
                                               };

    private static String[] TRIGGERS = { "CREATE TRIGGER update_vin_on_trade_in AFTER INSERT ON trade_in FOR EACH ROW EXECUTE PROCEDURE trade_in_vin_new_or_not();",
                                        "CREATE TRIGGER on_car_sale AFTER INSERT ON sale FOR EACH ROW EXECUTE PROCEDURE update_car_on_sale();"

    };

    public TriggersHelper() {
    }

    public static void createTriggers() {
         for(String s : TRIGGERS) {
             System.out.println(s);
         }
    }
    public static void createTriggerFunctions() {
         for(String s : TRIGGER_FUNCTIONS) {
             System.out.println(s);
         }
    }

}
