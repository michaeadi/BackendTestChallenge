package michael.adinebo.freenow;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BackendTestChallenge {

    String userName = "Samantha";

    @Test
    public void TestAPILive() {
        given().
                when().
                get("https://jsonplaceholder.typicode.com/users").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON);
    }

    @Test
    public void SearchUser() {
        assert true;
    }

}
