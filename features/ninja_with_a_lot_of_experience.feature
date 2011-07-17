Feature: Learning path
  Ninjas learn a lot of diferents technics

  Scenario: Fully armed
    Given a ninja with the following experience
      | belt_level | katana | sake  | fought  | magic |
      | third      | two    | three | samurai | five  |
    When attacked by a samurai
    Then the ninja should engage the opponent
