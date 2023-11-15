# Test Plan V1.2

**Author**: \<Team158\>

V1.2 Changelog - Added final bug tracking data, filled in final testing results with regression testing results <br>
V1.1 Changelog - Added bug tracking data to table, filled in completed tests from alpha, updated changed class <br>
V1.0 Changelog - Initial Creation <br>

## 1 Testing Strategy

### 1.1 Overall strategy

The testing strategy will use a multi-faceted plan utilizing a black and white box testing techniques using JUnit and manual test suites guided by a test driven development approach. Unit tests will be developed near the start of development to assist programmers with implementation of their assigned features. Both developers and test engineers will be responsible for developing and executing these tests. Integration tests will be developed as each engineer is working on their respective subsystems in conjunction with the test engineer. The test engineer will take primary responsibility for executing integration tests with input and feedback from developers. System tests will be developed by the entire team and executed by the team with the test engineer as lead. Regression testing will take place during final development and will be the responsibility of the test engineer to execute and give results back to the team.

### 1.2 Test Selection

Test selection will use a combination of white-box and black-box tests. At the unit and integration level, we will choosing a set of JUnit tests that provide full code coverage and address possible points of failure. At the integration and system level, we will be employing a set of black box tests that cover all requirements of the program and full system functionality.

### 1.3 Adequacy Criterion

The adequacy of our test cases will be evaluated on a combination of code coverage and functional coverage. The all methods and variables should be addressed in at least one JUnit test suite testing each possible point of independent failure. Beyond that, each piece of interdependent code should be tested with all of it functional parts isolated in normal, edge, and failure conditions. The full functioning program will be tested with a series of scenario driven manual tests focused on ensuring all pieces of the code requirements are met by the program. 

### 1.4 Bug Tracking

Bug Tracking will be handled by utilizing a shared spreadsheet. Each member will be able to add bugs as found and assign them a priority based on impact and severity. The member will record the: <br>

<ul>
<li>The nature of the bug.</li>
<li>Line of code where the bug was identified if possible.  </li>
<li>Severity rated 1-10 based on how much of the program is impacted.  </li>
<li>Name of resource who discovered bug. </li>
<li>Date discovered</li>
<li>Name of resource who will be patching the bug (once volunteered)</li>
<li>Status of the bug </li>

</ul>

| Nature of Bug                                         | Line                       | Severity | Discovered | Date Discovered | Resource | Status   |
|-------------------------------------------------------|----------------------------|----------|------------|-----------------|----------|----------|
| Job score calculation method overload not functioning | Variable, in job class     |        4 | Matt       |          3/3/23 | Jordan   | Resolved |
| Job score calculation method possible divide by zero  | Variable, in job class     |        3 | Matt       |          3/3/23 | Jordan   | Resolved |
| AYS not being calculated correctly                    | Unknown                    |        3 | Jordan     |          3/3/23 | Zach     | Resolved |
| Dummy data with every EnterJobOffer Click             | EnterJobOffer              |        2 | Matt       |          3/9/23 | Jordan   | Resolved |
| Double overfill on jobscore calc                      | calcjobscore               |        3 | Matt       |          3/9/23 | Matt     | Resolved |
| Buffer overflow on job score                          | EnterJobOffer, EnterCurJob |        3 | Matt       |         3/10/23 | Matt     | Resolved |
| Weight buffer overflow                                | Weight                     |        4 | Matt       |         3/11/23 | Matt     | Resolved |
| EnterCurJob not linking on compare                    | EnterCurJob                |        4 | Ming       |         3/11/23 | Ming     | Resolved |
| Weight not updating in compare table                  | Weight,WeightDao           |        4 | Jordan     |         3/11/23 | Jordan   | Resolved |
| Job Highlight highlighting extra job on scroll        | CompareOffersAdapter       |        1 | Matt       |         3/12/23 | Matt     | Resolved |
| Current Job stats not present                         | EnterCurJob                |        2 | Jordan     |         3/12/23 | Jordan   | Resolved |


### 1.5 Technology

We will be employing a combination of JUnit and manual testing 

## 2 Test Cases

Tests will be added and modified during beta development as needed. System wide tests and final Integration test will take place in final week of development. Full test battery will be used for regression testing for final production.

### 2.1 Unit Test Cases

| Test Case | Test Description            | Steps                                                                       | Expected Result | Actual Result | Pass/Fail |
|-----------|-----------------------------|-----------------------------------------------------------------------------|-----------------|---------------|-----------|
| TC-U-01   | Unit test weight class      | Call JUnit test suite evaluating boundaries and methods of weight class      | All tests pass  | All tests pass           | Pass       |
| TC-U-02   | Unit test location class    | Call JUnit test suite evaluating boundaries and methods of location class    | All tests pass  | All tests pass           | Pass       |
| TC-U-03   | Unit test offers class        | Call JUnit test suite evaluating boundaries and methods of offers class        | All tests pass  | All tests pass           | Pass       |
| TC-U-04   | Unit test job class         | Call JUnit test suite evaluating boundaries and methods of job class         | All tests pass  | All tests pass           | Pass       |
| TC-U-05   | Unit test compare interface | Call JUnit test suite evaluating boundaries and methods of compare interface | All tests pass  | All tests pass           | Pass       |


### 2.2 Integration Test Cases

