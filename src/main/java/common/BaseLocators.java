package common;

public class BaseLocators {

    public String TEXT = "//*[text()='%s']";
    public String CONTAINS_CLASS = "//*[contains(@class,'%s')]";
    public String INPUT_BOX_WITH_LABEL = "//input[@id=//label[text()='%s']/@for]";

}
