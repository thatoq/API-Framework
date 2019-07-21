package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Restutil
{
    public  static  String path;
    public  static void setBaseURI(String baseURI)
    {
        RestAssured.baseURI=baseURI;
    }
    public  static void  setBasePath(String basePathTerm)
    {
        RestAssured.basePath=basePathTerm;
    }
    public  static void resetBaseURI()
    {
        RestAssured.baseURI=null;
    }
    public  static void resetBasePath()
    {
        RestAssured.basePath=null;
    }
    public static void setContentType(ContentType Type)
    {
        given().contentType(Type);

    }
    public  static  void setHeader(Header header)
    {
        given().header(header);
    }
    public  static Response getResponse()
    {
        return get(path);
    }
}