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
      (let [result (do-post "/game" :params {:row "1" :column "2" :board "[\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \",\" \"]" :mark "X"})]
        (should= 200 (:status result))
        (should= "new" @rendered-template)))
)

(run-specs)
