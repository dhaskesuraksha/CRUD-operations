package com.Test.controller;

import java.util.Collections;
import java.util.List;

public class PaginationUtils {
    public static <T> List<T> getPage(List<T> list, int pageNumber, int pageSize) {
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        if (startIndex > endIndex) {
            return Collections.emptyList();
        }
        return list.subList(startIndex, endIndex);
    }
}
