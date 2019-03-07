Feature: A simple mathematical BDD test

  Scenario Outline: Two numbers can be added
    Given the numbers <a> and <b>
    When the numbers are added together
    Then the result is <result>

  Examples:
    |  a | b  | result |
    |  1 | 10 | 11     |
    |  0 |  0 |  0     |
    | 10 | -5 |  5     |
    | -1 |  1 |  0     |