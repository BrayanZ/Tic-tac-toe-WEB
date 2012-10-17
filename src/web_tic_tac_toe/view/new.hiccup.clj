(include-js "/javascript/board.js")
[:h1 "Tic-Tac-Toe"]
[:div {:class "tablero"}
 [:div#endOfGame (get_message  *view-context*)]
 (render-partial "board" :board (get_board *view-context*)) ]
