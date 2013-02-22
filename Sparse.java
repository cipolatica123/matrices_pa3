/*
Alberto Plata
1291980
pa3
*/

import java.io.*;
import java.util.Scanner;

class Sparse  {
  public static void main(String[] args) throws IOException{
	Scanner in = null;
    PrintWriter out = null;
    String line = null;
    String[] token = null;
    int i = 0, lineNumber = 0, orderCount = 0; 
	int size, lengthA = 0, lengthB = 0;
	if(args.length < 2){
        System.out.println("Usage: FileIO infile outfile");
        System.exit(1);
    }
	in = new Scanner(new File(args[0]));
    out = new PrintWriter(new FileWriter(args[1]));
	
	Matrix A = null;
	Matrix B = null;
	while( in.hasNextLine() ){
		lineNumber++;
		line = in.nextLine()+" ";    // add extra space so split works right
        token = line.split("\\s+");  // split line around white space
        // n = token.length;
	    if(lineNumber == 1){
			size = Integer.parseInt(token[0]);
			lengthA = Integer.parseInt(token[1]);
			lengthB = Integer.parseInt(token[2]);
			A = new Matrix(size);
			B = new Matrix(size);
	    }
		else if (lineNumber > 2 && lineNumber <= (lengthA + 2)){
			A.changeEntry(Integer.parseInt(token[0]), Integer.parseInt(token[1]), Double.valueOf(token[2]));
		}
		else if (lineNumber > (lengthA + 3) && lineNumber <= (lengthA + lengthB + 3)){
			B.changeEntry(Integer.parseInt(token[0]), Integer.parseInt(token[1]), Double.valueOf(token[2]));
		}
	}
	
	out.println("A has "+A.getNNZ()+" non-zero entr" +((A.getNNZ() != 1)? "ies:" : "y:"));
	out.println(A.toString());
	
	out.println("B has "+B.getNNZ()+" non-zero entr" +((B.getNNZ() != 1)? "ies:" : "y:"));
	out.println(B.toString());
	
	out.println("(1.5)*A =");
	Matrix A1dot5 = A.scalarMult(1.5);
	out.println(A1dot5.toString());
	
	out.println("A+B =");
	Matrix AplusB = A.add(B);
	out.println(AplusB.toString());
	
	out.println("A+A =");
	Matrix AplusA = A.add(A);
	out.println(AplusA.toString());
	
	out.println("B-A =");
	Matrix BminusA = B.sub(A);
	out.println(BminusA.toString());
	
	out.println("A-A =");
	Matrix AminusA = A.sub(A);
	out.println(AminusA.toString());
	
	out.println("Transpose(A) =");
	Matrix ATranspose = A.transpose();
	out.println(ATranspose.toString());
	
	out.println("A*B =");
	Matrix AmultB = A.mult(B);
	out.println(AmultB.toString());
	
	out.println("B*B =");
	Matrix BmultB = B.mult(B);
	out.println(BmultB.toString());
	
	in.close();
    out.close();
	/* System.out.println(A.toString());
	System.out.println(B.toString()); */
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
}

