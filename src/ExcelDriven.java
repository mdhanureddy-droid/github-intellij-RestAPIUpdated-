import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.ReusableMethods;

public class ExcelDriven {

    @Test
    public void addBook() throws IOException {
        DataDriven d = new DataDriven();
        ArrayList data = d.getData("RestAddbook", "sample");
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", data.get(1));
        map.put("isbn", data.get(2));
        map.put("aisle", data.get(3));
        map.put("author", data.get(4));

        RestAssured.baseURI = "http://216.10.245.166";
        Response resp = given()
                .header("Content-Type", "application/json")
                .body(map)
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response();
        JsonPath jsonPath = ReusableMethods.rawToJson(resp.asString());
        String id = jsonPath.get("ID");
        System.out.println(id);
    }

    public static String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
