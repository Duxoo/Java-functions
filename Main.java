package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    public static void hard() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        double mean = sum / (double)n;
        double distance = 0;

        for (int i = 0; i < n; i++) {
            distance += Math.pow((array[i] - mean), 2);
        }

        System.out.printf("%.1f", Math.sqrt(distance / n));
    }
    
    public static void main(String[] args) {
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
        for(int i = 0; i < size; i++) {
            int n = (int)(java.lang.Math.random() * (size - 1));
            array.insert(n);
        }
        array.show();
        long start = System.currentTimeMillis();
        array.quickSort();
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis + " ms");
        array.show();
    }

    public static int pow(int n, int m) {
        if (m == 1)
            return n;
        return pow(n * n, m / 2);
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

    public static String camelCase(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i != 0 && Character.isUpperCase(input.charAt(i))
                    && !Character.isWhitespace(input.charAt(i - 1))) {
                result.append(" ");
                result.append(input.charAt(i));
            } else {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    public static String[] solution(String s) {
        int n = s.length() % 2 == 0 ? s.length() / 2 : (s.length() / 2) + 1;
        String[] result = new String[n];
        int counter = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            result[i] = s.charAt(counter++) + "" + s.charAt(counter++);
        }
        if (s.length() % 2 != 0) {
            result[n - 1] = s.charAt(s.length() - 1) + "_";
        }
        return result;
    }

    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.charAt(0) == '(' && phoneNumber.charAt(4) == ')' && phoneNumber.charAt(5) == ' ' && phoneNumber.charAt(9) == '-';
    }
    
}
