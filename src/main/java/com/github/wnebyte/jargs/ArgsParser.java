package com.github.wnebyte.jargs;

import java.util.List;
import com.github.wnebyte.jargs.io.IWriter;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.exception.ParseException;
import com.github.wnebyte.jarguments.parser.ArgumentParser;
import com.github.wnebyte.jarguments.util.Objects;
import com.github.wnebyte.jarguments.val.ArgumentValidator;

public class ArgsParser {

    private List<Argument> args;

    private final Configuration conf;

    private final IWriter writer;

    public ArgsParser() {
        this(new Configuration());
    }

    public ArgsParser(Configuration conf) {
        this.conf = Objects.requireNonNullElseGet(conf, Configuration::new);
        this.writer = conf.getWriter();
    }

    public ArgsParser setArguments(List<Argument> args) {
        if (args != null) {
            this.args = args;
        }
        return this;
    }

    public Args parse(String input) {
        if ((args == null) || (input == null)) {
            throw new NullPointerException(
                    "Arguments & input have to be specified."
            );
        }
        if (isHelp(input)) {
            writer.println(conf.getHelpFormatter().apply(args));
            System.exit(0);
        }
        try {
            if (new ArgumentValidator(args).matches(input)) {
                Object[] values = new ArgumentParser(args).parse(input);
                return Args.newInstance(args, values);
            }
        } catch (ParseException e) {
            writer.println(conf.getParseExceptionFormatter().apply(e));
            writer.println(conf.getHelpFormatter().apply(args));
        }

        System.exit(0);
        return null;
    }

    public Args parse(String[] input) {
        return parse(String.join("", input));
    }

    private boolean isHelp(String input) {
        return conf.getHelpPattern().matcher(input).matches();
    }

}
