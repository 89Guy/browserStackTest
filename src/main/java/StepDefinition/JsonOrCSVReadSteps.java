package StepDefinition;

import Beans.InputForm;
import Pages.InputFormPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class JsonOrCSVReadSteps {

    WebDriver driver;
    InputFormPage inputFormPage;

    public JsonOrCSVReadSteps(){
        inputFormPage = new InputFormPage();
    }


    @Given("^input form to fill up the Data$")
    public void inputFormStart(){
        System.out.println("To fill the input form");
    }

    @Given("^input null value$")
    public void inputNullValue(){
        System.out.println(1/0);
    }

    @When("^user fillsup the form with all required information for user \"([^\"]*)\" using \"([^\"]*)\"$")
    public void inputFormDataInitUsingJson(String uniqueValue,String formatType){
        if(formatType.equalsIgnoreCase("csv")){
            InputForm inputForm= InputForm.getCSVData(uniqueValue);
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
        else if(formatType.equalsIgnoreCase("json")){
            InputForm inputForm= InputForm.getJsonData(uniqueValue);
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

    @Then("^user should be registered$")
    public void userRegistered(){
        System.out.println("userRegistered");
    }

    @When("^user fillsup the form with all required information for user using DataTablelistOfList$")
    public void dataTableListOfList(DataTable dataTable){
        List<List<String>> rows = dataTable.asLists(String.class);
        int counter=0;
        for (List<String> columns : rows) {
            if(counter==1) {
                inputFormPage.enterFirstName(columns.get(1));
                inputFormPage.enterLastName(columns.get(2));
                inputFormPage.enterEmail(columns.get(3));
                inputFormPage.enterPhone(columns.get(4));
                inputFormPage.enterAddress(columns.get(5));
                inputFormPage.enterCity(columns.get(6));
                inputFormPage.selectState(columns.get(7));
                inputFormPage.enterZip(columns.get(8));
                inputFormPage.enterWebsite(columns.get(9));
                inputFormPage.hostingRadioButton(columns.get(10));
                inputFormPage.enterDescription(columns.get(11));
            }
            counter+=1;
        }
    }

    @When("^user fillsup the form with all required information for user using DataTablelistOfMap$")
    public void dataTableListOfMap(DataTable dataTable){
        List<Map<String,String>> rows = dataTable.asMaps(String.class,String.class);
        for (Map<String, String> columns : rows) {
            inputFormPage.enterFirstName(columns.get("firstName"));
            inputFormPage.enterLastName(columns.get("lastName"));
            inputFormPage.enterEmail(columns.get("email"));
            inputFormPage.enterPhone(columns.get("phone"));
            inputFormPage.enterAddress(columns.get("address"));
            inputFormPage.enterCity(columns.get("city"));
            inputFormPage.selectState(columns.get("state"));
            inputFormPage.enterZip(columns.get("zipCode"));
            inputFormPage.enterWebsite(columns.get("websiteOrDomainName"));
            inputFormPage.hostingRadioButton(columns.get("hostingYes"));
            inputFormPage.enterDescription(columns.get("projectDescription"));
        }
    }
    @When("^user fillsup the form with all required information for user using exampleTable \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void exampleTable(String uniqueValue,String firstName,String lastName,String email,String phone,String address,String city,String state,String zipCode,String websiteOrDomainName,String hostingYes,String projectDescription){
            inputFormPage.enterFirstName(firstName);
            inputFormPage.enterLastName(lastName);
            inputFormPage.enterEmail(email);
            inputFormPage.enterPhone(phone);
            inputFormPage.enterAddress(address);
            inputFormPage.enterCity(city);
            inputFormPage.selectState(state);
            inputFormPage.enterZip(zipCode);
            inputFormPage.enterWebsite(websiteOrDomainName);
            inputFormPage.hostingRadioButton(hostingYes);
            inputFormPage.enterDescription(projectDescription);
    }
}
