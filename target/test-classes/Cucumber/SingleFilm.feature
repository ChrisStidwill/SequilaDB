Feature: get a specific film

  Scenario Outline: User wants to get a specific film from db.
    Given a film exists in the db with ID <filmID>
    When I request that film's details
    Then The webpage should show the film's "<title>", "<description>", and "<duration>"
    Examples:
      | filmID | title | description | duration |
      | 1       | ACADEMY DINOSAUR | A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies |   86       |
      | 5       | AFRICAN EGG   | A Fast-Paced Documentary of a Pastry Chef And a Dentist who must Pursue a Forensic Psychologist in The Gulf of Mexico|   130   |
      | 10      | ALADDIN CALENDAR     | A Action-Packed Tale of a Man And a Lumberjack who must Reach a Feminist in Ancient China       |   63   |

