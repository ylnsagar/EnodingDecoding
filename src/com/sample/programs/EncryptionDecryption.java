package com.sample.programs;

/**
 * Author :: sagar yenda.
 * Date :: 10/07/2016
 * This class calls encryption-decryption methods in ProcessEncDec and contains main method.
 *  Requires java 8 to run this file
 */
import java.util.HashMap;
import java.util.Map;

public class EncryptionDecryption {
	
	public static Map<String, String> map = new HashMap<String, String>();
	public static String inputFileName = "inputfile.txt";
	public static String outputFileName = "outputfile.txt";

	public static void main(String args[]) {		
		ProcessEncDec encdecObj = new ProcessEncDec();
		encdecObj.processEncyptionDecryption(map);
		if (encdecObj.fileReader(inputFileName, map)) {
			encdecObj.fileWriter(outputFileName);
		}		
	}
	
}
