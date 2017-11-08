public class StoredProcHelper {
    private static String[] STORED_PROCS = { "create or replace function calculate_profits(id int) returns money as $$ BEGIN return (SELEct sum(PRICE) FROM SALE WHERE EMP_ID = ID) * (SElect commission from employee where emp_id = id) / 100; END; $$ language plpgsql;" };

    public StoredProcHelper() {
    }
    
    public static void createStoredProcs() {
         for(String s : STORED_PROCS) {
             System.out.println(s);
         }
    }

}
