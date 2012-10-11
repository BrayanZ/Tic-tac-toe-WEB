(ns web-tic-tac-toe.core-spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [web-tic-tac-toe.core]))

(describe "web-tic-tac-toe"

  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles home page"
    (let [result (do-get "/")]
      (should= 200 (:status result))
      (should= "index" @rendered-template)))
  )

(run-specs)
