package design04;

public class TestQueen {
	public static void main(String[] args){
		boolean assess = true;
		System.out.println("White Queen:");
		assess &= test01();
		assess &= test02();
		assess &= test03();
		assess &= test04();
		System.out.println("Black Queen:");
		assess &= test05();
		assess &= test06();
		assess &= test07();
		assess &= test08();
		
		if(assess){
			System.out.println("All tests passed! You are AWESOME!");
		}
	}
	
	private static boolean[] convertArray(boolean[] input){
		boolean[] output = new boolean[Board.ARRAY_SIZE];
		int pointer = 0;
		
		for(int i = 0; i < Board.ARRAY_SIZE; i++){
			if(i % Board.DIMENSION == Board.LEFT_EDGE || i % Board.DIMENSION == Board.RIGHT_EDGE || 
			   i < Board.DIMENSION || i >= Board.ARRAY_SIZE - Board.DIMENSION){
				output[i] = false;
			} else {
				output[i] = input[pointer];
				pointer++;
			}
		}
		
		return output;
	}
	
	private static boolean test01(){
		boolean pass = true;
		System.out.println("Test01 - Testing open board movement: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |  |  |ql|  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {true, false, false, true, false, false, true, false,
		          false, true, false, true, false, true, false, false,
		          false, false, true, true, true, false, false, false,
		          true, true, true, false, true, true, true, true, 
		          false, false, true, true, true, false, false, false,
		          false, true, false, true, false, true, false, false, 
		          true, false, false, true, false, false, true, false, 
		          false, false, false, true, false, false, false, true};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canMoveTo(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test02(){
		boolean pass = true;
		System.out.println("Test02 - testing same colour obstacles: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |nl|  |nl|  |nl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |ql|  |ql|  |pl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |pl|  |pl|  |pl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {false, false, false, false, false, false, false, false,
		          false, false, false, false, false, false, false, false,
		          false, false, true, true, true, false, false, false,
		          false, false, true, false, true, false, false, false, 
		          false, false, true, true, true, false, false, false,
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canMoveTo(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test03(){
		boolean pass = true;
		System.out.println("Test03 - testing off colour obstacles: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |nd|  |nd|  |nd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |qd|  |ql|  |pd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |pd|  |pd|  |pd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {false, false, false, false, false, false, false, false,
		          false, true, false, true, false, true, false, false,
		          false, false, true, true, true, false, false, false,
		          false, true, true, false, true, true, false, false, 
		          false, false, true, true, true, false, false, false,
		          false, true, false, true, false, true, false, false, 
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canMoveTo(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test04(){
		boolean pass = true;
		System.out.println("Test04 - testing protected obstacles: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |nl|  |nl|  |nl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |ql|  |ql|  |pl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |pl|  |pl|  |pl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {false, false, false, false, false, false, false, false,
		          false, true, false, true, false, true, false, false,
		          false, false, true, true, true, false, false, false,
		          false, true, true, false, true, true, false, false, 
		          false, false, true, true, true, false, false, false,
		          false, true, false, true, false, true, false, false, 
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canCapture(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test05(){
		boolean pass = true;
		System.out.println("Test05 - Testing open board movement: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |  |  |qd|  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {true, false, false, true, false, false, true, false,
		          false, true, false, true, false, true, false, false,
		          false, false, true, true, true, false, false, false,
		          true, true, true, false, true, true, true, true, 
		          false, false, true, true, true, false, false, false,
		          false, true, false, true, false, true, false, false, 
		          true, false, false, true, false, false, true, false, 
		          false, false, false, true, false, false, false, true};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canMoveTo(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test06(){
		boolean pass = true;
		System.out.println("Test06 - testing same colour obstacles: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |nd|  |nd|  |nd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |qd|  |qd|  |pd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |pd|  |pd|  |pd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {false, false, false, false, false, false, false, false,
		          false, false, false, false, false, false, false, false,
		          false, false, true, true, true, false, false, false,
		          false, false, true, false, true, false, false, false, 
		          false, false, true, true, true, false, false, false,
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canMoveTo(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test07(){
		boolean pass = true;
		System.out.println("Test07 - testing off colour obstacles: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |nl|  |nl|  |nl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |ql|  |qd|  |pl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |pl|  |pl|  |pl|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {false, false, false, false, false, false, false, false,
		          false, true, false, true, false, true, false, false,
		          false, false, true, true, true, false, false, false,
		          false, true, true, false, true, true, false, false, 
		          false, false, true, true, true, false, false, false,
		          false, true, false, true, false, true, false, false, 
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canMoveTo(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
	
	private static boolean test08(){
		boolean pass = true;
		System.out.println("Test08 - testing protected obstacles: ");
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |nd|  |nd|  |nd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |qd|  |qd|  |pd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |pd|  |pd|  |pd|  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		boolean[] validArray = 
				 {false, false, false, false, false, false, false, false,
		          false, true, false, true, false, true, false, false,
		          false, false, true, true, true, false, false, false,
		          false, true, true, false, true, true, false, false, 
		          false, false, true, true, true, false, false, false,
		          false, true, false, true, false, true, false, false, 
		          false, false, false, false, false, false, false, false, 
		          false, false, false, false, false, false, false, false};
		
		validArray = convertArray(validArray);
		Board board = new Board(boardString);
		
		for(int i = 0; i < Board.NUMBER_OF_SQUARES; i++){
			if(!(board.getPosition(44).canCapture(i) == validArray[i])){
				pass = false;
			}
		}
		
		if(pass){
			System.out.println("Passed (pieceID: " + board.getPosition(44).pieceID() + ")");
		} else {
			System.out.println("Failed (pieceID: " + board.getPosition(44).pieceID() + ")");
		}
		return pass;
	}
}
