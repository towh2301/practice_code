import 'dart:math';

class Solution {
  // 1. Is solved
  String longestCommonPrefix(List<String> strs) {
    String res = "";
    if (strs.isEmpty) {
      return res;
    }

    for (int i = 0; i < strs[0].length; i++) {
      String temp = strs[0][i];
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length || strs[j][i] != temp) {
          return res;
        }
      }

      res += temp;
    }
    return res;
  }

  // 2. Is not solved
  String gcdOfStrings(String str1, String str2) {
    return "";
  }

  // 3. Is solved
  List<bool> kidsWithCandies(List<int> candies, int extraCandies) {
    List<bool> result = [];

    // Find  max
    int max = 0;
    for (int i = 0; i < candies.length; i++) {
      if (candies[i] > max) max = candies[i];
    }

    for (int i = 0; i < candies.length; i++) {
      int temp = candies[i] + extraCandies;
      if (temp >= max) {
        result.add(true);
      } else {
        result.add(false);
      }
    }
    return result;
  }

  // 4. Is solved
  String reverseWords(String s) {
    String res = "";
    List<String> list = [];
    for (int i = 0; i < s.length; i++) {
      if (i == s.length - 1 && s[i] != " ") {
        res += s[i];
        list.add(res);
        break;
      }
      if (s[i] == " " && res.isNotEmpty) {
        list.add(res);
        res = "";
        continue;
      } else {
        if (s[i] != " ") {
          res += s[i];
        }
      }
    }

    res = "";
    for (int i = list.length - 1; i >= 0; i--) {
      if (i == 0) {
        res += list[i];
      } else {
        res += "${list[i]} ";
      }
    }
    return res;
  }

  // 5. In progress
  int maxArea(List<int> height) {
    int max = 0;

    // Go to next with smaller side
    int i = 0;
    int j = height.length - 1;
    while (i < j) {
      int temp = min(height[i], height[j]) * (j - i);
      if (max < temp) max = temp;

      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }

    return max;
  }
}
