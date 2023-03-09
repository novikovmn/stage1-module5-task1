package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            boolean flag = true;
            for (String str: strings) {
                String firstUpperCaseLetter = str.substring(0, 1).toUpperCase();
                String curLetter = str.substring(0, 1);
                if (!curLetter.equals(firstUpperCaseLetter)) {
                    return !flag;
                }
            }
            return flag;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> copy = new ArrayList<>(list);
            for (Integer num: copy) {
                if (num % 2 == 0){
                    list.add(num);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            String regex = " |\\.";
            List<String> result = new ArrayList<>();
            for (String str: values) {
                String[] words = str.split(regex);
                String upperCaseLetter = str.substring(0, 1).toUpperCase();
                String curLetter = str.substring(0, 1);
                if (words.length > 3) {
                    if (curLetter.equals(upperCaseLetter) && str.endsWith(".")) {
                        result.add(str);
                    }
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> result = new HashMap<>();
            for (String str : strings) {
                result.put(str, str.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list1);
            list3.addAll(list2);
            return list3;
        };
    }
}
