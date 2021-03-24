package com.codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Order {
    public static void main(String[] args) {
        String s = order("");
        Order app = new Order();
        System.out.println(s);

    }

    public static String order(String words) {
        // ...
        String[] wordList = words.split(" ");
        WordVO[] wordVos = new WordVO[wordList.length];
        int arrayIndex = 0;
        for (String word : wordList) {

            for (int i = 0; i < word.length(); i++) {
                int order = 0;
                try {
                    order = Integer.parseInt(String.valueOf(word.charAt(i)));
                    wordVos[arrayIndex] = new WordVO(word, order);
                    arrayIndex++;
                    break;
                } catch (NumberFormatException e) {

                }

            }
        }

        Arrays.sort(wordVos, new Comparator<WordVO>() {
            @Override
            public int compare(WordVO o1, WordVO o2) {
                return (o1.number > o2.number ? 1 : -1);
            }
        });

        Stream<WordVO> result = Arrays.stream(wordVos);
        StringBuffer sb = new StringBuffer();
        result.forEach(item -> sb.append(Optional.ofNullable(item).orElse(new WordVO("", 0)).toString()));

        return sb.toString().strip();
    }

}

class WordVO {
    public String word;
    public int number;

    public WordVO(String word, int number) {
        this.word = word;
        this.number = number;
    }

    @Override
    public String toString() {
        return word + " ";
    }
}