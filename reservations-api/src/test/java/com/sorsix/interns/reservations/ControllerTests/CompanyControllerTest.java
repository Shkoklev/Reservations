package com.sorsix.interns.reservations;

import com.sorsix.interns.reservations.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {

    @Test
    public void get_company_returns_200_with_expected_id() {

//        when().
//                get("/api/companies/{id}", 3).
//                then().
//                statusCode(200).
//                body("name", equalTo("La Tana")).
//                body("address", equalTo("Krushevska Republika, 1000 Skopje")).
//                body("capacity", equalTo(120)).
//                body("workingDaysMask", equalTo("0000111"));
    }

}
