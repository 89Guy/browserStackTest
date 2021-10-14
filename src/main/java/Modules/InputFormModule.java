package Modules;

import Beans.InputForm;
import Pages.InputFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class InputFormModule {
    private InputFormPage inputFormPage;
    WebDriver driver;

    public InputFormModule(){
        inputFormPage=new InputFormPage();
    }

    @Test
    public void createInputPage(){
        InputForm inputForm= InputForm.getCSVData("user01");
        inputFormPage.enterFirstName(inputForm.getFirstName());
        inputFormPage.enterLastName(inputForm.getLastName());
        inputFormPage.enterEmail(inputForm.getEmail());
        inputFormPage.enterPhone(inputForm.getPhone());
        inputFormPage.enterAddress(inputForm.getAddress());
        inputFormPage.enterCity(inputForm.getCity());
        inputFormPage.selectState(inputForm.getState());
        inputFormPage.enterZip(inputForm.getZipCode());
        inputFormPage.enterWebsite(inputForm.getWebsiteOrDomainName());
        inputFormPage.hostingRadioButton(inputForm.getHostingYes());
        inputFormPage.enterDescription(inputForm.getProjectDescription());
    }
}
