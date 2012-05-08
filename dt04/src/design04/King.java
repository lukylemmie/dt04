package design04;

public class King extends Piece {

	public King(Board board, boolean colour, int position) {
		super(board, colour, position);
		moveLimit = true;
	}

	@Override
	public void updateMoves() {
		cleanMoves();
		checkDirection(position, board.MOVE_UP_LEFT, moveLimit);
		checkDirection(position, board.MOVE_UP, moveLimit);
		checkDirection(position, board.MOVE_UP_RIGHT, moveLimit);
		checkDirection(position, board.MOVE_LEFT, moveLimit);
		checkDirection(position, board.MOVE_RIGHT, moveLimit);
		checkDirection(position, board.MOVE_DOWN_LEFT, moveLimit);
		checkDirection(position, board.MOVE_DOWN, moveLimit);
		checkDirection(position, board.MOVE_DOWN_RIGHT, moveLimit);
		movesUpdated = true;
	}

	@Override
	public String pieceID() {
		String value;
		
		if(colour == WHITE){
			value = "kl";
		} else {
			value = "kd";
		}
		
		return value;
	}
	
}
