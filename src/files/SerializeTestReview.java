package files;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import Lombok.AddPlace;
import Lombok.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializeTestReview {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        AddPlace p = new AddPlace.Builder()
                .accuracy(50)
                .address("29, side layout, cohen 09")
                .language("French-IN")
                .phoneNumber("(+91) 983 893 3937")
                .website("https://rahulshettyacademy.com")
                .name("Frontline house")
                .types(List.of("shoe park", "shop"))
                .location(l)
                .build();
        Response res = given().log().all().queryParam("key", "qaclick123")
                .body(p)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();

        String responseString = res.asString();
        System.out.println(responseString);
    }

}
