package files;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import Lombok.AddPlace;
import Lombok.Location;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpecBuilderTest {

    private RequestSpecification reqSpec;
    private ResponseSpecification resSpec;

    @BeforeClass
    public void setup() {
        reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

    @Test
    public void addPlace() {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen 09");
        p.setLanguage("French-IN");
        p.setPhoneNumber("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName("Frontline house");
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

        JsonPath jsonPath = given().spec(reqSpec)
                .body(p)
                .when().post("/maps/api/place/add/json")
                .then().spec(resSpec).extract().response().jsonPath();

        String status = jsonPath.getString("status");
        String placeId = jsonPath.getString("place_id");
        log.info("Place ID: {}", placeId);

        Assert.assertEquals(status, "OK", "Status should be OK");
        Assert.assertNotNull(placeId, "Place ID should not be null");
        Assert.assertFalse(placeId.isEmpty(), "Place ID should not be empty");
    }
}
