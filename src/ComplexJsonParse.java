import io.restassured.path.json.JsonPath;
import files.Payload;

public class ComplexJsonParse {

    public static void main(String[] args) {
        JsonPath jsonPath = new JsonPath(Payload.coursePrice());
        int count = jsonPath.getInt("courses.size()");
        System.out.println(count);
        int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        String titleFirstCourse = jsonPath.get("courses[0].title");
        System.out.println(titleFirstCourse);

        for (int i = 0; i < count; i++) {
            String courseTitles = jsonPath.get("courses[" + i + "].title");
            System.out.println(jsonPath.get("courses[" + i + "].price").toString());
            System.out.println(courseTitles);
        }

        System.out.println("Print no of copies sold by RPA Course");
        for (int i = 0; i < count; i++) {
            String courseTitles = jsonPath.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = jsonPath.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }
    }

}
