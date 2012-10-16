(ns web-tic-tac-toe.view.view-helpers
  "Put helper functions for views in this namespace."
  (:use
    [joodo.views :only (render-partial *view-context*)]
    [hiccup.page-helpers]
    [hiccup.form-helpers]))

(defn get_cell [mark]
  (if (nil? mark)
    [:a.btn " "]
    [:span.board_cell mark]))

(defn- change_nil [board]
  (loop [board (flatten board) 
         acc []]
    (let [cell (first board)]
      (cond 
        (empty? board)
          acc
        :else
        (recur (rest board) 
               (conj
                 acc 
                 (if (nil? cell) "' '" cell )))))))

(defn parse_board [board]
  (str "[" (apply str (interpose ", " (change_nil board))) "]"))
