package PageObjects;

import GeneratePhoneNumber.GeneratePhone.PhoneNumber;
import Reports.extentReport;
import WebPageObjects.*;
import WebUtilities.webActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.sql.ResultSet;

public class webFunctions extends webActions
{
    extentReport repo = new extentReport();
    public void select(WebDriver driver, ExtentTest node){

        MenuIteam selectObj = new MenuIteam(driver);

        try{
            clickObject(selectObj.menuItem, driver);


            //validation

        }catch(Exception e){
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }

    }
    public void selectLoc(WebDriver driver, ExtentTest node){

        Location selectLocation = new Location(driver);

        try{
            clickObject(selectLocation.Loc, driver);


            //validation

        }catch(Exception e){
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }

    }

    public void selectPosition(WebDriver driver, ExtentTest node){

        PositionItem selecPosition = new PositionItem(driver);

        try{
            clickObject(selecPosition.posit, driver);


            //validation

        }catch(Exception e){
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }



    }
    public void selectApply(WebDriver driver, ExtentTest node){

        ApplicationIlab clickApply = new ApplicationIlab(driver);

        try{
            clickObject(clickApply.ApplyJob, driver);


            //validation

        }catch(Exception e){
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }



    }

    public void applicationProcess(WebDriver driver, ResultSet rs, ExtentTest node){

        StartApplication Apply = new StartApplication(driver);
        PhoneNumber phoneNo = new PhoneNumber();


        try{
           // clickObject(clickApply.ApplyJob, driver);

            enterData(Apply.AppliName, driver, rs.getString("ApplicantName"));
            enterData(Apply.EmailAddress, driver, rs.getString("Email"));
            enterData(Apply.PhoneNum, driver, phoneNo.PhoneNo());
            enterData(Apply.message, driver, rs.getString("Message"));

            clickObject(Apply.submitApp,driver);

            String filename = repo.CaptureScreenShot(driver);
            Thread.sleep(2000);

            if (Apply.error_message.isDisplayed()) {
                node.pass("Error message displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            } else {
                node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            }



            //validation

        }catch(Exception e){
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }



    }
}
