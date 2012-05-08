package design04;

public class Rook extends Piece {

	public Rook(Board board, boolean colour, int position) {
		super(board, colour, position);
		moveLimit = false;
	}

	@Override
	public void updateMoves() {
		cleanMoves();
		checkDirection(position, board.MOVE_UP, moveLimit);
		checkDirection(position, board.MOVE_LEFT, moveLimit);
		checkDirection(position, board.MOVE_RIGHT, moveLimit);
		checkDirection(position, board.MOVE_DOWN, moveLimit);
		movesUpdated = true;
	}

	@Override
	public String pieceID() {
		String value;
		
		if(colour == WHITE){
			value = "rl";
		} else {
			value = "rd";
		}
		
		return value;
	}

}
