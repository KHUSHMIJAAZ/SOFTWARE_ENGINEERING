import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/*CLASS HOUSE HAVE THE FOLLOWING ATTRIBUTES BELOW*/
public class House{
	private String houseID;
	private String houseAddress;
	private String houseType;
	private double housePrice;
	private int numBedrooms;
	private int numBathrooms;
	private int numaCarSpace;
	private double sizeHouse;
	private String descriptionHouse;
	
	/*
	 * CALLING THE COSNTRUCTER FOR INTIALIZING THE ATTRIBUTES WITH THE USERS INPUT
	 */
	public House(String id,String address,String type,double price,int bedrooms,int bathrooms,
			int carspace,double size,String description) {
		super();
		this.houseID=id;
		this.houseAddress=address;
		this.houseType=type;
		this.housePrice=price;
		this.numBedrooms=bedrooms;
		this.numBathrooms=bathrooms;
		this.numaCarSpace=carspace;
		this.sizeHouse=size;
		this.descriptionHouse=description;
				
	}
	
	/* CALLING THE GETTERS AND SETTERS BELOW EACH OF THE ATTRIBUTES OF THE HOUSES */
	
	public String getHouseID() {
		return houseID;
	}

	public void setHouseID(String houseID) {
		this.houseID = houseID;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public double getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(double housePrice) {
		this.housePrice = housePrice;
	}

	public int getNumBedrooms() {
		return numBedrooms;
	}

	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	public int getNumBathrooms() {
		return numBathrooms;
	}

	public void setNumBathrooms(int numBathrooms) {
		this.numBathrooms = numBathrooms;
	}

	public int getNumaCarSpace() {
		return numaCarSpace;
	}

	public void setNumaCarSpace(int numaCarSpace) {
		this.numaCarSpace = numaCarSpace;
	}

	public double getSizeHouse() {
		return sizeHouse;
	}

	public void setSizeHouse(double sizeHouse) {
		this.sizeHouse = sizeHouse;
	}

	public String getDescriptionHouse() {
		return descriptionHouse;
	}

	public void setDescriptionHouse(String descriptionHouse) {
		this.descriptionHouse = descriptionHouse;
	}
	
	/*APPLYING CONDITION 1 SPLITWISE
	 * CALLING THE CUSTOM BUILT FUNCTION TO CHECK THE HOUSE ID WITH FIRST THREE
	 * CHARACTERS LONG AND REST AS NUMBERS
	 */
	public boolean checkHouseId(House house) {
		String pattern = "[A-Z]{3}\\d{7}"; /*
											 * PUTTING THE CONDITION IN REGEX EXPRESSION FOR FIRST THREE LETTERS WITH
											 * UPPERCASE AND REST AS NUMBERS
											 */
		if (house.houseID.length() == 10 && house.houseID
				.matches(pattern)) { /* CHECKING THE CONDITION FOR HOUSE LENGTH ALONG WIHT THE REGEX PATTERN IF TRUE THEN ALLOW ELSE DONT ALLOW*/
			return true;
		}
		return false;
	}
	
	/* APPLYING CONDITION 1 SPLITWISE
	 * CALLING THE CUSTOM BUILT FUNCTION TO CHECK The House description should be
	 * between 5 and 10 words long.
	 */
	
	public boolean checkHousedesc(House house) {
		
		if (house.descriptionHouse.length()>=5 && house.descriptionHouse.length()<=10) {
			return true;
		}
		return false;
	}
	
	/* APPLYING CONDITION 2 
	 * CALLING THE CUSTOM BUILT FUNCTION TO to add houses that have LESS than 4
	 * bedrooms and the number of their bathrooms is 2 or MORE.
	 */
	
	public boolean checkBedandBath(House house) {
		
		if (house.numBedrooms <=4 && house.numBathrooms<=2) {
			return true;
		}
		return false;
	}
	
	/*APPLYING CONDITION 2
	 * CALLING THE CUSTOM BUILT FUNCTION TO to add houses with GREATER than 50 m2
	 * size and their price is LESS than $350000.
	 */

	public boolean checkHousesize(House house) {
		
		if (house.housePrice < 350000 && house.sizeHouse > 50) {
			return true;
		}
		return false;
	}
	
	/*APPLYING CONDITION 3
	 * CALLING THE CUSTOM BUILT FUNCTION Houses with the type “Apartment” should
	 * have at least one car space
	 */
	
	public boolean checkHouseType(House house) {
		
		if (house.numaCarSpace >=1 && house.houseType.contentEquals("Apartment")) {
			return true;
		}
		return false;
	}
	
	/*APPLYING CONDITION 4
	 * CALLING THE CUSTOM BUILT FUNCTION TO CHECK The price of each house should be
	 * between $100000 and $1500000.
	 */
	
	public boolean checkHousePrice(House house) {
		
		if (house.housePrice > 100000 && house.housePrice < 1500000) {
			return true;
		}
		return false;
	}
	
	/*APPLYING CONDITION 5
	 * CALLING THE CUSTOM BUIL FUNCTION TO CHECK The price of houses with less than
	 * 3 bedrooms and 2 bathrooms cannot exceed $750000.
	 */
	
	public boolean checkbedbathPrice(House house) {
		
		if (house.numBedrooms < 3 && house.numBathrooms< 2 && house.housePrice <750000) {
			return true;
		}
		return false;
	}
	
	/*
	 * IMPLEMENTING THE ADDHOUSE FUNCTION BY INTEGRATING ALL THE ABOVE FUNCTIONS
	 * INSIDE WITH NESTED IF ELSE CONDITIONS STEP BY STEP 
	 */
	public boolean AddHouse(String fileName,House house) throws IOException {
		FileWriter fWriter = new FileWriter(
				fileName);/* DECLARING A FILEWRITER TO ADD DATAS TO THE SPECIFIED FILE NAME */
		if (checkHouseId(house) == true && checkHousedesc(house) == true
				&& checkBedandBath(house) == true) {/* CHECKING CONDITION 1 AND 2 TOGETHER */
			if (checkHousesize(house) == true) { /* CHECKING CONDITION 3 */ 
				if(checkHouseType(house)==true) {/* CHECKING CONDITION 4 */
					if(checkHousePrice(house)==true) {/* CHECKING CONDITION 5 */
						if(checkbedbathPrice(house)==true) {/* CHECKING CONDITION 6 */
							fWriter.write(house.houseID); /*
															 * IF CONDITIONS ARE SATISFIED THEN ALLOWING THE FILEWRITER
															 * TO WRITE DOWN ALL THE DATAS TO THE TEXT FILE
															 */
						fWriter.write(System.lineSeparator());
						fWriter.write(house.houseAddress);
						fWriter.write(System.lineSeparator());
						fWriter.write(house.houseType);
						fWriter.write(System.lineSeparator());
						fWriter.write(String.valueOf(house.housePrice));/*
																		 * CONVERTING THE INTEGER VALUE TO STRING
																		 * REPRESENTATION TO ADD INTO TEXT FILE SWIFTLY
																		 */
						fWriter.write(System.lineSeparator());
						fWriter.write(String.valueOf(house.numBedrooms));
						fWriter.write(System.lineSeparator());
						fWriter.write(String.valueOf(house.numBathrooms));
						fWriter.write(System.lineSeparator());
						fWriter.write(String.valueOf(house.numaCarSpace));
						fWriter.write(System.lineSeparator());
						fWriter.write(String.valueOf(house.sizeHouse));
						fWriter.write(System.lineSeparator());
						fWriter.write(house.descriptionHouse);
						fWriter.close();
						return true;
					} /*
						 * IF CONDITION 6 IS NOT SATISFIED STILL ADDING THE DATA TO TEXT FILE SINCE
						 * CONDITION 6 ONLY DEALS WITH 3 BEDROOMS AND 2 BATHROOMS SO ALLOWING THE USER
						 * TO ADD IF THE BEDROOMS ARE NOT EQUAL TO 3 AND BEDROOMS NOT EQUAL TO 2
						 */ 
						else {
							fWriter.write(house.houseID);
							fWriter.write(System.lineSeparator());
							fWriter.write(house.houseAddress);
							fWriter.write(System.lineSeparator());
							fWriter.write(house.houseType);
							fWriter.write(System.lineSeparator());
							fWriter.write(String.valueOf(house.housePrice));
							fWriter.write(System.lineSeparator());
							fWriter.write(String.valueOf(house.numBedrooms));
							fWriter.write(System.lineSeparator());
							fWriter.write(String.valueOf(house.numBathrooms));
							fWriter.write(System.lineSeparator());
							fWriter.write(String.valueOf(house.numaCarSpace));
							fWriter.write(System.lineSeparator());
							fWriter.write(String.valueOf(house.sizeHouse));
							fWriter.write(System.lineSeparator());
							fWriter.write(house.descriptionHouse);
							fWriter.close();
							return true;
							
						}
					}else {
						
						return false;
					}
				} else {/*
						 * ADDING IF THE USER NOT OPTED FOR APARTMENT BUT SOME OTHER MODE OF HOUSE TYPE
						 * SO STILL ALLOWING TO WRITE TO TEXT FILE
						 */
					
					fWriter.write(house.houseID);
					fWriter.write(System.lineSeparator());
					fWriter.write(house.houseAddress);
					fWriter.write(System.lineSeparator());
					fWriter.write(house.houseType);
					fWriter.write(System.lineSeparator());
					fWriter.write(String.valueOf(house.housePrice));
					fWriter.write(System.lineSeparator());
					fWriter.write(String.valueOf(house.numBedrooms));
					fWriter.write(System.lineSeparator());
					fWriter.write(String.valueOf(house.numBathrooms));
					fWriter.write(System.lineSeparator());
					fWriter.write(String.valueOf(house.numaCarSpace));
					fWriter.write(System.lineSeparator());
					fWriter.write(String.valueOf(house.sizeHouse));
					fWriter.write(System.lineSeparator());
					fWriter.write(house.descriptionHouse);
					fWriter.close();
					return true;
					
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	/* APPLYING THE CONDITION FOR 2,3 AND 4 TOGETHER */
	public boolean updatecondition1(House house,double newPrice,String newType,double newSize) {
		
		double price = house.housePrice + house.housePrice * 0.10; /* CALCULATING THE 10% PRICE */		
		double price2 = house.housePrice + house.housePrice * 0.20; /* CALCULATING THE 20% PRICE */			
		double newsize1 = house.sizeHouse + (house.sizeHouse * 0.05); /* CALCULATING THE 5% SIZE */
		double newsize2 = house.sizeHouse + (house.sizeHouse*0.10); /* CALCULATING THE 10% SIZE */
		/*
		 * CHECKING THE CONDITION OF NEW TYPE AS TOWNHOUSE AND BEDROOMS LESS THAN 3 AND
		 * PRICES SHOULD BE LESS THAN 10 % AND SIZES SHOULD BE IN THE RANGE OF 5-10 %
		 */ 
		if (house.numBedrooms < 3 && newPrice <= price && newType.equals("Townhouse") && (newSize > newsize1 && newSize < newsize2)) {
			house.housePrice = price; /* NEW PRICES IS NOT ADDING INSTEAD THE SAME PRICES IS GETTING SET */
			house.houseAddress = house.houseAddress; /* NEW ADDRESS IS NOT ADDING INSTEAD THE SAME ADDRESS IS GETTING SET */
			house.sizeHouse = newSize; /* NEW SIZE IS  ADDING  IS GETTING SET SINCE ITS A GLOBAL CONDITION*/
			return true;
		}
		return false;
	}

	/*
	 * CHECKING THE CONDITION OF NEW TYPE MUST NOT BE AS TOWNHOUSE AND BEDROOMS LESS
	 * THAN 3 AND PRICES SHOULD BE LESS THAN 10 % AND SIZES SHOULD BE IN THE RANGE
	 * OF 5-10 %
	 */
	public boolean updatecondition2(House house,double newPrice,String newType,double newSize,String newAddress) {
		
		double price = house.housePrice + house.housePrice*0.10; 		
		double price2 = house.housePrice + house.housePrice * 0.20; 		
		double newsize1 = house.sizeHouse + (house.sizeHouse*0.05);
		double newsize2 = house.sizeHouse + (house.sizeHouse*0.10);
		
		if ( !newType.equals("Townhouse") && (newSize > newsize1 && newSize < newsize2)) {
			house.housePrice = price2; /* NEW PRICE IS  ADDING  IS GETTING SET */
			house.houseAddress = newAddress;/* NEW ADDRESS IS  ADDING  IS GETTING SET */
			house.sizeHouse = newSize;/* NEW SIZE IS  ADDING  IS GETTING SET */
			return true;
		}
		return false;
	}

	/*
	 * IMPLEMENTING THE MAIN UPADTE FUNCTION WITH ABOVE CUSTOM BUILT UPDATES FUNCTIONS
	 */
	public boolean UpdateHouse(String newAddress,String newType,double newPrice,int newBedrooms,
			int newBathrooms, int newCarspace,double newSize,String newDescription, House house, String filename) throws IOException {
		FileWriter fWriter = new FileWriter(filename); 
		/*
		 * CHECKING THE CUSTOM BUILT UPDATE CONDITION IF APARTMENT EQUALS TO TOWNHOUSE
		 * ALONG WITH OTHER CONSTIONS OF LESS TAH 3 BEDROOMS AND PRICES AND SIZES RANGE
		 */
		if (updatecondition1(house, newPrice,newType,newSize)==true)  {
			fWriter.write(house.houseID);
			fWriter.write(System.lineSeparator());
			fWriter.write(house.houseAddress);
			fWriter.write(System.lineSeparator());
			fWriter.write(house.houseType);
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.housePrice));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.numBedrooms));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.numBathrooms));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.numaCarSpace));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.sizeHouse));
			fWriter.write(System.lineSeparator());
			fWriter.write(house.descriptionHouse);
			
			
			
			fWriter.close();
			
			
			return true;
		}
		/*
		 * CHECKING THE CUSTOM BUILT UPDATE CONDITION IF APARTMENT NOT  EQUALS TO TOWNHOUSE
		 * ALONG WITH OTHER CONSTIONS OF LESS TAH 3 BEDROOMS AND PRICES AND SIZES RANGE
		 */
		else if ( updatecondition2(house, newPrice,newType,newSize, newAddress)==true){
			fWriter.write(house.houseID);
			fWriter.write(System.lineSeparator());
			fWriter.write(house.houseAddress);
			fWriter.write(System.lineSeparator());
			fWriter.write(house.houseType);
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.housePrice));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.numBedrooms));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.numBathrooms));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.numaCarSpace));
			fWriter.write(System.lineSeparator());
			fWriter.write(String.valueOf(house.sizeHouse));
			fWriter.write(System.lineSeparator());
			fWriter.write(house.descriptionHouse);
			
			
			
			fWriter.close();
			
			
			return true;
			
		}
		/*
		 * APPLYING THE CONDITIONS THAT IF NOT UPDATED THE SAME RESUTS OF ADD HOUSES
		 * SHOULD PERSISTS SO WRITING THE FILES AS OF ADDHOUSES HERE IF ITS NOT UPDATED
		 * WITH CONDITIONS ABOVE
		 */
		fWriter.write(house.houseID);
		fWriter.write(System.lineSeparator());
		fWriter.write(house.houseAddress);
		fWriter.write(System.lineSeparator());
		fWriter.write(house.houseType);
		fWriter.write(System.lineSeparator());
		fWriter.write(String.valueOf(house.housePrice));
		fWriter.write(System.lineSeparator());
		fWriter.write(String.valueOf(house.numBedrooms));
		fWriter.write(System.lineSeparator());
		fWriter.write(String.valueOf(house.numBathrooms));
		fWriter.write(System.lineSeparator());
		fWriter.write(String.valueOf(house.numaCarSpace));
		fWriter.write(System.lineSeparator());
		fWriter.write(String.valueOf(house.sizeHouse));
		fWriter.write(System.lineSeparator());
		fWriter.write(house.descriptionHouse);
		fWriter.close();
		return false;
		
		}
	
	


		/*
		 * CREATING THE MAIN FUNCTION WITH IDEAL DATAS WHICH ARE ALLOWED TO WTIRE INTO THE TEXT
		 * FILE THE ADD HOUSE WILL BE ADDING THE DEATILS TO THE TEXT FILE WHEREAS THE
		 * UPDATE HOUSE WILL UPDATE.OVWERRIDE THE DEATILS INTO THE SAME TEXT FILE
		 */
	public static void main(String[] args) throws IOException 
	{
		House house = new House("QWE1234567", "abc", "Apartment", 349999, 1, 1, 1, 51, "DJabcd");
		boolean a=(house.AddHouse("src/addHouse.txt", house));
		System.out.println(a);
		boolean b= (house.UpdateHouse("ab", "Apartment", 20000, 1, 0, 0, 54, "CHAPEL", house, "src/addHouse.txt"));
		System.out.println(b);
		
		
	}
	
}



