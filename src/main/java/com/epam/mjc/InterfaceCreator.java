package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream()
                .allMatch(word -> Character.isUpperCase(word.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll(x.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(firstLetter -> Character.isUpperCase(firstLetter.charAt(0)))
                .filter(lastLetter -> lastLetter.charAt(lastLetter.length() - 1) == '.')
                .filter(word -> word.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> resultList = new ArrayList<>(list1);
            resultList.addAll(list2);
            return resultList;
        };
    }
}
