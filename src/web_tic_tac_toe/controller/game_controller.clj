(ns web-tic-tac-toe.controller.game-controller 
  (:require [compojure.core :refer [GET POST PUT context defroutes]]
            [joodo.views :refer [render-template render-html]]
            [tic-tac-toe.core :refer [create_board human_move]]))

(defn- init_game []
  (let [board (create_board)]
    (render-template "new" :board board :current_player "Jugador 1")))

(defn- move [board [row column :as position] mark]
  (println board)
   (let [board (human_move board position mark)]
     (render-template "new" :board board :current_player "Jugador 2")
     )
  )

(defroutes game-controller
           (GET "/game" [] (init_game))
           (PUT "/move" {params :params} (move (:board params) [(:row params) (:column params)] (:mark params)))
           (GET "/about" [] (render-template "about"))
           )
