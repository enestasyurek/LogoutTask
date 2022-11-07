@logout
  Feature: Logout

    Background:
      Given The user is login page
      And The user logs in as a "sales manager"

      Scenario: AC:1-2 User can log out by using log out button inside profile info and ends up in login page.
      When The user clicks on the "Log out" button inside profile info
      Then The user should be on the "Login" page

      Scenario: AC:3- The user can not go to the home page again by clicking the step back button after successfully logged out.
        When The user clicks on the "Log out" button inside profile info
        And The user should be on the "Login" page
        And The user clicks on the step back button
        Then The user should be on the "Login" page

      Scenario: 4- The user must be logged out if the user close the tab (if there are multiple open tabs in the app, close all of them)
        Then The user closes the tabs
        And The user goes to "https://qa.transmuda.com/"
        Then The user should be on the "Login" page

       Scenario: 5- The user must be logged out if the user is away from keyboard for 3 minutes (AFK)
         When The user waits for 3 minutes
         Then The user should be on the "Login" page