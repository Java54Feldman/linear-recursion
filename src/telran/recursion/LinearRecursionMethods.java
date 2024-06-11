package telran.recursion;

public class LinearRecursionMethods {
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be negative");
		}
		int res = 1;
		if (n != 0) {
			res = n * factorial(n - 1);
		}
		return res;
	}

	/**
	 * 
	 * @param a - any integer
	 * @param b - positive integer
	 */
	public static int pow1(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (b != 0) {
			res = a * pow1(a, b - 1);
		}
		return res;
	}

	/**
	 * 
	 * @param a - any integer number
	 * @param b - positive integer number
	 * @return a ^ b 
	 * no cycles 
	 * only arithmetic operations +, - 
	 * additional functions if any with the same limitation
	 */
	public static int pow(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res;
		if (b == 0) {
			res = 1;
		} else if (b == 1) {
			res = a;
		} else {
			res = multiply(a, pow(a, b - 1));
		}
		return res;
	}

	private static int multiply(int x, int y) {
		int res = 0;
		boolean isNegative = false;
		if (x == 0 || y == 0) {
			res = 0;
		} else {
			if (x < 0) {
				x = -x;
				isNegative = true;
			}
			if (y < 0) {
				y = -y;
				isNegative = !isNegative;
			}
			res = multiplyPositive(x, y);
		}
		return isNegative ? -res : res;
	}

	private static int multiplyPositive(int x, int y) {
		int res = 0;
		if (y != 0) {
			res = x + multiplyPositive(x, y - 1);
		}
		return res;
	}

	public static void displayArray(int[] array) {
		displayArray(0, array, false);
	}

	public static void displayArrayReversed(int[] array) {
		displayArray(0, array, true);

	}

	private static void displayArray(int index, int[] array, boolean isReversed) {
		if (index < array.length) {
			if (isReversed) {
				displayArray(index + 1, array, isReversed);
				System.out.print(array[index] + " ");
			} else {
				System.out.print(array[index] + " ");
				displayArray(index + 1, array, isReversed);
			}
		}
	}

	public static int sum(int[] array) {
		return sum(0, array);
	}

	private static int sum(int index, int[] array) {
		int res = 0;
		if (index < array.length) {
			res = array[index] + sum(index + 1, array);
		}
		return res;
	}

	public static void reverse(int[] array) {
		reverse(0, array.length - 1, array);
	}

	private static void reverse(int left, int right, int[] array) {
		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			reverse(left + 1, right - 1, array);
		}
	}

	/**
	 * 
	 * @param x - any integer number
	 * @return x ^ 2 
	 * allowed only arithmetic operations +, - 
	 * no cycles 
	 * no additional functions allowed 
	 * no static field;
	 */
	public static int square(int x) {
		int sum;
		if (x > 0) {
			sum = x + x - 1 + square(-x + 1);
		} else if (x < 0) {
			sum = square(-x);
		} else {
			sum = 0;
		}
		return sum;
	}

	/**
	 * 
	 * @param str    - string
	 * @param substr - substring
	 * @return true, if substr is a substring of a string, false otherwise 
	 * no cycles
	 * allowed only three String methods: 
	 * charAt(int index); 
	 * substring(int beginIndex)
	 * length()
	 */
	public static boolean isSubstring(String str, String substr) {
		boolean res;
        if (substr.length() == 0) {
            res = true; 
        } else if (str.length() < substr.length()) {
            res = false; 
        } else if (compareStrings(str, substr, 0)) {
            res = true;
        } else {
        	res = isSubstring(str.substring(1), substr);
        }
        return res;
    }

    private static boolean compareStrings(String str, String substr, int index) {
    	boolean res;
        if (index == substr.length()) {
            res = true; 
        } else if (str.charAt(index) != substr.charAt(index)) {
            res = false; 
        } else {
        	res = compareStrings(str, substr, index + 1);
        }
        return res;
    }

}
