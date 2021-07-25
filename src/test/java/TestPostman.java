import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostman {
    @Test
    void shouldReturnData() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .header(new Header("My header", "value1"))
                .queryParam("My Query", "value3")
// Выполняемые действия
       .when()
                .post("/post")
// Проверки
       .then()
                .statusCode(200)
                //в нужном поле хранятся отправленные вами данные
                // (обратите внимание, теперь у вас не массив, а объект)
                .body("data", equalTo("some data"))
                //.header("My header", "value1")
        ;
    }
}