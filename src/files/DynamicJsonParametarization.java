package files;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJsonParametarization {

    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json")
                .body(Payload.addBook(isbn, aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = ReusableMethods.rawToJson(response);
        String id = jsonPath.get("ID");
        System.out.println(id);
    }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][] {
            {"hsdjhddfj", "1234"},
            {"adsfdsa", "4567"},
            {"sdhoiodsf", "46274"}
        };
    }

}
