package com.github.wnebyte.jargs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.exception.ConstraintException;
import com.github.wnebyte.jarguments.exception.ParseException;

/**
 * This class represents a set of configurations to be passed to an instance of the {@link ArgumentContext} class.
 */
public class Configuration {

    private Consumer<List<Argument>> helpHandler;

    private Function<List<Argument>, String> helpFormatter = new Function<List<Argument>, String>() {
        @Override
        public String apply(final List<Argument> arguments) {
            StringBuilder stringBuilder = new StringBuilder("Usage: ");
            stringBuilder.append(Arrays.toString(arguments.toArray()));
            return new String(stringBuilder);
        }
    };

    private Consumer<ParseException> parseExceptionHandler;

    private Function<ParseException, String> parseExceptionFormatter = new Function<ParseException, String>() {
        @Override
        public String apply(final ParseException e) {
            if (e.getArgument() != null) {
                return "[" + String.join(", ", e.getArgument().getNames()) + "] " +
                        "could not be initialized with val: " + e.getValue();
            } else {
                return e.getMessage();
            }
        }
    };

    private Consumer<ConstraintException> constraintExceptionHandler;

    private Function<ConstraintException, String> constraintExceptionFormatter = Throwable::getMessage;

    private Consumer<String> noMatchHandler;

    private Function<String, String> noMatchFormatter = new Function<String, String>() {
        @Override
        public String apply(final String s) {
            return helpFormatter.apply(getArguments());
        }
    };

    private List<Argument> arguments;

    private IWriter writer = new Writer();

    private Pattern helpPattern = Pattern.compile("^(-h|--help)$");

    private boolean exit = true;

    public Configuration() {}

    public Configuration(final List<Argument> arguments) {
        setArguments(arguments);
    }

    public Configuration setArguments(final List<Argument> arguments) {
        if (arguments != null) {
            this.arguments = arguments;
        }
        return this;
    }

    public Configuration setWriter(final IWriter writer) {
        if (writer != null) {
            this.writer = writer;
        }
        return this;
    }

    public IWriter getWriter() {
        return writer;
    }

    public Configuration setHelpHandler(final Consumer<List<Argument>> handler) {
        this.helpHandler = handler;
        return this;
    }

    public Consumer<List<Argument>> getHelpHandler() {
        return helpHandler;
    }

    public Configuration setHelpFormatter(final Function<List<Argument>, String> formatter) {
        if (formatter != null) {
            this.helpFormatter = formatter;
        }
        return this;
    }

    public Function<List<Argument>, String> getHelpFormatter() {
        return helpFormatter;
    }

    public Configuration setParseExceptionHandler(final Consumer<ParseException> handler) {
        this.parseExceptionHandler = handler;
        return this;
    }

    public Consumer<ParseException> getParseExceptionHandler() {
        return parseExceptionHandler;
    }

    public Configuration setParseExceptionFormatter(final Function<ParseException, String> formatter) {
        if (formatter != null) {
            this.parseExceptionFormatter = formatter;
        }
        return this;
    }

    public Function<ParseException, String> getParseExceptionFormatter() {
        return parseExceptionFormatter;
    }

    public Configuration setConstraintExceptionHandler(final Consumer<ConstraintException> handler) {
        this.constraintExceptionHandler = handler;
        return this;
    }

    public Consumer<ConstraintException> getConstraintExceptionHandler() {
        return constraintExceptionHandler;
    }

    public Configuration setConstraintExceptionFormatter(final Function<ConstraintException, String> formatter) {
        if (formatter != null) {
            this.constraintExceptionFormatter = formatter;
        }
        return this;
    }

    public Function<ConstraintException, String> getConstraintExceptionFormatter() {
        return constraintExceptionFormatter;
    }

    public Configuration setNoMatchHandler(final Consumer<String> handler) {
        this.noMatchHandler = handler;
        return this;
    }

    public Consumer<String> getNoMatchHandler() {
        return noMatchHandler;
    }

    public Configuration setNoMatchFormatter(final Function<String, String> formatter) {
        if (formatter != null) {
            this.noMatchFormatter = formatter;
        }
        return this;
    }

    public Function<String, String> getNoMatchFormatter() {
        return noMatchFormatter;
    }

    public Configuration setHelpPattern(final String pattern) {
        if (pattern != null) {
            this.helpPattern = Pattern.compile(pattern);
        }
        return this;
    }

    public Pattern getHelpPattern() {
        return helpPattern;
    }

    public Configuration exit(final boolean value) {
        this.exit = value;
        return this;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public boolean getExit() {
        return exit;
    }
}