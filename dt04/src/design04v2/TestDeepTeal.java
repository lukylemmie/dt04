package design04;

public class TestDeepTeal {
	public static void main(String[] args){
		boolean assess = true;
		System.out.println("Testing blackIsInCheck(): ");
		assess &= test01();
		System.out.println("Testing whiteIsInCheck(): ");
		assess &= test02();
		System.out.println("Testing !blackIsInCheckmate(): ");
		assess &= test03();
		System.out.println("Testing blackIsInCheckmate(): ");
		assess &= test04();
		System.out.println("Testing blackIsInCheckmate()2: ");
		assess &= test05();
		System.out.println("Testing blackIsInCheckmate()3: ");
		assess &= test06();
		System.out.println("Testing whiteCanStalemate(): ");
		assess &= test07();
		System.out.println("Testing whiteCanCheckmate()4: ");
		assess &= test08();
		System.out.println("Testing whiteCanCheckmate()5: ");
		assess &= test09();
		System.out.println("Testing whiteCanCheckmate()6: ");
		assess &= test10();
		
		if(assess){
			System.out.println("All tests passed! You are AWESOME!");
		}
	}
	
	public static boolean test01(){
		boolean pass = false;
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |  |  |ql|  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |kd|  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.blackIsInCheck()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test02(){
		boolean pass = false;
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |  |  |qd|  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |kl|  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.whiteIsInCheck()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test03(){
		boolean pass = false;
		
		String boardString = 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |  |  |ql|  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |kd|  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (!deepBlue.blackIsInCheckMate()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test04(){
		boolean pass = false;
		
		String boardString = 
		         "|  |  |  |rl|  |  |kd|  |=\n" + 
		         "|  |  |  |  |  |pd|pd|pd|=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" +
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.blackIsInCheckMate()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test05(){
		boolean pass = false;
		
		String boardString = 
		         "|rd|  |bd|qd|kd|bd|nd|rd|=\n" + 
		         "|pd|pd|pd|  |  |ql|pd|pd|=\n" + 
		         "|  |  |nd|pd|  |  |  |  |=\n" +
		         "|  |  |  |  |pd|  |  |  |=\n" + 
		         "|  |  |bl|  |pl|  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|pl|pl|pl|pl|  |pl|pl|pl|=\n" + 
		         "|rl|nl|bl|  |kl|  |nl|rl|=\n";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.blackIsInCheckMate()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test06(){
		boolean pass = false;
		
		String boardString = 
		         "|rd|  |bd|  |kd|bd|nd|rd|=\n" + 
		         "|pd|pd|pd|pd|qd|ql|pd|pd|=\n" + 
		         "|  |  |nd|  |  |  |  |  |=\n" +
		         "|  |  |  |  |pd|  |  |  |=\n" + 
		         "|  |  |bl|  |pl|  |  |  |=\n" + 
		         "|  |  |  |  |  |  |  |  |=\n" + 
		         "|pl|pl|pl|pl|  |pl|pl|pl|=\n" + 
		         "|rl|nl|bl|  |kl|  |nl|rl|=\n";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (!deepBlue.blackIsInCheckMate()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test07(){
		boolean pass = false;
		
		String boardString = 
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|kd|  |nl|nl|  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |nl|  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |kl|  |  |";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.whiteCanMateInOneMove()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test08(){
		boolean pass = false;
		
		String boardString = 
	            "|kl|  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|kd|  |nl|nl|  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |nl|  |  |  |  |  |=\n"+
	            "|  |  |  |  |rl|  |  |  |";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.whiteCanMateInOneMove()){
			pass = true;
		} else {
			pass = false;
		}
		
		deepBlue.makeWhiteMateMove();
		
		if (deepBlue.blackIsInCheck()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test09(){
		boolean pass = false;
		
		String boardString = 
	            "|kl|  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |rl|=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|kd|  |nl|nl|  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |nl|  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.whiteCanMateInOneMove()){
			pass = true;
		} else {
			pass = false;
		}
		
		deepBlue.makeWhiteMateMove();
		
		if (deepBlue.blackIsInCheck()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
	
	public static boolean test10(){
		boolean pass = false;
		
		String boardString = 
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |rl|=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|kd|  |nl|nl|  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |  |=\n"+
	            "|  |  |nl|  |  |  |  |  |=\n"+
	            "|  |  |  |  |  |  |  |kl|";
		
		DeepTeal deepBlue = new DeepTeal(boardString);
		
		if (deepBlue.whiteCanMateInOneMove()){
			pass = true;
		} else {
			pass = false;
		}
		
		deepBlue.makeWhiteMateMove();
		
		if (deepBlue.blackIsInCheck()){
			pass = true;
		} else {
			pass = false;
		}
		
		if(pass){
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		return pass;
	}
}
