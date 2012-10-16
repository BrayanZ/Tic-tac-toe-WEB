(ns web-tic-tac-toe.controller.about-controller-spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [web-tic-tac-toe.controller.about-controller]
    [tic-tac-toe.core]))

(describe
  "about-controller"
  (with-mock-rendering)
  (with-routes about-controller)
  
  (it "redirects to the about page"
    (let [result (do-get "/about")]
      (should= 200 (:status result))
      (should= "about" @rendered-template))
  )
)
