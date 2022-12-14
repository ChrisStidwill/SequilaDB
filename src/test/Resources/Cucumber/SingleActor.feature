Feature: get a specific actor

  Scenario Outline: User wants to get a specific actor from db.
    Given an actor exists in the db with ID <actorID>
    When I request that actor's details
    Then The webpage should show the actors "<firstname>" and "<lastname>"
    Examples:
      | actorID | firstname | lastname |
      | 1       | PENELOPE | GUINESS |
      | 5       | JOHNNY   | LOLLOBRIGIDA|
      | 10      | BABA     | ISYOU       |

