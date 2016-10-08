package com.sample.programs;

/**
 * Author :: sagar yenda.
 * Date :: 10/07/2016
 * This class processes encryption-decryption and also works as File Write and File Reader.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ProcessEncDec {
	private StringBuffer strBuffer = new StringBuffer();

	/*
	 * this method processes Encryption and Decryption. This method assumes that
	 * encoding and decoding messages are of same length and each unique letter
	 * in encrypted text corresponds to a unique letter in decrypted text.
	 * 
	 * Requires java 8 to run this file and also an input text file in the path.
	 *
	 */
	public void processEncyptionDecryption(Map<String, String> map) {

		String encodingMessage = String.join(System.getProperty("line.separator"),
				"1JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5",
				"1PIT'pz'h'{yhklthyr'vm'{ol'Pu{lyuh{pvuhs'I|zpulzz'Thjopul'Jvywvyh{pvu5",
				"1KLJ'pz'{ol'{yhklthyr'vm'{ol'Kpnp{hs'Lx|pwtlu{'Jvywvyh{pvu5");

		String decodingMessage = String.join(System.getProperty("line.separator"),
				"*CDC is the trademark of the Control Data Corporation.",
				"*IBM is a trademark of the International Business Machine Corporation.",
				"*DEC is the trademark of the Digital Equipment Corporation.");

		try {
			if (decodingMessage.length() == encodingMessage.length()) {
				for (int index = 0; index < encodingMessage.length(); index++) {
					String str = String.valueOf(encodingMessage.charAt(index));
					if (!map.containsKey(str)) {
						map.put(str, String.valueOf(decodingMessage.charAt(index)));
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Encryption Decryption process failed");
		}

		System.out.println("Successfully processed");
	}

	/*
	 * writing File to output file
	 */
	public void fileWriter(String outputFile) {
		try {
			File file = new File(outputFile);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(strBuffer.toString().trim());
			bufferedWriter.newLine();
			bufferedWriter.close();
			System.out.println("successfully wrote the  " + outputFile);
		} catch (IOException ex) {
			System.out.println("Unable to write file '" + outputFile + ex.getMessage());
		}
	}

	/*
	 * Reading a File using File Reader and appending the String to String
	 * buffer object.
	 */
	public boolean fileReader(String fileName, Map<String, String> map) {
		System.out.println(map.size());
		String line = null;
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				for (int index = 0; index < line.length(); index++) {
					if (line.charAt(index) == ' ')
						continue;
					strBuffer.append(map.get(String.valueOf(line.charAt(index))).charAt(0));
				}
				strBuffer.append("\n");
			}
			bufferedReader.close();
			System.out.println("successfully read the  " + fileName);
			if (strBuffer.length() > 0)
				return true;
		}

		catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + " ex.getMessage()");
		}

		return false;
	}

}
