import Utils.HelperMethods;
import Utils.Restutil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.XMLObject;
import java.io.FileInputStream;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PostSoapRequest
{
    private Response res=null;
    @BeforeTest
    public void setUp()
    {
        Restutil.setBaseURI("http://currencyconverter.kowabunga.net");


    }
    @Test(dataProvider="testDataProvider")
    public void performLoggon(String URL,String requestMethod,String StatusCode)
    {
        //given().contentType("text.xml").body(IOUtils.toString(HelperMethods.getCellData()))

    }
    @Test
    public void T01_StatusCodeTest() throws Exception
    {
        FileInputStream fileinputstream=new FileInputStream("C:\\WorkSpace\\TestAutomationFramework\\API\\SoapRequest\\SoapRequest");
        res=given().
                header("Content-Type","text/xml").
                body(IOUtils.toString(fileinputstream,"UTF-8")).
                when().
                post("/converter.asmx").
                then().
                statusCode(200).log().all().extract().response();
        XmlPath xmlpath=new XmlPath(res.asString());
        String rate=xmlpath.getString("GetConversionRateResult");
        System.out.println("rate is"+rate);

    }
    @AfterTest
    public void afterTest()
    {
        Restutil.resetBaseURI();
    }

    @Test
    public  void  PostConversionRate()
    {
        try
        {
            FileInputStream fileinputstream=new FileInputStream("C:\\WorkSpace\\TestAutomationFramework\\API\\SoapRequest\\SoapRequest");
            Response response=
                    given()
                       .header("Content-Type","text/xml")
                       .and()
                       .body(IOUtils.toString(fileinputstream,"UTF-8"))
                   .when()
                       . post("/converter.asmx")
                    .then()
                        .statusCode(200)
                         .log().all().extract().response();
            XmlPath xmlpath=new XmlPath(response.asString());
            String rate=xmlpath.getString("GetConversionRateResult");
            System.out.println("rate is"+rate);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
