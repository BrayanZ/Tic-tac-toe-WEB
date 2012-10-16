(ns web-tic-tac-toe.view.view-helpers-spec
  (:use 
    [speclj.core]
    [web-tic-tac-toe.view.view-helpers]
    [tic-tac-toe.core]))

(describe
  "view-helpers"
  (it "gets the button for empty cell"
      (should= [:a.btn " "] (get_cell nil)))
  (it "gets the value of the cell when not empty"
      (should= [:span.board_cell "X"] (get_cell "X")))
  (it "parses the board to a friendly format"
      (should= "[' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']"
               (parse_board (create_board))))
  (it "parses the board to a friendly format"
      (should= "[' ', ' ', O, ' ', ' ', ' ', ' ', X, ' ']"
               (parse_board [[nil nil "O"][nil nil nil][nil "X" nil]]))))

(run-specs)
