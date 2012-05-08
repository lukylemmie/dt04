package design04;

public class Knight extends Piece {

	public Knight(Board board, boolean colour, int position) {
		super(board, colour, position);
		moveLimit = true;
	}

	@Override
	public void updateMoves() {
		int positionPrime;
		cleanMoves();
		
		positionPrime = position + Board.MOVE_UP;
		if(!board.onBoardEdge(positionPrime)){
			checkDirection(positionPrime, Board.MOVE_UP_LEFT, moveLimit);
			checkDirection(positionPrime, Board.MOVE_UP_RIGHT, moveLimit);
		}
		
		positionPrime = position + Board.MOVE_DOWN;
		if(!board.onBoardEdge(positionPrime)){
			checkDirection(positionPrime, Board.MOVE_DOWN_LEFT, moveLimit);
			checkDirection(positionPrime, Board.MOVE_DOWN_RIGHT, moveLimit);
		}
		
		positionPrime = position + Board.MOVE_LEFT;
		if(!board.onBoardEdge(positionPrime)){
			checkDirection(positionPrime, Board.MOVE_UP_LEFT, moveLimit);
			checkDirection(positionPrime, Board.MOVE_DOWN_LEFT, moveLimit);
		}
		
		positionPrime = position + Board.MOVE_RIGHT;
		if(!board.onBoardEdge(positionPrime)){
			checkDirection(positionPrime, Board.MOVE_UP_RIGHT, moveLimit);
			checkDirection(positionPrime, Board.MOVE_DOWN_RIGHT, moveLimit);
		}

		movesUpdated = true;
	}

	@Override
	public String pieceID() {
		String value;
		
		if(colour == WHITE){
			value = "nl";
		} else {
			value = "nd";
		}
		
		return value;
	}

}
