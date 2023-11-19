package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Reqrest {

    
    private final String Base_URL = "https://reqres.in/";

    @Before
    public void setup (){
        RestAssured.baseURI=Base_URL;
        System.out.println("--------------------");
        System.out.println("Test start");
        
    }


    @Test
    public void consultarusuariospagina2() {
        given()
            .queryParam("page", 2)
        .when()
            .get("/api/users")
        .then()
            .assertThat()
            .statusCode(200);
        
    }

    @Test
    public void consultardatosdelusuario12() {
        given()
        .when()
            .get("/api/users/12")
        .then()
            .assertThat()
            .statusCode(200);
    }

    @Test
    public void crearunusuarionuevo() {
        String requestBody = "{ \"name\": \"Juanita Perez\", \"job\": \"QA Automation\" }";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .assertThat()
            .statusCode(201);
        }

    @Test

    public void actualizardatosdelusuariocreado() {
        String requestBody = "{ \"name\": \"Pepita Rodriguez\", \"job\": \"Desarrollador\" }";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("/api/users/12")
        .then()
            .assertThat()
            .statusCode(200);
    }

    @Test
    public void borrarunusuario() {
        given()
        .when()
            .delete("/api/users/12")
        .then()
            .assertThat()
            .statusCode(204);
    
    }

    @After
    public void Teardown(){

        System.out.println("Test end");
        System.out.println("---------------------------------------");

    }

}
