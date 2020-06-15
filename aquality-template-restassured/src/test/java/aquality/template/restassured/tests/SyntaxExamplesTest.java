package aquality.template.restassured.tests;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/**
 * {
 * "lotto":{
 *  "lottoId":5,
 *  "winning-numbers":[2,45,34,23,7,5,3],
 *  "winners":[{
 *    "winnerId":23,
 *    "numbers":[2,45,34,23,3,5]
 *  },{
 *    "winnerId":54,
 *    "numbers":[52,3,12,11,18,22]
 *  }]
 * }
 * }
 */
public class SyntaxExamplesTest {
    public void checkLottoId(){
        given().get("/lotto").then().body("lotto.lottoId", equalTo(5));
    }


    public void checkWinnerItems(){
        given().get("/lotto").then().body("lotto.winners.winnerId", hasItems(23, 54));
    }


    /**
     * Response sample: { "userId" : "some-id", "href" : "http://localhost:8080/some-id" }
     */
    public void verifyOtherPartOfResponse(){
        given().get("/x").then().body("href", response -> equalTo("http://localhost:8080/" + response.path("userId")));
    }

    /**
     * Form when necessary to input username/password and click submit
     * <html>
     *   <head>
     *     <title>Login</title>
     *   </head>
     *
     *   <body>
     *     <form action="j_spring_security_check" method="POST">
     *       <table>
     *         <tr><td>User:&nbsp;</td><td><input type='text' name='j_username'></td></tr>
     *         <tr><td>Password:</td><td><input type='password' name='j_password'></td></tr>
     *           <tr><td colspan='2'><input name="submit" type="submit"/></td></tr>
     *        </table>
     *         </form>
     *       </body>
     *  </html>
     */
    public void formAuthentication(){
        given().auth().form("John", "Doe", new FormAuthConfig("/j_spring_security_check", "j_username", "j_password")).
                when().get("/formAuth").then().statusCode(200);
    }

}
