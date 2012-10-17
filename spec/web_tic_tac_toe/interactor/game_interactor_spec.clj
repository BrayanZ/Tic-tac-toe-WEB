(ns web-tic-tac-toe.interactor.game-interactor-spec
  (:use
    [speclj.core]
    [web-tic-tac-toe.interactor.game-interactor]
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
  (it "returns the message when Player 1 won"
      (def board [["X" "O" "X"][nil "X" "O"]["X" nil "O"]])
      (should= "<h1>Ganador el Jugador 1</h1>"
               (move_message board)))
  (it "returns the message when Player 2 won"
      (def board [["O" "X" "O"][nil "O" "X"]["O" nil "X"]])
      (should= "<h1>Ganador el Jugador 2</h1>"
               (move_message board)))
  (it "returns the message when it's a tie"
      (def board [["X" "O" "X"]["O" "X" "O"]["O" "X" "O"]])
      (should= "<h1>Felicidades, ha obtenido un empate</h1>"
               (move_message board)))

  )

