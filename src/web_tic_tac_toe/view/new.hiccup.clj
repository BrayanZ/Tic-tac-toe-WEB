(include-js "/javascript/board.js")
[:h1 "Nuevo Juego de Tic-Tac-Toe"]
[:h3 "Turno del " (:current_player *view-context*)]
[:div {:class "tablero"} (render-partial "board" :board (:board *view-context*))]
[:script
 (str "board = " (parse_board (:board *view-context*)) ";")
 ]
