package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticUtility {

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String formatNullToEmpty(String str){
        return str==null?"":str;
    }

}
