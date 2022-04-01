package WebTests;

import DataFile.Data;
import PageObjects.webFunctions;
import Reports.extentReport;
import WebUtilities.WebUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.ss.formula.NameIdentifier;
import org.apache.poi.ss.formula.functions.Na;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class JobApplicationTest {

        public WebUtilities web = new WebUtilities();
        public webFunctions NavigateIlab = new webFunctions();
        public extentReport repo = new extentReport();
        ExtentReports reports;

        ResultSet rs;
        String sUrl, sBrowser;
       // ExtentReports reports;

    Data dataTransfer = new Data();

        @Parameters({"IlabURL","Browser"})

        @BeforeTest
        public void beforeMethod(String IlabURL, String Browser) {
        System.out.println(Browser);

            sBrowser = Browser;
            sUrl = IlabURL;

           web.setWebDriver(web.initializeWebDriver(Browser));


            rs = dataTransfer.loadfromDatabase("jdbc:mysql://localhost:3306/applicants","root","root","Select * from apply");
            reports = repo.initilizeExtentReporters("reports/test.html");

        }
        @Test
        public void applicationTest() throws Exception {

            ExtentTest test = reports.createTest("Adactin Hotel Booking ").assignAuthor("Themba Masemula");


            try {

                web.navigate(sUrl);


                   while (rs.next()) {


                       ExtentTest node = test.createNode("iLAB application test");
                       NavigateIlab.select(WebUtilities.getWebdriver(),node);
                        NavigateIlab.selectLoc(WebUtilities.getWebdriver(),node);
                        NavigateIlab.selectPosition(WebUtilities.getWebdriver(),node);
                        NavigateIlab.selectApply(WebUtilities.getWebdriver(),node);
                        NavigateIlab.applicationProcess(WebUtilities.getWebdriver(), rs,node);
                    }
            }
            catch (Exception e) {
                System.out.println("page not found");
                e.printStackTrace();
            }




        }

    @AfterTest
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
      //  web.getWebDriver().quit();
        reports.flush();

     }
    }
