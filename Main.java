package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    public static void easy() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int r = in.nextInt();
            int g = in.nextInt();
            int b = in.nextInt();
            long min = 9223372036854775807L;
            long[] r_array = new long[r];
            long[] g_array = new long[g];
            long[] b_array = new long[b];
            for(int j = 0; j < r; j++) {
                r_array[j] = in.nextLong();
            }
            for(int k = 0; k < g; k++) {
                g_array[k] = in.nextLong();
            }
            for(int m = 0; m < b; m++) {
                b_array[m] = in.nextLong();
            }
            for(int j = 0; j < r; j++) {
                for(int k = 0; k < g; k++) {
                    for(int m = 0; m < b; m++) {
                        long a = ((r_array[j] - g_array[k]) * (r_array[j] - g_array[k])) + ((g_array[k] - b_array[m]) * (g_array[k] - b_array[m])) + ((b_array[m] - r_array[j]) * (b_array[m] - r_array[j]));
                        if(a < min)
                            min = a;
                    }
                }
            }
            System.out.println(min);
        }
    }

    public static void main(String[] args) throws Exception {
        SortedList link = new SortedList();
        //easy();

        /*
            1) for 10000 random elements average sort time
                1.1) bubble - ~ 377.8 ms
                1.2) selection ~ 108.2
                1.3) insert ~ 64.4 ms
            2) for 100000 random elements average sort time
                1.1) bubble - ~ 24 seconds
                1.2) selection ~ 6.9 seconds
                1.3) insert ~ 3.9 seconds
            All these sorts have O(N^2) difficulty and rely on execution time the best one is insert sort
         */

        ArraySorts array;
        int size = 10000;
        array = new ArraySorts(size);
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            int n = (int)(java.lang.Math.random() * (size - 1));
            link.insertFirst(n);
            //array.insert(n);
        }
/*        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        long start = System.currentTimeMillis();
        */
        //  1`array.insertSort();
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }

    // https://www.codewars.com/kata/55c45be3b2079eccff00010f
    public static String order(String words) {
        if(words.length() == 0) {
            return "";
        }
        String[] splitted_words = words.split(" ");
        String[] words_with_order = new String[splitted_words.length];
        Pattern numbers = Pattern.compile("-?\\d+");

        for (String word : splitted_words) {
            Matcher m = numbers.matcher(word);
            while (m.find()) {
                words_with_order[Integer.parseInt(m.group()) - 1] = word;
            }
        }
        return String.join(" ", words_with_order);
    }

    // https://www.codewars.com/kata/5648b12ce68d9daa6b000099
    public static int countPassengers(ArrayList<int[]> stops) {
        short count = 0;
        for (int[] i : stops) {
            count += i[0] - i[1];
        }
        return count;
    }

    // https://www.codewars.com/kata/5715eaedb436cf5606000381
    public static int sum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            if (value > 0) {
                sum += value;
            }
        }
        return sum;
    }

    // https://www.codewars.com/kata/57a0e5c372292dd76d000d7e
    public static String repeatStr(final int repeat, final String string) {
        String result = "";
        for(int i = 0; i < repeat; i++) {
            result = result.concat(string);
        }
        return result;
    }

    // https://www.codewars.com/kata/5259b20d6021e9e14c0010d4
    public static String reverseWords(final String original) {
        String[] array = original.split(" ");
        Stack<Character> st=new Stack<Character>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != ' ') {
                st.push(original.charAt(i));
            }
            else {
                while (!st.empty()) {
                    result.append(st.pop());
                }
                result.append(" ");
            }
        }
        // the last word
        while (!st.empty()) {
            result.append(st.pop());
        }
        return result.toString();
    }

    // https://www.codewars.com/kata/541c8630095125aba6000c00
    public static int digital_root(int n) {
        int result = 0;
        short count = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
            count++;
        }
        if(count > 1)
            return digital_root(result);
        return result;
    }

    // https://www.codewars.com/kata/546e2562b03326a88e000020
    public static int squareDigits(int n) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> st = new Stack<Integer>();
        while (n > 0) {
            st.push((n % 10) * (n % 10));
            n /= 10;
        }
        while(!st.empty()) {
            result.append(st.pop());
        }
        return Integer.parseInt(String.valueOf(result));
    }

    // https://www.codewars.com/kata/5656b6906de340bd1b0000ac
    public static String unique_sorted_concatenated (String s1, String s2) {
        char[] letters = s1.concat(s2).toCharArray();
        Arrays.sort(letters);
        StringBuilder unique_letters = new StringBuilder();
        for(int i = 0; i < letters.length - 1; i++) {
            if(letters[i] != letters[i + 1]){
                unique_letters.append(letters[i]);
            }
        }
        unique_letters.append(letters[letters.length - 1]);
        return unique_letters.toString();
    }

    // https://www.codewars.com/kata/5277c8a221e209d3f6000b56
    public static boolean isBracesStringValid(String braces) {
        Stack<Character> st = new Stack<>();
        for(short i = 0; i < braces.length(); i++) {
            if(braces.charAt(i) == '(' || braces.charAt(i) == '{' || braces.charAt(i) == '[') {
                st.push(braces.charAt(i));
            }
            if(braces.charAt(i) == ')' || braces.charAt(i) == '}' || braces.charAt(i) == ']') {
                if(st.empty())
                    return false;
                char last_stack_element = st.pop();
                if( (last_stack_element == '(' && braces.charAt(i) != ')') ||
                    (last_stack_element == '{' && braces.charAt(i) != '}') ||
                    (last_stack_element == '[' && braces.charAt(i) != ']') )  {
                    return false;
                }
            }
        }
        return st.empty();
    }
    
}
