(ns web-tic-tac-toe.controller.game-controller 
  (:require [compojure.core :refer [GET POST PUT context defroutes]]
            [joodo.views :refer [render-template render-html render-partial]]
            [tic-tac-toe.core :refer [create_board human_move]]
            [tic-tac-toe.IA :refer [IA_move]]
            [clojure.string :refer [split]]
            [web-tic-tac-toe.interactor.game-interactor :refer :all]
            [web-tic-tac-toe.view.view-helpers :refer :all]))

(def game_board (atom (create_board)))

(defn- init_game []
  (let [board (create_board)]
    (render-template "new" :presenter {:board board :message ""})))

(defn- init_game_IA []
  (let [board (IA_move (create_board) "O")]
    (render-template "new" :presenter {:board board :message ""})))

(defn- move [board [row column :as position] mark]
  (let [board (applyMove board position mark)
        message (move_message board)]
    (if (not= message "")
      (render-template "new" :presenter {:board board :message message})
      (let [board (IA_move board "O")
            message (move_message board)]
        (render-template "new" :presenter {:board board :message message})))))

(defroutes game-controller
           (context "/game" []
                    (GET "/" [] (init_game))
                    (GET "/second" [] (init_game_IA)))
           (POST "/game" {params :params} (move (:board params) [(:row params) (:column params)] (:mark params))))
