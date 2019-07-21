package APITests;

import Utils.HelperMethods;
import Utils.Restutil;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class QuerySubTest
{
    private Response res=null;

    @Test
    public  void setUp()
    {
        Restutil.setBaseURI("");
        Restutil.path="";
        Restutil.setContentType(ContentType.XML);
        res=Restutil.getResponse();
    }
    @Test
    public void T01_StatusCode()
    {

    }

}
