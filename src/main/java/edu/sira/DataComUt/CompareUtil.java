package edu.sira.DataComUt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CompareUtil {

	public static Map<String, Map<Integer, String>> prepareDataFile(String dataFileName, String keyPositionArray){
		Map<String, Map<Integer, String>> dataObjectsMap = new HashMap<String, Map<Integer, String> >();
		BufferedReader bufferedReader =null;
		try {
			 bufferedReader = Files.newBufferedReader((Paths.get(dataFileName)));

			String dataString = bufferedReader.readLine();
			while (dataString != null) {
				Map<Integer, String> dataMap = processRecord(dataString);
				
				String key = Key.prepareKey(keyPositionArray, dataMap);
				dataObjectsMap.put(key, dataMap);
				
				dataString = bufferedReader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataObjectsMap;
	}


	private static Map<Integer, String> processRecord(String dataString) {
		Map<Integer, String> dataMap = new HashMap<Integer, String>();
		String[] dataElimentsArray = dataString.split(C_.delimiter);
		Integer dataPosition = 1;
		for (String dataElement : dataElimentsArray) {
			dataMap.put(dataPosition, dataElement);
			dataPosition++;
		}
		return dataMap;
	}


	
}
