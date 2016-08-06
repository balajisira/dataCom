package edu.sira.DataComUt;

public class TestMain {
	public static void main(String[] args) {
		
		String file_1 = "C:/Dev/data/comparepro/dataPre.txt"; 
		String file_2 = "C:/Dev/data/comparepro/dataPre.txt";
		String outPutDir ="C:/Dev/data/comparepro/";
		String file_1_keyPositionArray="1";
		String file_2_keyPositionArray="1";
		ComparePro.doCompare(file_1, file_2, file_1_keyPositionArray, file_2_keyPositionArray,outPutDir);
		
	}


}

