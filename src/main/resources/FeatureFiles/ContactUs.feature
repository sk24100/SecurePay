@contactus @functional @regression @local-en
Feature: ContactUs form

  @test01
  Scenario: 1 - Contact us form filled with random data
    Given I launch contactus page from secure pay
    Then I should be able validate if contactus page is loaded
    And I enter random value in First Name
    And I enter random value in Last Name
    And I enter random value in Email
    And I enter random Phone
    And I enter random URL
    And I enter random company Name
    And I enter random reason
    Then i close the browser
