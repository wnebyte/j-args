package com.github.wnebyte.jargs;

import java.util.List;
import com.github.wnebyte.jarguments.Argument;

public class ArgsParser extends AbstractArgsParser {

    private List<Argument> arguments;

    private Configuration configuration = new Configuration();

    public ArgsParser() {

    }

    public ArgsParser(List<Argument> arguments) {
        this.arguments = arguments;
    }

    @Override
    public AbstractArgsParser setArguments(List<Argument> args) {
        if (args != null) {
            this.arguments = args;
        }
        return this;
    }

    @Override
    public AbstractArgsParser setConfiguration(Configuration configuration) {
        if (configuration != null) {
            this.configuration = configuration;
        }
        return this;
    }

    @Override
    public Args parse(String input) {
        if (arguments != null) {
            configuration.setArguments(arguments);
            ArgumentContext context = new ArgumentContext(configuration);
            return context.parse(input);
        }
        return null;
    }
}
