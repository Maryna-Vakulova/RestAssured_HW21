package API;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HW_21_TestUserNotFound {

    private final static String URL = "https://reqres.in/";

    @Test
    public void checkUserNotFound() {
        Specification.installSpecification(Specification.requestSpecification(URL),
                Specification.responseSpecification(404));

        Response response = given()
                .when()
                .get("api/users/23")
                .then().log().all()
                .extract().response();
    }
}
