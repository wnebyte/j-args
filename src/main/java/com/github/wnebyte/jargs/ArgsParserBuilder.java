package com.github.wnebyte.jargs;

import java.util.Set;
import com.github.wnebyte.jarguments.Argument;

public class ArgsParserBuilder {

    private ArgsParserConfiguration conf = null;

    private Set<Argument> arguments = null;

    public ArgsParserBuilder setConfiguration(ArgsParserConfiguration conf) {
        this.conf = conf;
        return this;
    }

    public ArgsParserBuilder setArguments(Set<Argument> arguments) {
        this.arguments = arguments;
        return this;
    }

    public ArgsParser build() {
        return new ArgsParser(conf, arguments);
    }
}
