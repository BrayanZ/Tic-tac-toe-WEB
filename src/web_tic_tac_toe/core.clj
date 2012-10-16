(ns web-tic-tac-toe.core
  (:use
    [compojure.core :only (defroutes GET PUT)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]))

(defroutes web-tic-tac-toe-routes
  (GET "/" [] (render-template "index"))
  (controller-router 'web-tic-tac-toe.controller)
  (not-found (render-template "not_found" :template-root "web_tic_tac_toe/view" :ns `web-tic-tac-toe.view.view-helpers)))

(def app-handler
  (->
    web-tic-tac-toe-routes
    (wrap-view-context :template-root "web_tic_tac_toe/view" :ns `web-tic-tac-toe.view.view-helpers)))


