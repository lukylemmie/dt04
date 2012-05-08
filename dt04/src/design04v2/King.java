package design04;

public class King extends Piece {

	public King(Board board, boolean colour, int position) {
		super(board, colour, position);
		moveLimit = true;
	}

	@Override
	public void updateMoves() {
		cleanMoves();
		checkDirection(position, Board.MOVE_UP_LEFT, moveLimit);
		checkDirection(position, Board.MOVE_UP, moveLimit);
		checkDirection(position, Board.MOVE_UP_RIGHT, moveLimit);
		checkDirection(position, Board.MOVE_LEFT, moveLimit);
		checkDirection(position, Board.MOVE_RIGHT, moveLimit);
		checkDirection(position, Board.MOVE_DOWN_LEFT, moveLimit);
		checkDirection(position, Board.MOVE_DOWN, moveLimit);
		checkDirection(position, Board.MOVE_DOWN_RIGHT, moveLimit);
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
