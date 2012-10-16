(ns web-tic-tac-toe.controller.about-controller 
  (:require [compojure.core :refer [GET defroutes]]
            [joodo.views :refer [render-template]]
  )
)


(defroutes about-controller
  (GET "/about" [] (render-template "about")))
