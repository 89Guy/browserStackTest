package Modules;

import Pages.BrowserStackPage;
import Pages.TestPage;
import org.testng.annotations.Test;

public class TestModule extends BrowserStackPage {

    @Test
    public void filpkartMobileSearchListing() {
        TestPage testPage = new TestPage(driver);
        testPage.searchMobile("Samsung Galaxy S10");
        // testPage.clickFlipKartAssured();
        //testPage.brandSelect();
        testPage.mobileSort();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(testPage.listOfMobilesOnFirstPage());
    }
}
