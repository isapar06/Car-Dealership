package mod;

import java.util.ArrayList;

//This class holds a list of cars
public class Cars {

	//This is the instance variable for the list
	private ArrayList<Car> _lst;
	
	// Getter for the list
	public ArrayList<Car> getList() { return _lst; }
	//getter for specific car
	public Car getBankAccount(int ind) { return _lst.get(ind); }
	
	// A constructor that will get the list from somewhere else
	public Cars(ArrayList<Car> lst) {
		_lst = lst;
	}
}
