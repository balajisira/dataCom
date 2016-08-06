package edu.sira.DataComUt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ComparePro {
	private static String compareId;
	private static String file_1_Name, file_2_Name;
	private static String outPut_Dir;

	public static void doCompare(String file1, String file2, String file_1_keyPositionArray,
			String file_2_keyPositionArray, String outPutDir) {
		file_1_Name = file1;
		file_2_Name = file2;
		outPut_Dir = outPutDir;
		createCompareId(file1, file2);
		System.out.println(compareId);

		Map<String, Map<Integer, String>> preSet = CompareUtil.prepareDataFile(file1, file_1_keyPositionArray);
		Map<String, Map<Integer, String>> postSet = CompareUtil.prepareDataFile(file1, file_1_keyPositionArray);
		writeStats(preSet.keySet(), postSet.keySet());
		checkKeysLength(preSet.keySet(), postSet.keySet());
	}

	private static void createCompareId(String file1, String file2) {
		String file_1_Name = file1.substring(file1.lastIndexOf(C_.linix_filePathSepetrator) + 1, file1.length());
		String file_2_Name = file2.substring(file1.lastIndexOf(C_.linix_filePathSepetrator) + 1, file1.length());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH-mm");
		String date = dateFormat.format(System.currentTimeMillis());
		compareId = (file_1_Name + "_" + file_2_Name + "_" + date).toUpperCase();
	}

	private static void createCompareId(String file1, String file2, String file_1_keyPositionArray,
			String file_2_keyPositionArray) {
		String file_1_Name = file1.substring(file1.lastIndexOf(C_.linix_filePathSepetrator), file1.length());
		String file_2_Name = file2.substring(file1.lastIndexOf(C_.linix_filePathSepetrator), file1.length());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH-mm");
		String date = dateFormat.format(System.currentTimeMillis());
		compareId = file_1_Name + file_1_keyPositionArray + "_" + file_2_Name + file_2_keyPositionArray + "_" + date;
	}

	private static void writeStats(Set<String> preKeys, Set<String> postKeys) {
		try {
			FileWriter fileWriter = new FileWriter(outPut_Dir + C_.linix_filePathSepetrator + compareId + ".stats");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			int pre_DataCount = preKeys.size();
			int post_DataCount = postKeys.size();
			StringBuffer statsBuffer = new StringBuffer();
			statsBuffer.append("--------------------" + compareId + "----------------------").append(C_.lineEnd);
			statsBuffer.append("File 1 : " + file_1_Name).append(C_.lineEnd);
			statsBuffer.append("No Of Data Records : " + pre_DataCount).append(C_.lineEnd);

			statsBuffer.append("File 2 : " + file_2_Name).append(C_.lineEnd);
			statsBuffer.append("No Of Data Records : " + post_DataCount).append(C_.lineEnd);
			statsBuffer.append("--------------------" + compareId + "----------------------").append(C_.lineEnd);
			bufferedWriter.write(statsBuffer.toString());
			bufferedWriter.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void checkKeysLength(Set<String> preKeys, Set <String> postKeys){
		
		
		System.out.println(Collections.disjoint(preKeys, postKeys));
	}

}
