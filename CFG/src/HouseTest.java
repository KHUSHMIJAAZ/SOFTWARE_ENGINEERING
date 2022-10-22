import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class HouseTest {

	/* The test cases below all are implemented with two test datas */
	/*
	 * JUST A NOTE IF AND ONLY IF TWO TEST DATA IS AN IDEAL MATCH FOR THE FUNNCTION
	 *  THE FUNCTION WILL
	 * RUN SUCCESSFULLY WITHOUT FAILURE
	 */
	@Test
	void testCheckHouseId() throws IOException {
		House house = new House("QWE1234567", "WILLIAM_STREET", "Apartment", 100000, 1, 1, 1, 25,
				"DJ"); /* PUTTING THE HOUSE ID CONDITION WITH THE 'QWE1234567' AS THE IDEAL MATCH */
		House house1 = new House("RA91234567", "WILLIAM_STREET", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE ID CONDITION WITH THE 'RA91234567' AS NOT THE IDEAL MATCH */
        boolean a = true;
        boolean b = house.checkHouseId(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testCheckHousedesc() {
		House house = new House("QWE1234567", "K_STREET", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE DESC CONDITION WITH THE 'DJ' AS THE IDEAL MATCH */
		House house1 = new House("QWE1234567", "SWANSTON", "Apartment", 100000, 1, 1, 1, 25, "DJasdef");
		/* PUTTING THE HOUSE DESC CONDITION WITH THE 'DJasdef' AS THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.checkHousedesc(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testCheckBedandBath() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE BEDTOOM AND BATHROOM CONDITION WITH THE '1,1' AS THE IDEAL MATCH */
		House house1 = new House("QWE1234567", "abc", "Apartment", 100000, 4, 3, 1, 25, "DJ");
		/* PUTTING THE BEDTOOM AND BATHROOM CONDITION WITH THE '4,3' AS NOT THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.checkBedandBath(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testCheckHousesize() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE SIZE CONDITION WITH THE '25' AS THE IDEAL MATCH */
		House house1 = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 40, "DJ");
		/* PUTTING THE HOUSE SIZE CONDITION WITH THE '40' AS THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.checkHousesize(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testCheckHouseType() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE TYPE CONDITION WITH THE 'Apartment' AS THE IDEAL MATCH */
		House house1 = new House("QWE1234567", "abc", "Township", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE TYPE CONDITION WITH THE 'Township' AS NOT THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.checkHouseType(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testCheckHousePrice() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE PRICE CONDITION WITH THE '100000' AS THE IDEAL MATCH */
		House house1 = new House("QWE1234567", "abc", "Apartment", 5000000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE HOUSE PRICE CONDITION WITH THE '5000000' AS THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.checkHousePrice(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testCheckbedbathPrice() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE BEDROOM AND BATHROOM PRICE CONDITION WITH THE '1,1' AS THE IDEAL MATCH */
		House house1 = new House("QWE1234567", "abc", "Apartment", 750000, 3, 2, 1, 25, "DJ");
		/* PUTTING THE BEDROOM AND BATHROOM PRICE CONDITION WITH THE '3,2' AS THE NOT IDEAL MATCH */
        boolean a = false;
        boolean b = house.checkbedbathPrice(house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testAddHouse() throws IOException {
		House house = new House("QWE1234567", "CHURCHSTREET", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
		House house1 = new House("RAN1234589", "ELIZABETH", "UNILODGE", 200000, 2, 2, 2, 27, "DJC");
		/* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.AddHouse("src/addHouse.txt", house);
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.checkHouseId(house1);
        assertEquals(a1,b1);
	}

	@Test
	void testUpdatecondition1() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		/* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
		House house1 = new House("RAN1234589", "BOURKE", "SCAPE", 300000, 1, 2, 2, 30, "DJ");
		/* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        boolean a = false;
        boolean b = house.updatecondition1(house, 250000, "DJ", 20);
        /* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.updatecondition1(house, 350000, "MJ", 40);
        /* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        assertEquals(a1,b1);
	}

	@Test
	void testUpdatecondition2() {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		House house1 = new House("RAN1234589", "BOURKE", "SCAPE", 300000, 1, 2, 2, 30, "DJ");
        boolean a = false;
        boolean b = house.updatecondition2(house, 37000, "KL", 25,"KL");
        /* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.updatecondition2(house, 370000, "LA", 30,"LA");
        /* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        assertEquals(a1,b1);
	}

	@Test
	void testUpdateHouse() throws IOException {
		House house = new House("QWE1234567", "abc", "Apartment", 100000, 1, 1, 1, 25, "DJ");
		House house1 = new House("RAN1234589", "BOURKE", "SCAPE", 300000, 1, 2, 2, 30, "DJ");
        boolean a = true;
        boolean b = house.UpdateHouse("ab", "Apartment", 20000, 1, 0, 0, 27, "CHAPEL", house, "src/addHouse.txt");
        /* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        assertEquals(a,b);
        boolean a1 = true;
        boolean b1 = house1.UpdateHouse("ab", "Apartment", 20000, 1, 0, 0, 29, "CHAPEL", house, "src/addHouse.txt");
        /* PUTTING THE ALL CONDITIONS AS THE IDEAL MATCH */
        assertEquals(a1,b1);
	}

}
