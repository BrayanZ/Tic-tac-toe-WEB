[:table {:class "table table-bordered table-condensed span3"}
 (let [board (:board *view-context*)]
   (for [row board]
     [:tr
      (for [cell row]
        [:td (get_cell cell) ])]))]
