package design04;

public class Pawn extends Piece {

	public Pawn(Board board, boolean colour, int position) {
		super(board, colour, position);
		
		
	}

	@Override
	public void updateMoves() {
		cleanMoves();
		checkMovement();
		movesUpdated = true;
	}
	
	private void checkMovement(){
		int positionPrime;
		
		positionPrime = position + Board.MOVE_UP;
		if(colour == WHITE){
			positionPrime = position + Board.MOVE_UP;
			if(!board.onBoardEdge(positionPrime) &&	
			   board.getPosition(positionPrime) == null){
				validMoves[positionPrime] = true;
			}
			
			positionPrime = position + Board.MOVE_UP_LEFT;
			checkCapture(positionPrime);
			positionPrime = position + Board.MOVE_UP_RIGHT;
			checkCapture(positionPrime);
		}
		
		positionPrime = position + Board.MOVE_DOWN;
		if(colour == BLACK){
			if(!board.onBoardEdge(positionPrime) &&
			   board.getPosition(positionPrime) == null){
				validMoves[positionPrime] = true;
			}

			positionPrime = position + Board.MOVE_DOWN_LEFT;
			checkCapture(positionPrime);
			positionPrime = position + Board.MOVE_DOWN_RIGHT;
			checkCapture(positionPrime);
		}
	}
	
	private void checkCapture(int positionPrime){
		if(!board.onBoardEdge(positionPrime)){
			validCapture[positionPrime] = true;
			board.updateCaptureMoves(positionPrime, colour);
			if(board.getPosition(positionPrime) != null &&
			   board.getPosition(positionPrime).colour != colour){
				validMoves[positionPrime] = true;
			}
		}
	}

	@Override
	public String pieceID() {
		String value;
		
		if(colour == WHITE){
			value = "pl";
		} else {
			value = "pd";
		}
		
		return value;
	}

}
