package com.github.wnebyte.jargs;

public interface AbstractArgsParser {

    Args parse(String input);

    Args parse(String[] input);
}
