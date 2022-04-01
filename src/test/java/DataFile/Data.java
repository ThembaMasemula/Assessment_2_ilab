package DataFile;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {

    Connection conn = null;

    public Recordset readExcelFile(){
        Recordset rs = null;
        try{
            Fillo fillo = new Fillo();
            conn = fillo.getConnection("TestData/DataExcel.xlsx");
            String strQuery = "Select * from Booking";
            rs = conn.executeQuery(strQuery);
        }catch (FilloException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public ResultSet loadfromDatabase(String sDBURL, String sUserName, String sPassword,String sQuery) {

        ResultSet rs = null;
        try {

            String dbURL = sDBURL;
            String user = sUserName;
            String pass = sPassword;
            java.sql.Connection conn = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }


}
