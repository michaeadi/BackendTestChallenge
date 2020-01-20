package michael.adinebo.freenow;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

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

    //Search for the user.
    @Test
    public void SearchUser() {
        HashMap<?, ?> userDetail = null;
        List<HashMap<?, ?>> users  = from(given().
                when().
                get("https://jsonplaceholder.typicode.com/users").
                asString()).getList("");
        for (HashMap<?, ?> user : users) {
            if (user.get("username").equals(userName)) {
                userDetail = user;
            }
        }
        SearchUserPost(userDetail);
    }

    //Use the details fetched to make a search for the posts written by the user
    public void SearchUserPost(HashMap<?, ?> userDetail) {
        List<HashMap<?, ?>> posts  = from(given().
                when().
                get("https://jsonplaceholder.typicode.com/posts").
                asString()).getList("");
        for (HashMap<?, ?> post : posts) {
            if (post.get("userId").equals(userDetail.get("id"))) {
                System.out.println(post.get("id"));
            }

        }

    }

}
