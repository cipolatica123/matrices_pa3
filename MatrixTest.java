/*
Alberto Plata
1291980
pa3
*/

class MatrixTest{
  public static void main(String[] args){
		/* Matrix M = new Matrix(0); */
		Matrix M = new Matrix(3);
		Matrix M2 = new Matrix(3);
		Matrix M3 = new Matrix(2);
		Matrix mult1 = new Matrix(2);
		Matrix mult2 = new Matrix(2);
		Matrix Mmult1 = null;
		Matrix Mmult2 = null;
		Matrix Mmult3 = null;
		Matrix MCopy = null;
		Matrix M1point5 = null;
		Matrix addM = null;
		Matrix addM2 = null;
		Matrix MTran = null;
		System.out.println("\n\n\n\nSize= "+M.getSize());
		System.out.print(M.toString());

		
		
		mult1.changeEntry(1, 1, 1.0);
		mult1.changeEntry(1, 2, 2.0);
		mult1.changeEntry(2, 1, 3.0);
		mult1.changeEntry(2, 2, 4.0);
		mult2.changeEntry(1, 1, 5.0);
		mult2.changeEntry(2, 1, 7.0);
		System.out.println("\nMmult1 = mult1.mult(mult2);");
		Mmult1 = mult1.mult(mult2);
		System.out.print(Mmult1.toString());
		mult2.changeEntry(1, 2, 6.0);
		mult2.changeEntry(2, 2, 8.0);
		
		Mmult2 = mult2.mult(mult1);
		System.out.println("\nMmult2 = mult2.mult(mult1);");
		System.out.print(Mmult2.toString());
		
		
		
		
		
		
		M.changeEntry(1, 1, 1.0);
		System.out.print(M.toString());
		M.changeEntry(1, 2, 2.0);
		M.changeEntry(1, 3, 3.0);
		M.changeEntry(2, 1, 4.0);
		M.changeEntry(2, 2, 5.0);
		M.changeEntry(2, 3, 6.0);
		M.changeEntry(3, 1, 7.0);
		M.changeEntry(3, 2, 8.0);
		M.changeEntry(3, 3, 9.0);
		System.out.println("M.toString()");
		System.out.print(M.toString());
		System.out.println("M.toString()done done");
		System.out.println("\nMTran = M.transpose(); M then MTran");
		MTran = M.transpose();
		System.out.print(M.toString());
		System.out.print(MTran.toString());
		
		/* addM2 = M.add(M3); */
		/* addM2 = M.sub(M3); */
	
		M2.changeEntry(1, 2, 3333.0);
		addM2 = M.add(M2);
		System.out.println("\naddM2 = M.add(M2);");
		System.out.print(addM2.toString());
		addM2.makeZero();
		M.changeEntry(1, 2, 0.0);
		addM2 = M2.add(M);
		System.out.println("\naddM2 = M2.add(M);");
		System.out.print(addM2.toString());
		addM2.makeZero();
		M.changeEntry(1, 2, 0.0);
		addM2 = M.add(M2);
		System.out.println("\naddM2 = M.add(M2); ");
		System.out.print(addM2.toString());
		addM2.makeZero();
		M.changeEntry(1, 2, 2.0);
		System.out.println("\nnow for sub, M then M2");
		System.out.print(M.toString());
		System.out.print(M2.toString());
		addM2 = M.sub(M2);
		System.out.println("\nsubM2 = M.sub(M2); ");
		System.out.print(addM2.toString());
		addM2.makeZero();
		M.changeEntry(1, 2, 0.0);
		addM2 = M2.sub(M);
		System.out.println("\naddM2 = M2.sub(M); ");
		System.out.print(addM2.toString());
		addM2.makeZero();
		M.changeEntry(1, 2, 0.0);
		addM2 = M.sub(M2);
		System.out.println("\naddM2 = M.sub(M2);");
		System.out.print(addM2.toString());
		addM2.makeZero(); 
		
		System.out.println("\nthis is M.scalarMult(1.5) ");
		M1point5 = M.scalarMult(1.5);
		System.out.print(M1point5.toString());
		MCopy = M.copy();
		System.out.println("\nthis is MCopy    ");
		System.out.print(MCopy.toString());
		System.out.println("\nMCopy.equals(M): "+MCopy.equals(M));
		addM = M.add(MCopy);
		System.out.println("\nthis is AddM (Mcopy + M)   ");
		System.out.print(addM.toString());
		System.out.print(M.toString());
		M.changeEntry(2, 2, 0.0);
		System.out.print(M.toString());
		M.changeEntry(2, 2, 0.0);
		System.out.print(M.toString());
		M.changeEntry(3, 3, 0.0);
		System.out.print(M.toString());
		M.changeEntry(1, 1, 0.0);
		System.out.print(M.toString());
		M.makeZero();
		System.out.print(M.toString());
		
		M.changeEntry(1, 3, 3.0);
		M2.changeEntry(1, 2, 3.0);
		System.out.println("\nM.equals(M2): "+ M.equals(M2));
		M.makeZero();
		M2.makeZero();
		System.out.println("M.equals(M2): "+ M.equals(M2));
		
		M.changeEntry(3, 2, 8.0);
		M.changeEntry(1, 3, 3.0);
		M.changeEntry(3, 1, 7.0);
		M.changeEntry(1, 1, 1.0);
		M.changeEntry(3, 3, 9.0);
		M.changeEntry(1, 2, 2.0);
		M.changeEntry(2, 3, 6.0);
		M.changeEntry(2, 1, 4.0);
		M.changeEntry(2, 2, 5.0);
		
		
		M2.changeEntry(3, 2, 8.0);
		M2.changeEntry(1, 3, 3.0);
		M2.changeEntry(3, 1, 7.0);
		M2.changeEntry(1, 1, 1.0);
		M2.changeEntry(3, 3, 9.0);
		M2.changeEntry(1, 2, 2.0);
		M2.changeEntry(2, 3, 6.0);
		M2.changeEntry(2, 1, 4.0);
		M2.changeEntry(2, 2, 5.0);
		
		System.out.println("\nM.equals(M2): "+ M.equals(M2));
		M2.changeEntry(3, 3, 10.0);
		System.out.println("M.equals(M2): "+ M.equals(M2));
		M2.changeEntry(3, 3, 0.0);
		System.out.println("M.equals(M2): "+ M.equals(M2));
		M2.changeEntry(3, 3, 9.0);
		System.out.println("M.equals(M2): "+ M.equals(M2));
		System.out.print(M.toString()); 
		M.changeEntry(3, 3, 10.0);
		System.out.print(M.toString());
		M.changeEntry(2, 2, 20.0);
		System.out.print(M.toString());
		M.changeEntry(1, 1, 100.0);
		System.out.print(M.toString());
		System.out.println("M.equals(M2): "+ M.equals(M2));
		System.out.println("M.equals(M3): " +M.equals(M3)); 
		
		/* M.changeEntry(0, 1, 100.0); */
		/* M.changeEntry(1, 0, 100.0);  */
		/* M.changeEntry(4, 1, 100.0);  */
		/* M.changeEntry(1, 4, 100.0);  */
		
 }	

}

