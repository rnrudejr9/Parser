package com.line.parser;

import java.util.List;

public interface Parser<T> {
    T parse(String str);
    void parseToString(T obj);
}
