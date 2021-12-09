package com.github.wnebyte.jargs;

import java.util.List;
import com.github.wnebyte.jarguments.Argument;

public abstract class AbstractArgsParser {

    public abstract AbstractArgsParser setArguments(List<Argument> args);

    public abstract AbstractArgsParser setConfiguration(Configuration configuration);

    public abstract Args parse(String input);
}
