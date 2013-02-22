/*
Alberto Plata
1291980
pa3
*/

class Matrix{

private class Entry {
		public int col;
		public double val;
		public Entry(int c, double v){
			col = c; 
			val = v;
		}
		public boolean equals(Entry e){	return (col == e.col && val == e.val);	}
		public String toString(){ 
			String elements = ("("+String.valueOf(col) + ", " +String.valueOf(val)+")");
			return elements; 
		}	
	} 
	private int size;
	private int NNZ;
	private List[] row;
////////////////////////////////////////////// Constructor ////////////////////////
Matrix(int n) {
	if (n < 1 ) 
	{	throw new RuntimeException("Matrix Error: n < 1");   }
	size = n;
	NNZ = 0;
	row = new List[n+1];
	for(int i =0; i < (n+1); i++){
		row[i] = new List();
	}
}
/*********************************  Access Functions   *********************************/
int getSize() {
	return size;
}
int getNNZ(){
	return NNZ;
} 

public boolean equals(Object x) {
	Matrix temp = (Matrix)x;
	if (getSize() != temp.getSize()) return false;
	Entry t1 = null, t2 = null;
	for(int i = 1; i < (getSize()+1); i++){
		if( row[i].getLength() != temp.row[i].getLength()) return false;
		row[i].moveTo(0);
		temp.row[i].moveTo(0);
		while(!row[i].offEnd()){
			t1 = (Entry)row[i].getCurrent();
			t2 = (Entry)temp.row[i].getCurrent(); 
			if(t1.col != t2.col || t1.val != t2.val)	return false;
			row[i].moveNext();
			temp.row[i].moveNext();
		}
	}
	return true;
}  
/* public boolean equals(Object x) {
	Matrix temp = (Matrix)x;
	if (getSize() != temp.getSize()) return false;
	for(int i = 1; i < (getSize()+1); i++){	
		if ( !row[i].equals(temp.row[i]))	return false;	
	}
	return true;
}  */
/*********************************    Manipulation procedures  ******************************/
void makeZero(){
	for (int i =1; i < (size+1); i++)	row[i].makeEmpty();	
	NNZ = 0;
}
Matrix copy(){
	return scalarMult(1.0);
}
void changeEntry(int i, int j, double x){
	if (i < 1 || i > getSize() ) 
	{	throw new RuntimeException("Matrix Error: changeEntry called with i < 1 || i > getSize()");   }
	if (j < 1 || j > getSize() ) 
	{	throw new RuntimeException("Matrix Error: changeEntry called with j < 1 || j > getSize()");   }
	
	int tempIndex = getIJ(i,j); 
	Entry temp = null;
	boolean isFound = false;
	if( x != 0.0){
		if (tempIndex > -1){
			row[i].moveTo(tempIndex);
			temp = (Entry)row[i].getCurrent();
			temp.val = x;
		}
		else{
			Entry newEntry = new Entry(j,x);
			row[i].moveTo(0);
			while(!row[i].offEnd() && !isFound){
				temp = (Entry)row[i].getCurrent();
				if(temp.col > j){
					row[i].insertBeforeCurrent(newEntry);
					isFound = true;
				}
				else	row[i].moveNext();
			}
			if(row[i].offEnd())	row[i].insertBack(newEntry);
			NNZ++;
		}
	}
	else{
		if (tempIndex != -1){
			row[i].moveTo(tempIndex);
			row[i].deleteCurrent();
			NNZ--;
		}
	}
}

int getIJ(int i, int j){
	row[i].moveTo(0);
	Entry temp = null;
	int index = -1;
	while(!row[i].offEnd()){
		index++;
		temp = (Entry)row[i].getCurrent();
		if (temp.col == j)	return index;
		if (temp.col > j) 	return -1;
		row[i].moveNext();
	}
	return -1;
}
Matrix scalarMult(double x){
	Matrix newMatrix = new Matrix(size);
	Entry temp = null;
	for (int i = 1; i <= size; i++){
		row[i].moveTo(0);
		while (!row[i].offEnd()){
			temp = (Entry)row[i].getCurrent();
			newMatrix.changeEntry(i, temp.col, (temp.val*x));
			row[i].moveNext();
		}
	}
	return newMatrix;
}
Matrix add(Matrix M){
	if (this == M)	{
		return scalarMult(2.0);
	}
	return addOrSub(M, 1);
}
private Matrix addOrSub(Matrix M, int isPositive){
if (getSize() != M.getSize() ) 
	{	throw new RuntimeException("Matrix Error: "+((isPositive == 1)? "Add" : "Sub")+" called with getSize() != M.getSize()");   }
	
	Matrix newMatrix = new Matrix(size);
	Entry temp1 = null, temp2 = null; 
	boolean isDone1= false, isDone2 = false;
	int col1, col2;
	for(int i = 1; i < (size+1); i++){
		row[i].moveTo(0);
		M.row[i].moveTo(0);
		isDone1 = isDone2 = false;
		while(!isDone1 || !isDone2){
			if(row[i].offEnd()){
				isDone1 = true;
				while(!M.row[i].offEnd()){
					temp2 = (Entry)M.row[i].getCurrent();
					newMatrix.changeEntry(i, temp2.col, (isPositive*temp2.val));
					M.row[i].moveNext();
				}
				isDone2 = true;
			}
			else if (M.row[i].offEnd()){
				isDone2 = true;
				while(!row[i].offEnd()){
					temp1 = (Entry)row[i].getCurrent();
					newMatrix.changeEntry(i, temp1.col, temp1.val);
					row[i].moveNext();
				}
				isDone1 = true;
			}
			else{
				temp1 = (Entry)row[i].getCurrent();
				temp2 = (Entry)M.row[i].getCurrent();
				if(temp1.col < temp2.col){
					newMatrix.changeEntry(i, temp1.col, temp1.val);
					row[i].moveNext();
				}	
				else if (temp1.col > temp2.col){
					newMatrix.changeEntry(i, temp2.col, (isPositive*temp2.val));
					M.row[i].moveNext();
				}
				else{
					newMatrix.changeEntry(i, temp1.col, (temp1.val+(isPositive*temp2.val)));
					row[i].moveNext();
					M.row[i].moveNext();
				}
			}
		}
		
	}
	return newMatrix;
}
Matrix sub(Matrix M){
	if (this == M)	{
		Matrix newMatrix = new Matrix(size);
		return newMatrix;
	}
	return addOrSub(M, -1);
}

Matrix transpose(){
	Matrix newMatrix = new Matrix(size);
	Entry temp = null;
	for (int i = 1; i < (size+1); i++){
		row[i].moveTo(0);
		while (!row[i].offEnd()){
			temp = (Entry)row[i].getCurrent();
			newMatrix.changeEntry(temp.col, i, temp.val);
			row[i].moveNext();
		}
	}
	return newMatrix;
}

Matrix mult(Matrix M){
	if (getSize() != M.getSize() ) 
	{	throw new RuntimeException("Matrix Error: mult called with getSize() != M.getSize()");   }
	Matrix newMatrix = new Matrix(size);
	Matrix tempTran = new Matrix(size);
	tempTran = M.transpose();
	for(int i = 1; i < (size+1); i++){
		for (int j = 1; j < (size+1); j++){
			newMatrix.changeEntry(i, j, dot(row[i], tempTran.row[j]));
		}
	}
	return newMatrix;
}
private static double dot(List P, List Q){
	double dotProd = 0.0;
	P.moveTo(0);
	Q.moveTo(0);
	Entry pTemp = null, qTemp = null;
	boolean isDone = false;
	while (!isDone){
		if (P.offEnd()|| Q.offEnd())			{ 	isDone = true; 	}
		else{
			pTemp = (Entry)P.getCurrent();
			qTemp = (Entry)Q.getCurrent();
			if ( pTemp.col > qTemp.col)			{	Q.moveNext();	}
			else if (pTemp.col < qTemp.col)		{	P.moveNext();	}
			else{
				dotProd += (pTemp.val*qTemp.val);
				Q.moveNext();
				P.moveNext();
			}	
		}
	}
	return dotProd;
}
// returns a new Matrix that is the product of this Matrix with M
// pre: getSize()==M.getSize()
// Other functions ////////////////////
public String toString() {
	String elements = "";
	for(int i = 1; i < (size+1); i++){
		row[i].moveTo(0);
		if (!row[i].offEnd()){
			elements += String.valueOf(i)+": ";
			elements += row[i].toString()+"\n";
		}	
	}
	return elements;
}// overrides Object's toString() method
/* void printMatrix(){
	Entry temp= null;
	int tempLength;
	System.out.println("A has "+NNZ+ " non-zero entr" +((NNZ != 1)? "ies:" : "y:"));
	if( NNZ !=0 ){
		for(int i = 1; i < (size+1); i++){
			tempLength = row[i].getLength();
			if (tempLength > 0){
				row[i].moveTo(0);
				temp = (Entry)row[i].getCurrent(); 
				System.out.print(i+": ");
				for (int j = 0; j < tempLength; j++){
					System.out.print("("+temp.col+", "+temp.val+")");
					if (j != (tempLength-1)){
						System.out.print(" ");
						row[i].moveNext();
						temp = (Entry)row[i].getCurrent(); 
					}				
				}
				System.out.println("");
			}
		}
	}
	else System.out.println("NOTHING TO PRINT");
} */

}
