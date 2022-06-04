package mod;

import java.util.ArrayList;

public class Overseer {

	ArrayList<Car> lst = new ArrayList<Car>();
	
	//constructor which creates a car list and prints a welcome message for the user
	public Overseer() {
		Cars cars = new Cars(carList());
		Msg.msg("Welcome to CAR DEALERSHIP!");
		options();
	}
	
	//Gives user options as to what they could do with the cars
	public void options() {
		String[] options = {"view all available car models", "view specific car model", "remove a color", "remove a package type", "remove a car", "add a car", "exit"};
		int opts = 0;
		opts = Msg.opt(options, "What would you like to do: ", "DEALERSHIP");
		if (opts == 0) {
			viewAllCars();
		}
		if (opts == 1) {
			viewByModel();
		}
		if (opts == 2) {
			removeColor();
		}
		if (opts == 3) {
			removePackage();
		}
		if (opts == 4) {
			removeCar();
		}
		if (opts == 5) {
			addCar();
		}
		if (opts == 6) {
			exit();
		}
	}
	
	//allows user to view all car models
	public void viewAllCars() {
		String DISPLAY = "";
		DISPLAY += "MODEL:    AMOUNT \n\n";
		int sum0 = 0; int sum1 = 0; int sum2 = 0; int sum3 = 0; int sum4 = 0;
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).getModel().equals("Ford Mustang")) 
				sum0 += lst.get(i).getAmt();
			else if (lst.get(i).getModel().equals("Honda Accord"))
				sum1 += lst.get(i).getAmt();
			else if (lst.get(i).getModel().equals("Toyota Camry"))
				sum2 += lst.get(i).getAmt();
			else if (lst.get(i).getModel().equals("Jeep Grand Cherokee"))
				sum3 += lst.get(i).getAmt();
			else if (lst.get(i).getModel().equals("Subaru Outback"))
				sum4 += lst.get(i).getAmt();
		}
		DISPLAY += "Ford Mustang: " + sum0 + "\n";
		DISPLAY += "Honda Accord: " + sum1 + "\n";
		DISPLAY += "Toyota Camry: " + sum2 + "\n";
		DISPLAY += "Jeep Grand Cherokee: " + sum3 + "\n";
		DISPLAY += "Subaru Outback: " + sum4 + "\n";
		Msg.msg(DISPLAY);
		options();
	}
	
	//allows user to view cars by model
	public void viewByModel() {
		String s = Msg.in("MODELS: \nFord Mustang \nHonda Accord \nToyota Camry \nJeep Grand Cherokee \nSubaru Outback \n\nType in the model you would like to view: ");
		String DISPLAY = "All the cars for model: " + s + "\n\n";
		if (s.equals("Ford Mustang") || s.equals("Honda Accord") || s.equals("Toyota Camry") || s.equals("Jeep Grand Cherokee") || s.equals("Subaru Outback")) {
			for (int i = 0; i < lst.size(); i++) {
				if (s.equals(lst.get(i).getModel())) {
					DISPLAY += "- COLOR: " + lst.get(i).getColor() + "     PACKAGE: " + lst.get(i).getPackage() + "\n";
				}
			}
			Msg.msg(DISPLAY);
			options();
		}
		else {
			Msg.msg("THAT INPUT IS INCORRECT \nPLEASE TRY AGAIN");
			viewByModel();
		}
	}
	
	//allows user to remove a specific car color from each model
	public void removeColor() {
		String s = Msg.in("COLORS: \n - red \n - blue \n - purple \n - black \n - silver \n - white \n\nType in the color you would like to remove: ");
		int cnt = 0;
		for (int i = 0; i < lst.size(); i++) {
			if (s.equals(lst.get(i).getColor())) {
				cnt++;
			}
		}
		if (cnt == 0) {
			Msg.msg("THAT COLOR ISNT AVAILABLE \nPLEASE TRY AGAIN");
			removeColor();
		}
		else {
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).getColor().equals(s)) {
					lst.remove(i);
				}
			}
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).getColor().equals(s)) {
					lst.remove(i);
				}
			}
			Msg.msg("YOUR COLOR HAS BEEN SUCCESSFULLY DELETED.");
			options();
		}
	}
	
	//allows user to remove a package type
	public void removePackage() {
		String s = Msg.in("PACKAGE TYPES: \n - standard \n - deluxe \n - premium \n\nType in the package type you would like to remove: ");
		int cnt = 0;
		for (int i = 0; i < lst.size(); i++) {
			if (s.equals(lst.get(i).getPackage())) {
				cnt++;
			}
		}
		if (cnt == 0) {
			Msg.msg("THAT PACKAGE TYPE ISNT AVAILABLE \nPLEASE TRY AGAIN");
			removePackage();
		}
		else {
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).getPackage().equals(s)) {
					lst.remove(i);
				}
			}
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).getPackage().equals(s)) {
					lst.remove(i);
				}
			}
			Msg.msg("YOUR PACKAGE TYPE HAS BEEN SUCCESSFULLY DELETED.");
			options();
		}
	}
	
	//allows user to remove a specific car
	public void removeCar() {
		String m = Msg.in("MODELS: \nFord Mustang \nHonda Accord \nToyota Camry \nJeep Grand Cherokee \nSubaru Outback \n\nType in the model you would like to remove: ");
		String c = Msg.in("COLORS: \n - red \n - blue \n - purple \n - black \n - silver \n - white \n\nType in the color you would like to remove: ");
		String p = Msg.in("PACKAGE TYPES: \n - standard \n - deluxe \n - premium \n\nType in the package type you would like to remove: ");
		int cnt = 0;
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).getModel().equals(m)) {
				if (c.equals(lst.get(i).getColor())) {
					if (lst.get(i).getPackage().equals(p)) {
						cnt++;
					}
				}
			}
		}
		if (cnt == 0) {
			Msg.msg("THAT CAR ISNT AVAILABLE \nPLEASE TRY AGAIN");
			removeCar();
		}
		else {
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).getModel().equals(m)) {
					if (c.equals(lst.get(i).getColor())) {
						if (lst.get(i).getPackage().equals(p)) {
							lst.remove(i);
						}
					}
				}
			}
			Msg.msg("YOUR CAR HAS BEEN SUCCEFULLY REMOVED.");
			options();
		}
		
	}
	
	//allows user to add any car they want (that already exists in the program)
	public void addCar() {
		String m = Msg.in("MODELS: \nFord Mustang \nHonda Accord \nToyota Camry \nJeep Grand Cherokee \nSubaru Outback \n\nType in the model you would like to add: ");
		String c = Msg.in("COLORS: \n - red \n - blue \n - purple \n - black \n - silver \n - white \n\nType in the color you would like to add: ");
		String p = Msg.in("PACKAGE TYPES: \n - standard \n - deluxe \n - premium \n\nType in the package type you would like to add: ");
		int cnt = 0;
		if (m.equals("Ford Mustang") || m.equals("Honda Accord") || m.equals("Toyota Camry") || m.equals("Jeep Grand Cherokee") || m.equals("Subaru Outback")) {
			if (c.equals("red") || c.equals("blue") || c.equals("purple") || c.equals("black") || c.equals("silver") || c.equals("white")) {
				if (p.equals("standard") || p.equals("deluxe") || p.equals("premium")) {
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			Msg.msg("THAT CAR ISNT AVAILABLE \nPLEASE TRY AGAIN");
			addCar();
		}
		else {
			lst.add(new Car(m, c, p, 1));

			Msg.msg("YOUR CAR HAS BEEN SUCCEFULLY ADDED.");
			options();
		}
	}
	
	//allows user to exit program
	public void exit() {
		Msg.msg("THANK YOU FOR USING ISA'S DEALERSHIP \nGOODBYE!");
	}
	
	//adds all cars to the list
	public ArrayList<Car> carList() {
		lst.add(new Car("Ford Mustang", "red", "standard", 1));
		lst.add(new Car("Ford Mustang", "red", "deluxe", 1));
		lst.add(new Car("Ford Mustang", "red", "premium", 1));
		lst.add(new Car("Ford Mustang", "blue", "standard", 1));
		lst.add(new Car("Ford Mustang", "blue", "deluxe", 1));
		lst.add(new Car("Ford Mustang", "blue", "premium", 1));
		lst.add(new Car("Ford Mustang", "purple", "standard", 1));
		lst.add(new Car("Ford Mustang", "purple", "deluxe", 1));
		lst.add(new Car("Ford Mustang", "purple", "premium", 1));
		lst.add(new Car("Ford Mustang", "black", "standard", 1));
		lst.add(new Car("Ford Mustang", "black", "deluxe", 1));
		lst.add(new Car("Ford Mustang", "black", "premium", 1));
		lst.add(new Car("Ford Mustang", "silver", "standard", 1));
		lst.add(new Car("Ford Mustang", "silver", "deluxe", 1));
		lst.add(new Car("Ford Mustang", "silver", "premium", 1));
		lst.add(new Car("Ford Mustang", "white", "standard", 1));
		lst.add(new Car("Ford Mustang", "white", "deluxe", 1));
		lst.add(new Car("Ford Mustang", "white", "premium", 1));
		
		lst.add(new Car("Honda Accord", "red", "standard", 1));
		lst.add(new Car("Honda Accord", "red", "deluxe", 1));
		lst.add(new Car("Honda Accord", "red", "premium", 1));
		lst.add(new Car("Honda Accord", "blue", "standard", 1));
		lst.add(new Car("Honda Accord", "blue", "deluxe", 1));
		lst.add(new Car("Honda Accord", "blue", "premium", 1));
		lst.add(new Car("Honda Accord", "purple", "standard", 1));
		lst.add(new Car("Honda Accord", "purple", "deluxe", 1));
		lst.add(new Car("Honda Accord", "purple", "premium", 1));
		lst.add(new Car("Honda Accord", "black", "standard", 1));
		lst.add(new Car("Honda Accord", "black", "deluxe", 1));
		lst.add(new Car("Honda Accord", "black", "premium", 1));
		lst.add(new Car("Honda Accord", "silver", "standard", 1));
		lst.add(new Car("Honda Accord", "silver", "deluxe", 1));
		lst.add(new Car("Honda Accord", "silver", "premium", 1));
		lst.add(new Car("Honda Accord", "white", "standard", 1));
		lst.add(new Car("Honda Accord", "white", "deluxe", 1));
		lst.add(new Car("Honda Accord", "white", "premium", 1));
		
		lst.add(new Car("Toyota Camry", "red", "standard", 1));
		lst.add(new Car("Toyota Camry", "red", "deluxe", 1));
		lst.add(new Car("Toyota Camry", "red", "premium", 1));
		lst.add(new Car("Toyota Camry", "blue", "standard", 1));
		lst.add(new Car("Toyota Camry", "blue", "deluxe", 1));
		lst.add(new Car("Toyota Camry", "blue", "premium", 1));
		lst.add(new Car("Toyota Camry", "purple", "standard", 1));
		lst.add(new Car("Toyota Camry", "purple", "deluxe", 1));
		lst.add(new Car("Toyota Camry", "purple", "premium", 1));
		lst.add(new Car("Toyota Camry", "black", "standard", 1));
		lst.add(new Car("Toyota Camry", "black", "deluxe", 1));
		lst.add(new Car("Toyota Camry", "black", "premium", 1));
		lst.add(new Car("Toyota Camry", "silver", "standard", 1));
		lst.add(new Car("Toyota Camry", "silver", "deluxe", 1));
		lst.add(new Car("Toyota Camry", "silver", "premium", 1));
		lst.add(new Car("Toyota Camry", "white", "standard", 1));
		lst.add(new Car("Toyota Camry", "white", "deluxe", 1));
		lst.add(new Car("Toyota Camry", "white", "premium", 1));
		
		lst.add(new Car("Jeep Grand Cherokee", "red", "standard", 1));
		lst.add(new Car("Jeep Grand Cherokee", "red", "deluxe", 1));
		lst.add(new Car("Jeep Grand Cherokee", "red", "premium", 1));
		lst.add(new Car("Jeep Grand Cherokee", "blue", "standard", 1));
		lst.add(new Car("Jeep Grand Cherokee", "blue", "deluxe", 1));
		lst.add(new Car("Jeep Grand Cherokee", "blue", "premium", 1));
		lst.add(new Car("Jeep Grand Cherokee", "purple", "standard", 1));
		lst.add(new Car("Jeep Grand Cherokee", "purple", "deluxe", 1));
		lst.add(new Car("Jeep Grand Cherokee", "purple", "premium", 1));
		lst.add(new Car("Jeep Grand Cherokee", "black", "standard", 1));
		lst.add(new Car("Jeep Grand Cherokee", "black", "deluxe", 1));
		lst.add(new Car("Jeep Grand Cherokee", "black", "premium", 1));
		lst.add(new Car("Jeep Grand Cherokee", "silver", "standard", 1));
		lst.add(new Car("Jeep Grand Cherokee", "silver", "deluxe", 1));
		lst.add(new Car("Jeep Grand Cherokee", "silver", "premium", 1));
		lst.add(new Car("Jeep Grand Cherokee", "white", "standard", 1));
		lst.add(new Car("Jeep Grand Cherokee", "white", "deluxe", 1));
		lst.add(new Car("Jeep Grand Cherokee", "white", "premium", 1));
		
		lst.add(new Car("Subaru Outback", "red", "standard", 1));
		lst.add(new Car("Subaru Outback", "red", "deluxe", 1));
		lst.add(new Car("Subaru Outback", "red", "premium", 1));
		lst.add(new Car("Subaru Outback", "blue", "standard", 1));
		lst.add(new Car("Subaru Outback", "blue", "deluxe", 1));
		lst.add(new Car("Subaru Outback", "blue", "premium", 1));
		lst.add(new Car("Subaru Outback", "purple", "standard", 1));
		lst.add(new Car("Subaru Outback", "purple", "deluxe", 1));
		lst.add(new Car("Subaru Outback", "purple", "premium", 1));
		lst.add(new Car("Subaru Outback", "black", "standard", 1));
		lst.add(new Car("Subaru Outback", "black", "deluxe", 1));
		lst.add(new Car("Subaru Outback", "black", "premium", 1));
		lst.add(new Car("Subaru Outback", "silver", "standard", 1));
		lst.add(new Car("Subaru Outback", "silver", "deluxe", 1));
		lst.add(new Car("Subaru Outback", "silver", "premium", 1));
		lst.add(new Car("Subaru Outback", "white", "standard", 1));
		lst.add(new Car("Subaru Outback", "white", "deluxe", 1));
		lst.add(new Car("Subaru Outback", "white", "premium", 1));

		return lst;
	}
 }
