package com.careercompass.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListConverter {

    public static String toString(List<String> list) {

        if (list == null || list.isEmpty()) {
            return "";
        }

        return String.join(",", list);

    }

    public static List<String> toList(String value) {

        if (value == null || value.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.asList(value.split(","));

    }

}