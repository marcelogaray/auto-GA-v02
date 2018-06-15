$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# Login feature review the behavior in thie feature"
    }
  ],
  "line": 2,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Home page is displayed once set credential in login page",
  "description": "",
  "id": "login;home-page-is-displayed-once-set-credential-in-login-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "\u0027PHP travel\u0027 page is loaded",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "set my credentials on \u0027Login\u0027 page",
  "keyword": "And "
});
formatter.match({
  "location": "StepsDefinitionPHPtravel.phpTravelPageIsLoaded()"
});
formatter.result({
  "duration": 14986525203,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinitionPHPtravel.setMyCredentialsOnLoginPage()"
});
formatter.result({
  "duration": 1261843821,
  "status": "passed"
});
formatter.uri("redirectFileStepDefintions.feature");
formatter.feature({
  "line": 1,
  "name": "RedirectNewFile",
  "description": "",
  "id": "redirectnewfile",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Testing new path",
  "description": "",
  "id": "redirectnewfile;testing-new-path",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Tesitng path to generate filed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepdef.tesitngPathToGenerateFiled()"
});
formatter.result({
  "duration": 316480,
  "status": "passed"
});
formatter.uri("userFeatureFiles.feature");
formatter.feature({
  "line": 1,
  "name": "testing",
  "description": "",
  "id": "testing",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "first scenario",
  "description": "",
  "id": "testing;first-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@bvt"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "first introduction to cucumber with java",
  "keyword": "Given "
});
formatter.match({
  "location": "GeneralSteps.firstIntroductionToCucumberWithJava()"
});
formatter.result({
  "duration": 294744,
  "status": "passed"
});
});