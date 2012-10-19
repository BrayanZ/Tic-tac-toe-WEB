describe("Board", function() {
  beforeEach(function() {
    setFixtures(
      "<div class='tablero'>" +
      "<table class='table table-bordered table-condensed span3'>" +
      "<tbody>" +
      "<tr>" +
      "<td> <a class='btn'> </a> </td>" +
      "<td><a class='btn'> </a></td>" +
      "<td><span class='board_cell'>X</span></td>" +
      "</tr>" +
      "<tr>" +
      "<td><a class='btn'> </a></td>" +
      "<td><span class='board_cell'>X</span></td>" +
      "<td><a class='btn'> </a></td></tr>" +
      "<tr>" +
      "<td><span class='board_cell'>O</span></td>" +
      "<td><a class='btn'> </a></td>" +
      "<td><span class='board_cell'>O</span></td>" +
      "</tr>" +
      "</tbody>" +
      "</table>" +
      "</div>"
    );
  });

  describe ("load_board", function() {

    it("returns an array with the board", function() {
      var board = load_board();
      var expected_board = [" ", " ", "X", " ", "X", " ", "O", " ", "O"];
      expect(board).toEqual(expected_board);
    });
  });

  describe("send_move", function() {
    beforeEach(function(){
      spyOn($, "ajax").andCallFake(function(e) {
        e.success({});
      });
      end_game = jasmine.createSpy();
    });

    it("calls end_game ", function() {
      send_move(0,0);
      expect(end_game).toHaveBeenCalled();
    });
  })

})
