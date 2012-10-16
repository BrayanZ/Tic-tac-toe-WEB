(include-js "/javascript/board.js")
[:h1 "Tic-Tac-Toe"]
[:div {:class "tablero"} [:div#endOfGame (:message *view-context*)] (render-partial "board" :board (:board *view-context*)) ]
