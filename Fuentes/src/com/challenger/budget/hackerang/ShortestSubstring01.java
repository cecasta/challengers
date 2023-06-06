package com.challenger.budget.hackerang;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
public class ShortestSubstring01 {



		public static void main(String[] args) {
			String s = "abcbbk";
			System.out.println(findShortestSubstring(s));
		}

		public static int findShortestSubstring(String s) {
			String[] duplicateChars = getDuplicateChars(s);
			List<String> combinations = differentFlagPermutations(duplicateChars);
			Set<String> set = getUniqueChars(s);
			Map<String, String> map = combinations.stream().distinct().filter(s::contains)
					.collect(Collectors.toMap(k -> k, v -> s.replace(v, "")));
			OptionalInt op = map.entrySet().stream().filter(e -> set.equals(getUniqueChars(e.getValue())))
					.mapToInt(e -> e.getKey().length()).max();
			return op.isPresent() ? op.getAsInt() : 0;
		}

		private static Set<String> getUniqueChars(String s) {
			ArrayList<Character> list = new ArrayList<Character>();
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				list.add(chars[i]);
			}
			return list.stream().distinct().map(c -> new String(c.toString())).collect(Collectors.toSet());
		}

		private static String[] getDuplicateChars(String value) {
			char[] chars = value.toCharArray();
			List<Character> lUnique = new ArrayList<>();
			List<Character> lDuplicate = new ArrayList<>();

			for (int i = 0; i < chars.length; i++) {
				if (!lUnique.contains(chars[i])) {
					lUnique.add(chars[i]);
				} else {
					lDuplicate.add(chars[i]);
				}
			}
			return lDuplicate.stream().map(c -> new String(c.toString())).collect(Collectors.toList())
					.toArray(new String[0]);
		}

		private static List<String> differentFlagPermutations(String[] arr) {
			List<String> list = new ArrayList<>();
			String[] ml = arr;
			for (int i = 0; i < ml.length; i++) {
				list.add(ml[i]);
			}
			for (int z = 0; z < arr.length - 1; z++) {
				List<String> tmp = new ArrayList<String>();
				for (int i = 0; i < arr.length; i++) {
					for (int k = 0; k < ml.length; k++) {
						if (arr[i] != ml[k]) {
							tmp.add(ml[k] + arr[i]);
							list.add(ml[k] + arr[i]);
						}
					}
				}
				ml = tmp.toArray(new String[0]);
			}
			return list;
		}

}

