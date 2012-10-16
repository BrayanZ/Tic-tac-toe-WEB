(ns web-tic-tac-toe.controller.game-controller 
  (:require [compojure.core :refer [GET POST PUT context defroutes]]
            [joodo.views :refer [render-template render-html render-partial]]
            [tic-tac-toe.core :refer [create_board human_move winner? full_board?]]
            [tic-tac-toe.IA :refer [IA_move]]
            [clojure.string :refer [split]]
            [web-tic-tac-toe.helper.game-helper :refer :all]
            [web-tic-tac-toe.view.view-helpers :refer :all]))

(defn- init_game []
  (let [board (create_board)]
    (render-template "new" :board board :current_player "Jugador 1")))

(defn- move [board [row column :as position] mark]
  (let [board (applyMove board position mark)]
    (cond 
      (winner? board)
      (render-template "new" :board board :message "<h1>Ganador el Jugador 1</h1>" )
      (full_board? board)
      (render-template "new" :board board :message "<h1>Felicidades, ha obtenido un empate</h1>")
      :else
      (let [board (IA_move board "O")]
        (cond
          (winner? board)
            (render-template "new" :board board :message "<h1>Ganador el Jugador 2</h1>" )
          (full_board? board)
            (render-template "new" :board board :message "<h1>Felicidades, ha obtenido un empate</h1>")
          :else
            (render-template "new" :board board :current_player "Jugador 1")))))
  )

(defroutes game-controller
           (GET "/game" [] (init_game))
           (POST "/game" {params :params} (move (:board params) [(:row params) (:column params)] (:mark params)))
           )
