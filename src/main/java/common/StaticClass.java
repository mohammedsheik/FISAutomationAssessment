package common;

import java.io.File;
import java.io.IOException;

public class StaticClass {
	//Reporting 
    public static final String CLICKING_THE_ELEMENT = "Clicking the element present in the location - '%s' in '%d' seconds";
	public static final String ENTERING_TEXT = "Entering the text - '%s' in the text box - '%s'";
	public static final String EXPECTED_ATTRIBUTE_VALUE_WITH_LOCATION_MATCHING = "Attribute - '%s' with value - '%s' is present in the location  '%s' in '%d' seconds";
	public static final String EXPECTED_ATTRIBUTE_VALUE_WITH_LOCATION_NOT_MATCHING = "Attribute - '%s' with value - '%s' is not present in the location '%s' in '%d' seconds\nActual value found : %s";


	//Path
    public static final String SCREENSHOT_PATH = System.getProperty("user.dir")+ File.separator+"Screenshots"+File.separator;

    //Time Out
    public static int SHORT_TIMEOUT ;
    public static int MEDIUM_TIMEOUT;
    public static int LONG_TIMEOUT;
    public static int IMPLICIT_TIMEOUT;

    static {
    	try {
			setTimeOut();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void setTimeOut() throws IOException {
    	String pageLoading = (String) PropertyManager.getPropertiesInstance().get("PageLoading");
    	switch(pageLoading.toUpperCase()) {
	    	case "SLOW":
	    		IMPLICIT_TIMEOUT = 10;
	    		SHORT_TIMEOUT = 30;
	    		MEDIUM_TIMEOUT = 45;
	    		LONG_TIMEOUT = 90;    		
	    		break;
	    	
	    	case "NORMAL":
	    	default:
	    		IMPLICIT_TIMEOUT = 5;
	    		SHORT_TIMEOUT = 10;
	    		MEDIUM_TIMEOUT = 30;
	    		LONG_TIMEOUT = 60;
    	}
    }
}
