package com.github.wnebyte.jargs;

public abstract class AbstractArgsParser {

    public abstract Args parse(String input);

    public abstract Args parse(String[] input);
}
