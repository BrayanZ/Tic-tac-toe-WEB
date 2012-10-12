(ns web-tic-tac-toe.controller.game-controller 
  (:require [compojure.core :refer [GET POST PUT context defroutes]]
            [joodo.views :refer [render-template render-html]]
            [tic-tac-toe.core :refer [create_board human_move]]
            [clojure.string :refer [split]]
            [web-tic-tac-toe.helper.game-helper :refer :all]))

(defn- init_game []
  (let [board (create_board)]
    (render-template "new" :board board :current_player "Jugador 1")))

(defn- move [board [row column :as position] mark]
  (render-template "new" :baord (applyMove board position mark) :current_player "Jugador 1"))

(defroutes game-controller
           (GET "/game" [] (init_game))
           (POST "/game" {params :params} (move (:board params) [(:row params) (:column params)] (:mark params)))
           )
