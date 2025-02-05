package common;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentManager {
	
	
	static String innerText = "<div style=\"text-align: center;\">\r\n"
			+ "      <div style=\"margin: 0 auto; background: #808080; color: #fff;\">%s</div>\r\n"
			+ "    </div>";

	
	public static void logInfo(String msg) {
		ExtentCucumberAdapter.getCurrentStep().info(msg);
	}
	
	public static void printHeader(String msg) {
		System.out.println(ExtentCucumberAdapter.getCurrentStep());
		ExtentCucumberAdapter.getCurrentStep().info(String.format(innerText, msg));
	}
	
	public static void printNewLine() {
		ExtentCucumberAdapter.getCurrentStep().info("<br>");
	}
	
	public static void logInfo(String msg , String json , CodeLanguage codeLanguage) {
		logInfo(msg);
		ExtentCucumberAdapter.getCurrentStep().info(MarkupHelper.createCodeBlock(json , codeLanguage));
	}

	public static void logPassAndTakeScreenshot(String path , String msg) {
		ExtentCucumberAdapter.getCurrentStep().pass(msg , MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ExtentManager.printNewLine();
	}

	public static void logFailAndAttachScreenshotAsBase64(String screenshot , String msg) {
		ExtentCucumberAdapter.getCurrentStep().fail(msg , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		ExtentManager.printNewLine();
	}
	
}
