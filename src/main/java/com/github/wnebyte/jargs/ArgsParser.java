package com.github.wnebyte.jargs;

import java.util.Set;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.exception.*;
import com.github.wnebyte.jarguments.parser.AbstractParser;
import com.github.wnebyte.jarguments.parser.Parser;
import com.github.wnebyte.jarguments.util.Objects;
import com.github.wnebyte.jarguments.util.Strings;
import com.github.wnebyte.jarguments.util.TokenSequence;

public class ArgsParser implements AbstractArgsParser {

    public static class Configuration {

    }

    /*
    ###########################
    #      STATIC METHODS     #
    ###########################
    */

    boolean isHelp(TokenSequence tokens) {
        return (tokens != null) && (tokens.size() == 1) &&
                (tokens.get(0).equals("--help") || tokens.get(0).equals("-h"));
    }

    /*
    ###########################
    #          FIELDS         #
    ###########################
    */

    private final ArgsParserConfiguration conf;

    private final AbstractParser parser;

    private Set<Argument> arguments;

    /*
    ###########################
    #       CONSTRUCTORS      #
    ###########################
    */

    public ArgsParser() {
        this(null, null);
    }

    public ArgsParser(ArgsParserConfiguration conf) {
        this(conf, null);
    }

    public ArgsParser(Set<Argument> arguments) {
        this(null, arguments);
    }

    public ArgsParser(ArgsParserConfiguration conf, Set<Argument> arguments) {
        this.conf = Objects.requireNonNullElseGet(conf, ArgsParserConfiguration::new);
        this.arguments = arguments;
        this.parser = new Parser();
    }

    /*
    ###########################
    #         METHODS         #
    ###########################
    */

    @Override
    public Args parse(String[] input) {
        String s = String.join(Strings.WHITESPACE, (input == null) ? new String[0] : input);
        return parse(s);
    }

    @Override
    public Args parse(String input) {
        if (arguments == null || input == null) {
            throw new NullPointerException(
                    "Arguments & Input have to be non-null."
            );
        }
        TokenSequence tokens = TokenSequence.tokenize(input);

        if (isHelp(tokens)) {
            conf.out().println(conf.getHelpFormatter().apply(arguments));

            if (conf.isExit()) {
                System.exit(0);
            } else {
                return null;
            }
        }

        try {
            parser.parse(input, tokens, arguments);
            return Args.newInstance(arguments, parser.initialize());
        }
        catch (TypeConversionException e) {
            conf.err().println(conf.getTypeConversionFormatter().apply(e));
        }
        catch (NoSuchArgumentException e) {
            conf.err().println(conf.getNoSuchArgumentFormatter().apply(e));
        }
        catch (MalformedArgumentException e) {
            conf.err().println(conf.getMalformedArgumentFormatter().apply(e));
        }
        catch (MissingArgumentException e) {
            conf.err().println(conf.getMissingArgumentFormatter().apply(e));
        }
        catch (ConstraintException e) {
            conf.err().println(conf.getConstraintExceptionFormatter().apply(e));
        }
        catch (Exception e) {
            conf.err().println(e.getMessage());
        }

        conf.out().println(conf.getHelpFormatter().apply(arguments));

        if (conf.isExit()) {
            System.exit(0);
        } else {
            return null;
        }

        return null;
    }

    public ArgsParser setArguments(Set<Argument> arguments) {
        this.arguments = arguments;
        return this;
    }
}
