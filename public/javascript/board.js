var board = null;
function send_move(row, column, board)
{
  var move = {};
  move.row = row;
  move.column = column;
  move.board = JSON.stringify(board);
  move.mark = "X";
  $.ajax({
    type: "POST",
    data: move,
    url: "/game",
    success: function(data){
      alert($(data).find(".tablero").html());
      $(".tablero").html($(data).find(".tablero").html());
    },
    error: function(e){
      alert("error " + e);
    }
  });
};

jQuery(document).ready(function($){
  $(".table a").click(function(){
    var column = $(this).parent();
    var row = column.parent();
    var row_num = $(".table tr").index(row);
    var col_num = row.find("td").index(column);
    send_move(row_num, col_num, board);
  });
})
