package mod;

//This class contains the elements of a singular car
public class Car {
	
	//These are the instance variables that represent each element
	private String model;
	private String color;
	private String cPack; 
	private int amt;
	
	//These are the getters and setters for each element
	public String getModel() {return model;}
	public String getColor() {return color;}
	public String getPackage() {return cPack;}
	public int getAmt() {return amt;}
	public int addToAmt(int x) {return amt + x;}
	public int subFromAmt(int x) {return amt - x;}
	
	//This is the constructor which is used to create a new car
	public Car(String m, String c, String p, int a) {
		model = m;
		color = c;
		cPack = p;
		amt = a;
	}
}
