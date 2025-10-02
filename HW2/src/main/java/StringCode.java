import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
        if (str == "") return 0;
        int lengthSubstr = 1;
        int maxLengthSubstr = lengthSubstr;
        int lengthStr = str.length();
        char[] arrStr = str.toCharArray();
        for (int i = 1; i < lengthStr; i++) {
            if(arrStr[i] != arrStr[i-1]) {
                lengthSubstr = 1;
            } else {
                lengthSubstr++;
                maxLengthSubstr = Math.max(maxLengthSubstr, lengthSubstr);
            }
        }
        return maxLengthSubstr;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
        int lengthStr = str.length();
        char[] arr = str.toCharArray();
        String result = "";
        for (int i = 0; i < lengthStr; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                if (i != lengthStr - 1) {
                    int repeatCount = arr[i] - '0';
                    for (int j = 1; j <= repeatCount; j++) {
                        result += arr[i+1];
                    }
                }
            } else {
                result += arr[i];
            }
        }
		return result;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        char[] arrStrA = a.toCharArray();
        int lengthStrA = a.length();
        char[] arrStrB = b.toCharArray();
        int lengthStrB = b.length();
        int[][] lengthSubstrAandB = new int[lengthStrA + 1][lengthStrB + 1];
        int maxLengthSubstrAandB = 0;

        for (int i = 0; i < lengthStrA; i++) {
            for (int j = 0; j < lengthStrB; j++) {
                if (arrStrA[i] == arrStrB[j]) {
                    if (i == 0 || j == 0) {
                        lengthSubstrAandB[i][j] = 1;
                    } else {
                        lengthSubstrAandB[i][j] = lengthSubstrAandB[i - 1][j - 1] + 1;
                        maxLengthSubstrAandB = Math.max(lengthSubstrAandB[i][j], maxLengthSubstrAandB);
                    }
                } else {
                    lengthSubstrAandB[i][j] = 0;
                }
                if (maxLengthSubstrAandB == len) {
                    return true;
                }
            }
        }
        return false;
	}
}
