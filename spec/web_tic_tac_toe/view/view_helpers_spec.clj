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
               (parse_board [[nil nil "O"][nil nil nil][nil "X" nil]])))
  (it "returns the board"
      (def view_context {:presenter {:board [[nil nil "O"][nil nil nil][nil "X" nil]]}})
      (should= [[nil nil "O"][nil nil nil][nil "X" nil]]
               (get_board view_context)))
  (it "returns the message"
      (def view_context {:presenter {:message "test_message"}})
      (should= "test_message"
               (get_message view_context)))
  )

(run-specs)
