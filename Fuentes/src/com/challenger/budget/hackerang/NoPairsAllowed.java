package com.challenger.budget.hackerang;

import java.util.Arrays;
import java.util.List;

public class NoPairsAllowed {

	public static void main(String[] args) {
		List<String> list = List.of("abbwwwwwss", "boookk","abc", "heeloooooo");
		int[] min = minimalOperations(list.toArray(new String[0]));
		System.out.println(Arrays.toString(min));
	}

	static int[] minimalOperations(String[] words) {
		int[] changes = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			changes[i] = calculateMinimalOperation(words[i]);
		}
		return changes;
	}

	private static int calculateMinimalOperation(String word) {
		char[] chars = word.toCharArray();
		int repetitions = 0;
		int changes = 0;
		for (int i = 0, j = 1; i < chars.length; i++, j++) {
			if (j < chars.length && chars[i] == chars[j]) {
				repetitions++;
			} else {
				if (i == chars.length - 1 && repetitions > 0) {
					repetitions++;
				}
				changes += calculateChanges(repetitions);
				repetitions = 0;
			}
		}
		return changes;
	}

	private static int calculateChanges(int repetitions) {
		int sum = repetitions % 2 == 0 ? repetitions : ++repetitions;
		return sum / 2;
	}


}
