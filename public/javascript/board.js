var board = null;
function send_move(row, column, board)
{
  board = load_board();

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
      $(".tablero").html($(data).find(".tablero").html());
      if($(".tablero #endOfGame").text() != ""){
        $(".tablero td a").hide();
        $(".tablero").append("<div class='row span12'><a href='/game' class='btn btn-primary'> Volver a Jugar </a> </div>");
      }
    },
    error: function(xhr, ts, e){
      alert(ts + ": " + e);
    }
  });
};

function load_board()
{
  board = [];
  $(".tablero td a, .tablero td span").each(function(){
    board.push($(this).text());
  });
  return board;
}

jQuery(document).ready(function($){
  $(".table a").live("click",function(){
    var column = $(this).parent();
    var row = column.parent();
    var row_num = $(".table tr").index(row);
    var col_num = row.find("td").index(column);
    send_move(row_num, col_num, board);
  });
})
