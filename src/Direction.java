
public class Direction implements Robol {

	private int key;
	private String stringKey;
	
	static final String validStringKeys[] = {"x", "y", "-x", "-y"};
	
	public Direction(String stringKey) {
		this.stringKey = stringKey;
	}

	public int getKey() {
		return key;
	}

	public static String keyToStringKey(int key) {
		return validStringKeys[key];
	}
	
	public static int stringKeyToKey(String stringKey) {
		for (int i = 0; i < validStringKeys.length; i++) {
			if (stringKey.equals(validStringKeys[i])) 
				return i;
		}
		return -1;
	}
	
	@Override
	public void interpret() {
		Boolean validKey = false;
		for (String vk : validStringKeys)
			if (stringKey.equals(vk))
				validKey = true;
		if (!validKey) {
			System.err.println("Error: invalid direction (" + stringKey + ")");
			System.exit(0);
		}
		
		key = stringKeyToKey(stringKey);
	}

	@Override
	public String toString() {
		return stringKey;
	}
	
}
