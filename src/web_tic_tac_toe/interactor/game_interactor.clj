(ns web-tic-tac-toe.interactor.game-interactor
  (:require [tic-tac-toe.core :refer [create_board human_move winner? full_board?]]
            [clojure.string :refer [split replace]]))

(defn parseJsonToVector [json_board]
  (drop 1 (split json_board #"\,|\[|\]")))

(defn replaceSpacesForNils [board]
  (loop [board board
         new_board []]
    (cond 
      (empty? board)
        new_board
      :else
        (recur (rest board)
               (conj new_board
                     (if (= (first board) "\" \"") 
                       nil
                       (replace (first board) #"\"" "")))))))

(defn getValidBoardFromJson [json_board]
  (let [flatBoard (replaceSpacesForNils (parseJsonToVector json_board))]
    (vector
      (subvec flatBoard 0 3)
      (subvec flatBoard 3 6)
      (subvec flatBoard 6 9))))

(defn applyMove [board [row column :as position] mark]
  (let [row (Integer. row)
        column (Integer. column)
        position [row column]
        board (getValidBoardFromJson board)]
    (human_move board position mark))
  )

(defn move_message [board]
  (let [winner (winner? board)]
    (cond
      (= winner "X")
        "<h1>Ganador el Jugador 1</h1>"
      (= winner "O")
        "<h1>Ganador el Jugador 2</h1>"
      (full_board? board)
        "<h1>Felicidades, ha obtenido un empate</h1>"
      :else
        ""
      )
  ))
