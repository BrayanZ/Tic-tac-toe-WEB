(ns web-tic-tac-toe.helper.game-helper-spec
  (:use
    [speclj.core]
    [web-tic-tac-toe.helper.game-helper]
    [tic-tac-toe.core]))

(describe 
  "game-helper"
  (it "parses Json to vector"
      (should= 
        ["\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \""] 
        (parseJsonToVector "[\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \"]")))

  (it "replaces the spaces for nils"
      (should= [nil nil nil nil nil nil nil nil nil]
               (replaceSpacesForNils ["\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \"" "\" \""])))

  (it "gets a valid board from Json"
      (should= [[nil nil nil] [nil nil nil] [nil nil nil]]
              (getValidBoardFromJson "[\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \"]")))

  (it "returns a board after apply a move"
      (should= [[nil "X" nil][nil nil nil][nil nil nil]]
               (applyMove "[\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \"]" [0 1] "X")))
  )