| Test Case | Test Description                                                              | Steps                                                                                                      | Expected Result | Actual Result | Pass/Fail |
|-----------|-------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-----------------|---------------|-----------|
| TC-I-01   | Integration test weight class with offers class                                 | Call JUnit test suite evaluating boundaries and methods of weight class with offers class                     | All tests pass  | All tests pass           | Pass       |
| TC-I-02   | Integration test location class with job and offers class                       | Call JUnit test suite evaluating boundaries and methods of with job and offers class                          | All tests pass  | All tests pass           | Pass       |
| TC-I-03   | Integration test offers class with job,location, and weight classes             | Call JUnit test suite evaluating boundaries and methods of offers class with job,location, and weight classes | All tests pass  | All tests pass           | Pass       |
| TC-I-04   | Integration test compare interface with offers,job,weight, and location classes | Call JUnit test suite evaluating boundaries and methods of job class                                        | All tests pass  | All tests pass            | Pass       |
| TC-I-05   | Integration test compare UI elements with job class                           | Manual test suite entering in data that evaluates linkage between UI and job class                         | All tests pass  | All tests pass           | Pass       |

### 2.3 System Test Cases

| Test Case | Test Description                       | Steps                                                                                                 | Expected Result | Actual Result | Pass/Fail |
|-----------|----------------------------------------|-------------------------------------------------------------------------------------------------------|-----------------|---------------|-----------|
| TC-S-01   | System test choose job details         | Manual test suite testing all aspects of requirement for enter or edit of job details                 | All tests pass  | All tests pass           | Pass       |
| TC-S-02   | System test enter job offer            | Manual test suite testing all aspects of requirement for enter job offer                              | All tests pass  | All tests pass           | Pass       |
| TC-S-03   | System test adjust comparison settings | Manual test suite testing all aspects of requirement for adjust comparison settings                   | All tests pass  | All tests pass           | Pass       |
| TC-S-04   | System test compare job offers         | Manual test suite testing all aspects of requirement for job offers                                   | All tests pass  | All tests pass           | Pass       |
| TC-S-05   | System test stress test                | Manual test suite testing boundaries and failure points of all UI elements with back end functionality | All tests pass  | All tests pass           | Pass       |
| TC-S-06   | System test soak test                  | Manual test suite testing of all UI elements for rapid succession data entry                          | All tests pass  | All tests pass           | Pass       |

### 2.3 Regression Test Cases

| Test Case | Test Description                                                              | Steps                                                                                                      | Expected Result | Actual Result | Pass/Fail |
|-----------|-------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-----------------|---------------|-----------|
| TC-U-01   | Unit test weight class                                                        | Call JUnit test suite evaluating boundaries and methods of weight class                                     | All tests pass  | All tests pass           | Pass       |
| TC-U-02   | Unit test location class                                                      | Call JUnit test suite evaluating boundaries and methods of location class                                   | All tests pass  | All tests pass           | Pass       |
| TC-U-03   | Unit test offers class                                                          | Call JUnit test suite evaluating boundaries and methods of offers class                                       | All tests pass  | All tests pass           | Pass       |
| TC-U-04   | Unit test job class                                                           | Call JUnit test suite evaluating boundaries and methods of job class                                        | All tests pass  | All tests pass           | Pass       |
| TC-U-05   | Unit test compare interface                                                   | Call JUnit test suite evaluating boundaries and methods of compare interface                                | All tests pass  | All tests pass           | Pass       |
| TC-I-01   | Integration test weight class with offers class                                 | Call JUnit test suite evaluating boundaries and methods of weight class with offers class                     | All tests pass  | All tests pass           | Pass       |
| TC-I-02   | Integration test location class with job and offers class                       | Call JUnit test suite evaluating boundaries and methods of with job and offers class                          | All tests pass  | All tests pass           | Pass       |
| TC-I-03   | Integration test offers class with job,location, and weight classes             | Call JUnit test suite evaluating boundaries and methods of offers class with job,location, and weight classes | All tests pass  | All tests pass           | Pass       |
| TC-I-04   | Integration test compare interface with offers,job,weight, and location classes | Call JUnit test suite evaluating boundaries and methods of job class                                        | All tests pass  | All tests pass           | Pass       |
| TC-I-05   | Integration test compare UI elements with job class                           | Manual test suite entering in data that evaluates linkage between UI and job class                         | All tests pass  | All tests pass           | Pass       |
| TC-S-01   | System test choose job details                                                | Manual test suite testing all aspects of requirement for enter or edit of job details                      | All tests pass  | All tests pass           | Pass       |
| TC-S-02   | System test enter job offer                                                   | Manual test suite testing all aspects of requirement for enter job offer                                   | All tests pass  | All tests pass           | Pass       |
| TC-S-03   | System test adjust comparison settings                                        | Manual test suite testing all aspects of requirement for adjust comparison settings                        | All tests pass  | All tests pass           | Pass       |
| TC-S-04   | System test compare job offers                                                | Manual test suite testing all aspects of requirement for job offers                                        | All tests pass  | All tests pass           | Pass       |
| TC-S-05   | System test stress test                                                       | Manual test suite testing boundaries and failure points of all UI elements with back end functionality      | All tests pass  | All tests pass           | Pass       |
| TC-S-06   | System test soak test                                                         | Manual test suite testing of all UI elements for rapid succession data entry                               | All tests pass  | All tests pass           | Pass       |
