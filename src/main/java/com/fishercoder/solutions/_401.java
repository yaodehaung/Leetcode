package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.List;

public class _401 {

  public static class Solution1 {
    public List<String> readBinaryWatch(int num) {
      List<String> times = new ArrayList<>();
      for (int h = 0; h < 12; h++) {
        for (int m = 0; m < 60; m++) {
          if (Integer.bitCount(h * 64 + m) == num) {
            times.add(
                String.format(
                    "%d:%02d",
                    h,
                    m)); // %02 means to pad this two-digit decimal number on the left with zeroes
          }
        }
      }
      return times;
    }
  }

  public static class Solution2 {

    /*
     *
     */
    int[] arr = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    /**
     * @param arr The new bundle name.
     * @param postion
     * @param hours
     * @param minutes
     * @param limit
     * @param rest
     */
    public void backtrack(
        int[] arr, int postion, int hours, int minutes, int limit, List<String> rest) {

      // when num(limit) reaches to the zero, store hours and minutes into result list
      if (limit == 0) {
        // during recursion we might get e.g 4 + 8 = 12 hours which we must skip because max hour
        // value could be 11
        if (hours <= 11 && minutes <= 59) {
          StringBuilder builder = new StringBuilder();
          builder.append(hours).append(":").append(minutes <= 9 ? "0" + minutes : minutes);
          result.add(builder.toString());
        }
        return;
      }

      // standard backtracking solution add new value do recursion and then remove it
      for (int i = position; i < arr.length; i++) {
        if (isHour(i)) hours += arr[i];
        else minutes += arr[i];

        backtrack(arr, i + 1, hours, minutes, limit - 1, result);

        if (isHour(i)) hours -= arr[i];
        else minutes -= arr[i];
      }
    }

    public List<String> readBinaryWatch(int num) {

      List<String> result = new ArrayList<>();

      // range 0-3 are hours and range 4-9 are minutes
      // index 0 ~ 3 representation hours ,
      // index 4 ~ 9 representation minutes

      backtrack(arr, 0, 0, 0, num, result);
      return result;
    }

    /**
     * Check if the position is represation into arr[].
     *
     * @param arr The new bundle name.
     * @return <code>true</code> if position represtation hour
     */
    public boolean isHour(int position) {
      return position >= 0 && position <= 3;
    }
  }
}
