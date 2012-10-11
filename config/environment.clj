(use 'joodo.env)

(def environment {
  :joodo.core.namespace "web-tic-tac-toe.core"
  ; environment settings go here
  })

(swap! *env* merge environment)