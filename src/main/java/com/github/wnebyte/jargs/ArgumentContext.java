package com.github.wnebyte.jargs;

import com.github.wnebyte.args.ArgumentParser;
import com.github.wnebyte.args.PatternCreator;
import com.github.wnebyte.args.exception.ConstraintException;
import com.github.wnebyte.args.exception.ParseException;
import java.util.regex.Pattern;

public class ArgumentContext {

    private final Configuration config;

    private final Pattern pattern;

    public ArgumentContext(final Configuration config) {
        if (config == null) {
            throw new IllegalArgumentException(
                    "Configuration must not be null"
            );
        }
        if (config.getArguments() == null) {
            throw new IllegalArgumentException(
                    "Configuration's arguments must not be null"
            );
        }
        this.config = config;
        this.pattern = new PatternCreator().create(config.getArguments());
    }

    public Args parse(final String[] args) {
        return parse(String.join("", args));
    }

    public Args parse(final String input) {
        if (matchesHelp(input)) {
            handleHelp();
            exit();
        }
        if (matches(input)) {
            try {
                return Args.newInstance(config.getArguments(), new ArgumentParser(config.getArguments()).parse(input));
            }
            catch (ParseException e) {
                handleParseException(e);
            }
            catch (ConstraintException e) {
                handleConstraintException(e);
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

    private boolean matches(final String input) {
        return pattern.matcher(input).matches();
    }

    private boolean matchesHelp(final String input) {
        return config.getHelpPattern().matcher(input).matches();
    }
}