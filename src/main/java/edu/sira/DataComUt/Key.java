package edu.sira.DataComUt;

import java.util.Map;

public class Key {

	public static String prepareKey(String keyPositionArray, Map<Integer, String> dataMap) {
		String[] keys = keyPositionArray.split(C_.keySpliter);
		StringBuffer keyBuffer = new StringBuffer();
		for (String key : keys) {
			keyBuffer.append(dataMap.get(Integer.parseInt(key))).append(C_.keyJoiner);
		}
		String rawKey = keyBuffer.toString();
		return rawKey.substring(0, rawKey.lastIndexOf(C_.keyJoiner));
	}
}
