package apI_task;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RecipeAPITest {

    private static final String BASE_URL = "https://dummyjson.com/recipes";

 
    @Test
    public void testGetAllRecipes() {
        Response response = given()
                .when().get(BASE_URL)
                .then().statusCode(200).extract().response();

        Assert.assertNotNull(response.jsonPath().get("recipes"));
        System.out.println("First Recipe Title: " + response.jsonPath().getString("recipes[0].name"));
        System.out.println("Ingredients: " + response.jsonPath().getList("recipes[0].ingredients"));
    }

   // Single Recipe by ID
    @Test
    public void testGetRecipeById() {
        int recipeId = 1; 
        Response response = given()
                .when().get(BASE_URL + "/" + recipeId)
                .then().statusCode(200).extract().response();

        // Validate that the correct ID is returned
        Assert.assertEquals(response.jsonPath().getInt("id"), recipeId);
        System.out.println("Fetched Recipe: " + response.asPrettyString());
    }

    // Search Recipes by Name
    @Test
    public void testSearchRecipe() {
        String query = "chicken";
        Response response = given()
                .queryParam("q", query)
                .when().get(BASE_URL + "/search")
                .then().statusCode(200).extract().response();

        Assert.assertTrue(response.jsonPath().getList("recipes").size() > 0);
        System.out.println("Search Results: " + response.jsonPath().getList("recipes"));
    }

    //  Add a New Recipe (POST)
    @Test
    public void testAddRecipe() {
        String requestBody = "{ \"name\": \"Test Recipe\", \"ingredients\": [\"Flour\", \"Water\"], \"instructions\": \"Mix well.\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post(BASE_URL + "/add")
                .then().statusCode(200).extract().response();

        Assert.assertNotNull(response.jsonPath().get("id"));
        System.out.println("Added Recipe: " + response.asPrettyString());
    }

    // Update a Recipe (PUT)
    @Test
    public void testUpdateRecipe() {
        int recipeId = 1;
        String updateBody = "{ \"name\": \"Updated Recipe Name\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(updateBody)
                .when().put(BASE_URL + "/" + recipeId)
                .then().statusCode(200).extract().response();

        Assert.assertEquals(response.jsonPath().getString("name"), "Updated Recipe Name");
        System.out.println("Updated Recipe: " + response.asPrettyString());
    }

    //  Delete a Recipe
    @Test
    public void testDeleteRecipe() {
        int recipeId = 1;

        Response response = given()
                .when().delete(BASE_URL + "/" + recipeId)
                .then().statusCode(200).extract().response();

        System.out.println("Delete Response: " + response.asPrettyString());
    }
}
