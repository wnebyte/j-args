package com.github.wnebyte.jargs;

import com.github.wnebyte.jarguments.ArgumentCollectionParser;
import com.github.wnebyte.jarguments.ArgumentCollectionPatternGenerator;
import com.github.wnebyte.jarguments.exception.ConstraintException;
import com.github.wnebyte.jarguments.exception.ParseException;
import com.github.wnebyte.jargs.util.Objects;

import java.util.regex.Pattern;

public class ArgumentContext {

    private final Configuration config;

    private final Pattern pattern;

    public ArgumentContext(final Configuration config) {
        if (Objects.isNull(config)) {
            throw new IllegalArgumentException(
                    "Configuration must not be null"
            );
        }
        if (Objects.isNull(config.getArguments())) {
            throw new IllegalArgumentException(
                    "Configuration's arguments must not be null"
            );
        }
        this.config = config;
        ArgumentCollectionPatternGenerator generator =
                new ArgumentCollectionPatternGenerator(config.getArguments());
        generator.setInclSol(true);
        generator.setInclEol(true);
        generator.setRmlws(true);
        this.pattern = generator.generatePattern();
    }

    public Args parse(final String[] args) {
        return parse(String.join("", args));
    }

    public Args parse(final String input) {
        if (isHelpMatch(input)) {
            handleHelp();
            exit();
        }
        else if (isArgumentsMatch(input)) {
            try {
                ArgumentCollectionParser parser = new ArgumentCollectionParser(config.getArguments());
                return Args.newInstance(config.getArguments(), parser.parse(input));
            }
            catch (ConstraintException e) {
                handleConstraintException(e);
            }
            catch (ParseException e) {
                handleParseException(e);
            }
        } else {
            handleNoMatch(input);
        }
        exit();
        return null;
    }

    private void handleNoMatch(final String input) {
        if (config.getNoMatchHandler() != null) {
            config.getNoMatchHandler().accept(input);
        }
        else if (config.getWriter() != null) {
            config.getWriter().println(config.getNoMatchFormatter().apply(input));
        }
    }

    private void handleHelp() {
        if (config.getHelpHandler() != null) {
            config.getHelpHandler().accept(config.getArguments());
        }
        else if (config.getWriter() != null) {
            config.getWriter().println(config.getHelpFormatter().apply(config.getArguments()));
        }
    }

    private void handleParseException(final ParseException e) {
        if (config.getParseExceptionHandler() != null) {
            config.getParseExceptionHandler().accept(e);
        }
        else if (config.getWriter() != null) {
            config.getWriter().println(config.getParseExceptionFormatter().apply(e));
        }
    }

    private void handleConstraintException(final ConstraintException e) {
        if (config.getConstraintExceptionHandler() != null) {
            config.getConstraintExceptionHandler().accept(e);
        }
        else if (config.getWriter() != null) {
            config.getWriter().println(config.getConstraintExceptionFormatter().apply(e));
        }
    }

    private void exit() {
        if (config.getExit()) {
            System.exit(0);
        }
    }

    private boolean isArgumentsMatch(final String input) {
        return pattern.matcher(input).matches();
    }

    private boolean isHelpMatch(final String input) {
        return config.getHelpPattern().matcher(input).matches();
    }
}