
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class Squarelotron {

	int[][] squarelotron;

	int size;

	Squarelotron(int n){
		this.size = n;
		System.out.println("");
		if(size <=8 ) {

			this.squarelotron= new int[size][size];
			int q=1;
			for(int i=0 ; i < size ; i++){
				for(int j =0 ; j < size ; j ++) {

					this.squarelotron[i][j]=q;
					q++;
				}
			}
			System.out.println(Arrays.deepToString(squarelotron).replace("], ", "]\n")
					.replace("[[", "[").replace("]]", "]"));
		}
		else
			System.out.println("enter a valid size of the array");
		System.out.println("");

	}


	Squarelotron upsideDownFlip(int ring) {
		System.out.println("");
		Squarelotron temp3= new Squarelotron(this.size);
		
		for(int i = 0 ; i < squarelotron.length ; i++) {
			for(int j =0 ; j < squarelotron.length; j++) {
				temp3.squarelotron[i][j]=squarelotron[i][j];
			}}
		for(int i = 0 ; i < temp3.size ; i++) {
			for(int j =0 ; j < temp3.size; j++) {
				if((i>=ring-1) && (i<= temp3.size-ring) && (j>=ring-1) && (j<=temp3.size-ring )) {
					if((i>ring-1) && (i < temp3.size-ring) && (j>ring-1) && (j<temp3.size-ring) ) {
						temp3.squarelotron[i][j]=this.squarelotron[i][j];
					}
					else {	
						temp3.squarelotron[i][j]=this.squarelotron[temp3.size-1-i][j];
					}
				}
				else {
					temp3.squarelotron[i][j]=this.squarelotron[i][j];
				}
			}
		}
//System.out.println(Arrays.deepToString(upsideDownFlip).replace("], ", "]\n")
			//.replace("[[", "[").replace("]]", "]"));
		System.out.println("");
		return temp3;

	}

	Squarelotron mainDiagonalFlip(int ring) {
		System.out.println("");
		Squarelotron temp4= new Squarelotron(size);

		for(int i = 0 ; i < temp4.size ; i++) {
			for(int j =0 ; j < temp4.size; j++) {
		
				if((i>=ring-1&&i<=temp4.size-ring&&j>=ring-1&j<=temp4.size-ring )) {
				
					if(i>ring-1&&i<temp4.size-ring&&j>ring-1&j<temp4.size-ring ) {
					
						temp4.squarelotron[i][j]=this.squarelotron[i][j];
					}
					else {	
						temp4.squarelotron[i][j]=this.squarelotron[j][i];
					}
				}
				else {

					temp4.squarelotron[i][j]=this.squarelotron[i][j];


				}
			}
		}
	System.out.println("");

		return temp4;

	}
	void rotateRight(int numberOfTurns) {
		System.out.println("");
	//	int[][] temp2= new int[squarelotron.length][squarelotron.length];	
		int[][] temp3= new int[squarelotron.length][squarelotron.length];
		if (numberOfTurns==Math.abs(numberOfTurns)) {
			for(int k=0 ; k < numberOfTurns ; k++) {

				for(int i = 0 ; i < squarelotron.length ; i++) {
					for(int j = 0; j <squarelotron.length; j++) {
						//if(i==0) {
						temp3[j][squarelotron.length-1-i]=this.squarelotron[i][j];

					}
				}
				for(int x= 0; x < squarelotron.length ; x++) {
					for(int y=0 ; y <squarelotron.length; y++) {
						this.squarelotron[x][y]=temp3[x][y];
					}
				}
			}
            System.out.println(Arrays.deepToString(temp3).replace("], ", "]\n")
					.replace("[[", "[").replace("]]", "]"));	
			System.out.println();
			//arelotron temp3=temp3
		}
		else {
			numberOfTurns=Math.abs(numberOfTurns);
			
			for(int k=0 ; k < numberOfTurns ; k++) {

				for(int i = 0 ; i < squarelotron.length ; i++) {
					for(int j = 0; j <squarelotron.length; j++) {
						//if(i==0) {
						temp3[squarelotron.length-1-j][i]=this.squarelotron[i][j];

					}
				}
				for(int x= 0; x < squarelotron.length ; x++) {
					for(int y=0 ; y <squarelotron.length; y++) {
						this.squarelotron[x][y]=temp3[x][y];
					}
				}
			}
System.out.println(Arrays.deepToString(temp3).replace("], ", "]\n")
					.replace("[[", "[").replace("]]", "]"));	
			System.out.println();
		}

	}
	
	
	public void printSquarelotron() {
		for(int i = 0; i < this.size ; i++) {
			for(int j = 0; j < this.size ; j++) {
				System.out.print(this.squarelotron[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		System.out.print("enter a number less than 9 to declare an array: ");
		int	n =Scanner.nextInt() ;
		Squarelotron newTest= new Squarelotron(n);
		System.out.print("enter the number of the ring you want to main-diagonally and unsidedaownly flip: ");
		int ring=Scanner.nextInt();
		Squarelotron NewTest=newTest.upsideDownFlip(ring);
		Squarelotron NewTest1=  newTest.mainDiagonalFlip(ring);

		System.out.print("enter the number of turns you want to rotate clockwisely and -ve number for counter clockwise: ");

		int numberOfTurns=Scanner.nextInt();
		newTest.rotateRight(numberOfTurns);
		Scanner.close();
	}

}
