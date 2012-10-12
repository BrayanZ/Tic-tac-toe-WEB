var board = null;
function send_move(row, column, board)
{
  var move = {};
  move.row = row;
  move.column = column;
  move.board = board;
  move.mark = "X";
  move._method = "PUT";
  $.ajax({
    type: "PUT",
    data: move,
    url: "/move",
    success: function(data){
      alert(data);
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
