//1-Pacote
package petstore;

//2-Biblioteca

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

//3-Classe
public class Pet {
    //4-Atributos
    String uri = "https://petstore.swagger.io/v2/pet";

    //5-Metodos e funções
    public String lerJson(String caminhoJson) throws IOException {
        return (new String(Files.readAllBytes(Paths.get(caminhoJson))));
    }

    //Incluir - Create - Post
    @Test
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        //Sintaxe Gherkin
        //Dado - Quando - Então
        //Given - When - Then

        given()//Dado
                .contentType("application/json") //Comum em API REST - antigas era "text/xml"
                .log().all() //IDA da Requisição
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all() //VOLTA da Requisição
                .statusCode(200);
    }

}
