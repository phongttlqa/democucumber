Feature: Manage Pet
  I can manage Pet in my store such as find, update, create new pets

  Scenario Outline: Get Pet by PetID
    Given I provide petID "<petid>"
    When Isend request to get Pet by ID
    Then I get Pet

    Examples: Get Pet
      |petid| 
      | 1 |

	Scenario Outline: Add new Pet
    Given I provide a new pet "<petid>" and "<name>" and "status"
    When Isend request to create a new Pet
    Then I have a new Pet create

    Examples: Create a new pet
      |petid|name|status|
      | 9 | Holly|available|