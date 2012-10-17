[:table {:class "table table-bordered table-condensed span3"}
 (let [board (get_board *view-context*)]
   (for [row board]
     [:tr
      (for [cell row]
        [:td (get_cell cell) ])]))]
