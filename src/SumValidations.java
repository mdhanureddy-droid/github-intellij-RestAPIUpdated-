import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import files.Payload;

public class SumValidations {

    @Test
    public void sumOfCourses() {
        int sum = 0;
        JsonPath jsonPath = new JsonPath(Payload.coursePrice());
        int count = jsonPath.getInt("courses.size()");
        for (int i = 0; i < count; i++) {
            int price = jsonPath.getInt("courses[" + i + "].price");
            int copies = jsonPath.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            System.out.println(amount);
            sum = sum + amount;
        }
        System.out.println(sum);
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }

}
