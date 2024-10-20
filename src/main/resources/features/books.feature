Feature: Book test suite

  Scenario: Check that the webpage returns all books
    Given the user requests all books
    Then the user validates that all books has been retrieved

  Scenario: Check that the user can retrieve specific book
    Given the user request for the book with id 1
    Then the user validates that the retrieved book contains the correct data

  Scenario: Check that a book can be deleted successfully
    Given  the user try to delete a book with id 1
    Then the user validates that the book does not exist

  Scenario: the user creates a new book successfully
    Given the user try to create a new book with the following data
      |id|Title        |Description        |PageCount|Excerpt|PublishDate|
      |10|new Title    |new description    |400      |new    |2024-10-20T12:08:48.537Z |
    Then the user validates that the book has been created

  Scenario:  Check that the user can update an existing book
    Given the user try to update the book with id 10 with the following data
          |Title        |Description        |PageCount|Excerpt|PublishDate|
          |updated Title|updated description|400      |updated|2024-10-20T12:08:48.537Z |
    Then the user validates that the book has been updated

  Scenario: Check that the user cant retrieve specific book when provide invalid id
    Given the user request for the book with invalid id
    Then the user validates that the application returns not found response

# The below scenario will fail because the application allows to provide an -1 as id which i believe is not correct
  Scenario: Check that a book cant retrieve specific book when provide invalid id
    Given  the user try to delete a book with invalid id
    Then the user validates that the application returns not found response

  Scenario: the user cant create a new book with invalid data
    Given the user try to create a new book with the following data
      |id|Title        |Description        |PageCount|Excerpt|PublishDate|
      |-1|new Title    |new description    |-1      |new    |1 |
    Then the user validates that the application returns invalid request

