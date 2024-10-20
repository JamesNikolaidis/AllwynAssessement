package com.allwyn.dimitris_nikolaidis.assessment.tests;

import com.allwyn.dimitris_nikolaidis.assessment.models.Books;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

public class BooksStepDefinition extends TestUtils {

    @Value("${application.api.prefix}")
    private String appPath;

    @Value("${application.books.api.endpoint}")
    private String booksEndpoint;

    private Response response;

    private static final String GET_BOOKS_WITH_ID_EXPECTED_TITLE = "Book 1";
    private static final String GET_BOOKS_WITH_ID_NEW_EXPECTED_TITLE = "new Title";
    private static final String GET_BOOKS_WITH_ID_UPDATED_EXPECTED_TITLE = "updated Title";
    private static final String GET_BOOKS_WITH_INVALID_ID = "-1";

    @Given("the user requests all books")
    public void theUserRequestsAllBooks() {
        response = this.restHelper.get(appPath,booksEndpoint);

    }

    @Then("the user validates that all books has been retrieved")
    public void theUserValidatesThatAllBooksHasBeenRetrieved() {
        String responseBooks = response.asPrettyString();
        Assert.isTrue(responseBooks.contains("\"id\": 196"), "The expected and response books are not the same");
    }

    @Given("the user request for the book with id {int}")
    public void theUserRequestForTheBookWithId(int arg0) {
        response = this.restHelper.get(appPath, booksEndpoint, String.valueOf(arg0));
    }

    @Then("the user validates that the retrieved book contains the correct data")
    public void theUserValidatesThatTheRetrievedBookContainsTheCorrectData() {
        Assert.isTrue(response.getBody().jsonPath().get("title").toString().equalsIgnoreCase(GET_BOOKS_WITH_ID_EXPECTED_TITLE));
    }

    @Given("the user try to delete a book with id {int}")
    public void theUserTryToDeleteABookWithId(int arg0) {
        response = this.restHelper.delete(appPath, booksEndpoint, String.valueOf(arg0));
    }

    @Given("the user try to delete a book with invalid id")
    public void theUserTryToDeleteABookWithInvalidId() {
        response = this.restHelper.delete(appPath, booksEndpoint, String.valueOf(GET_BOOKS_WITH_INVALID_ID));
    }

    @Then("the user validates that the book does not exist")
    public void theUserValidatesThatTheBookDoesNotExist() {
        Assert.isTrue(response.getStatusCode() == 200);
    }

    @Given("the user try to create a new book with the following data")
    public void theUserTryToCreateANewBookWithTheFollowingData(DataTable data) {
        List<Map<String, String>> rows = data.asMaps(String.class, String.class);

        int id = Integer.parseInt(rows.get(0).get("id"));
        String title = rows.get(0).get("Title");
        String description = rows.get(0).get("Description");
        int pageCount = Integer.parseInt(rows.get(0).get("PageCount"));
        String excerpt = rows.get(0).get("Excerpt");
        String publishDate =  rows.get(0).get("PublishDate");

        Books mBooks = new Books(id, title, description, pageCount, excerpt, publishDate);

        response = this.restHelper.post(appPath, booksEndpoint, mBooks.toString());

    }

    @Then("the user validates that the book has been created")
    public void theUserValidatesThatTheBookHasBeenCreated() {
        Assert.isTrue(response.getBody().jsonPath().get("title").toString().equalsIgnoreCase(GET_BOOKS_WITH_ID_NEW_EXPECTED_TITLE));
    }

    @Given("the user try to update the book with id {int} with the following data")
    public void theUserTryToUpdateTheBookWithIdWithTheFollowingData(int arg0, DataTable data) {

        List<Map<String, String>> rows = data.asMaps(String.class, String.class);

        int id = arg0;
        String title = rows.get(0).get("Title");
        String description = rows.get(0).get("Description");
        int pageCount = Integer.parseInt(rows.get(0).get("PageCount"));
        String excerpt = rows.get(0).get("Excerpt");
        String publishDate =  rows.get(0).get("PublishDate");

        Books mBooks = new Books(id, title, description, pageCount, excerpt, publishDate);

        response = this.restHelper.put(appPath, booksEndpoint, String.valueOf(arg0),  mBooks.toString());
    }

    @Then("the user validates that the book has been updated")
    public void theUserValidatesThatTheBookHasBeenUpdated() {
        Assert.isTrue(response.getBody().jsonPath().get("title").toString().equalsIgnoreCase(GET_BOOKS_WITH_ID_UPDATED_EXPECTED_TITLE));
    }

    @Given("the user request for the book with invalid id")
    public void theUserRequestForTheBookWithInvalidId() {
        response = this.restHelper.get(appPath, booksEndpoint, String.valueOf(GET_BOOKS_WITH_INVALID_ID));
    }

    @Then("the user validates that the application returns not found response")
    public void theUserValidatesThatTheApplicationReturnsNotFoundResponse() {
        Assert.isTrue(response.getStatusCode() == 404);
    }

    @Then("the user validates that the application returns invalid request")
    public void theUserValidatesThatTheApplicationReturnsInvalidRequest() {
        Assert.isTrue(response.getStatusCode() == 404);
    }
}
