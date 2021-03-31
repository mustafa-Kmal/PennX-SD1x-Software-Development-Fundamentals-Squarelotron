package squarelotron;


import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	Object[][] squarelotron;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSquarelotron() {


		Squarelotron newTest= new Squarelotron(5);
		int row1[]= {1,   2,   3,   4,   5};
		int row2[]= {6,   7,   8,   9,   10};
		int row3[]= {11,  12,  13,  14,  15};
		int row4[]= {16,  17,  18,  19,  20};
		int row5[]= {21,  22,  23,  24,  25};
		//int row6[]= {961 ,1024 ,1089 ,1156 ,1225  ,1296};

		//int[][] expecteds ={{1, 4, 9} , {16, 25, 36} , {49, 64, 81}};
		//fail("Not yet implemented");
		assertArrayEquals(row1,  newTest.squarelotron[0]);
		assertArrayEquals(row2,  newTest.squarelotron[1]);
		assertArrayEquals(row3,  newTest.squarelotron[2]);
		assertArrayEquals(row4,  newTest.squarelotron[3]);
		assertArrayEquals(row5,  newTest.squarelotron[4]);
		//assertArrayEquals(row6,  newTest.squarelotron[5]);
	}

	@Test
	public void testUpsideDownFlip() {
		Squarelotron New= new Squarelotron(5);
		Squarelotron NewTest =New.upsideDownFlip(1);

		int row1[]= {21,  22,  23,  24,  25};
		int row2[]= {16,   7,   8,   9,   20};
		int row3[]= {11,  12,  13,  14,  15};
		int row4[]= {6,   17,  18,  19,  10};
		int row5[]= {1,   2,   3,   4,   5};


		assertArrayEquals(row1 ,  NewTest.squarelotron[0]);
	/*	assertArrayEquals(New.squarelotron[1],  row2);
		assertArrayEquals(New.squarelotron[2],  row3);
		assertArrayEquals(New.squarelotron[3],  row4);
		assertArrayEquals(New.squarelotron[4],  row5);*/

	}
	@Test
	public void testMainDiagonalFlip() {


		Squarelotron Newtest= new Squarelotron(6);
		Squarelotron NewTest= Newtest.mainDiagonalFlip(1);

		int[] row0= {1   ,7   ,13     ,19   ,25    ,31};
		int[] row1= {2   ,8    ,9      ,10   ,11    ,32};
		int[] row2= {3   ,196  ,225    ,256  ,289   ,33};
		int[] row3= {4   ,400  ,441    ,484  ,529   ,34};
		int[] row4= {5   ,676  ,729    ,784  ,841   ,35};
		int[] row5= {6   ,12   ,18     ,24   ,30    ,36};


		assertArrayEquals(row0,  NewTest.squarelotron[0]);
		assertArrayEquals(row1,  NewTest.squarelotron[1]);
	/*	assertArrayEquals(row2,  NewTest.squarelotron[2]);
		assertArrayEquals(row3,  NewTest.squarelotron[3]);
		assertArrayEquals(row4,  NewTest.squarelotron[4]);
		assertArrayEquals(row5,  NewTest.squarelotron[5]);
*/

	}

	@Test
	public void testRotateRight() {
		Squarelotron tron = new Squarelotron(6);
		int[] testArr1 = {1, 2, 3, 4, 5, 6};
		int[] testArr2 = {8, 9, 10, 11};
		int[] testArr3 = {15, 16};
		tron.rotateRight(2);
		for(int i = 0 ; i < 6 ; i++) {
			assertEquals(tron.squarelotron[5][5-i], testArr1[i]);
		}
		tron.rotateRight(-3);
		for(int i = 0 ; i < 2 ; i++) {
			assertEquals(tron.squarelotron[3-i][2], testArr3[i]);
		}
		tron.rotateRight(4);
		for(int i = 0 ; i < 4 ; i++) {
			assertEquals(tron.squarelotron[4 - i][1], testArr2[i]);
		}
	}

}


