
Feature: Search from Google  
  Scenario: Search result list from google for testmaster keyword
    Given I am staying google.com.vn
    When I provide "Testmaster" keyword into the search box field
    And I click button search
    Then I should see the "Đào tạo Tester tại Hà Nội" on search reesult box

