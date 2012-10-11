(ns web-tic-tac-toe.controller.game-controller-spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [web-tic-tac-toe.controller.game-controller]
    [tic-tac-toe.core]))

(describe
  "game-controller"
  (with-mock-rendering)
  (with-routes game-controller)

  (it "redirects to the game page"
      (let [result (do-get "/game")]
        (should= 200 (:status result))
        (should= "new" @rendered-template)))

  (it "redirects to the post action"
      (let [result (request :put "/move" :params {:row 1 :column 2 :board (create_board) :mark "X"})]
        (should= 200 (:status result))
        (should= "new" @rendered-template)))

  (it "redirects to the about page"
      (let [result (do-get "/about")]
        (should= 200 (:status result))
        (should= "about" @rendered-template)))
)

(run-specs)
