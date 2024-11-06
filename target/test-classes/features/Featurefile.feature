Feature: Test



@UnicaLogin
Scenario: Successful Login with Valid Credentials into IntelliServices
Given Login to unica Application
When Validate the Login Page
Then I create IC with "ICName" and "RunTimeServerGroup"
      | column1 | column2 |
      | IC  | IC1  |
And I create multiple IC

@RTPLogin
Scenario: Navigate to RTP from IntelliServices
Given Click on RTP Application from unica
Then Click on webDomaintab in RTP Application
#And Create webDomain in RTP Application
And Search and click for webDomain in RTPApplication
#And Create webpage on webDomain
And Click on webpage in webDomain

@SeleniumPractice
Scenario: Practicing difficult scnearios 
Given Successfully navigated to selenium practice application
When Validated Broken Images on selenium practice application

@SeleniumPractice1
Scenario: Practicing excel reading
Given Successfully login to application and register users



@SeleniumDataReading1
Scenario Outline: Using values from examples directly

    Given I create feature file
    When I use column1 as "testing" and column2 as "testing2"
       | column1      | column2 |
    | Bharadwaj    | bhar23  |
    | Vishnupriya   | bhar23  |
    
    Then I perform an action with these values

  
@SeleniumDataReading1
Scenario: testing
    Given I create feature file
    When I use column1 as "testing" and column2 as "testing2"
       | column1      | column2 |
    | Bharadwaj    | bhar23  |
    | Vishnupriya   | bhar23  |
    
    Then I perform an action with these values
    
    
    @ScenarioOutlining
Scenario Outline: Using Scenarios for data reading

    Given I create feature filess
    When I read column1 as "<column1>" and column2 as "<column2>"
    Then testing the scenarios
     And I read column2 as "<column1>" and column2 as "<column2>"
     Examples:
     | column1      | column2 |
    | Bharadwaj    | bhar23  |
    | Vishnupriya   | bhar23  |
    
    
    @MyntraScenario
    Scenario: Testing price filter
    
    Given I navigate to myntra loginpage
    When Select Price in myntra page
    Then Select exactPrice in myntra page
    
     @MyntraScenarioShirts
    Scenario: Testing price filter
    
    Given I navigate to myntra loginpage newPage
    When I set the price range
        | min  | max   |
        | "100" | "500"   |
        | "5000" | "10000" |
   Then validate if the image links are broken or not

    
    

    
    
    
  

  

