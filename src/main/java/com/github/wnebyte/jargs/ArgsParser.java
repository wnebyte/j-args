package com.github.wnebyte.jargs;

import java.util.Collection;
import java.util.List;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.TokenSequence;
import com.github.wnebyte.jarguments.exception.*;
import com.github.wnebyte.jarguments.parser.AbstractParser;
import com.github.wnebyte.jarguments.parser.Parser;
import com.github.wnebyte.jarguments.util.Objects;
import com.github.wnebyte.jarguments.util.Strings;

public class ArgsParser extends AbstractArgsParser {

    /*
    ###########################
    #     UTILITY METHODS     #
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

    private final Configuration conf;

    private final AbstractParser<TokenSequence, Collection<Argument>> parser;

    private List<Argument> arguments;

    /*
    ###########################
    #       CONSTRUCTORS      #
    ###########################
    */

    public ArgsParser() {
        this(null);
    }

    public ArgsParser(Configuration conf) {
        this.conf = Objects.requireNonNullElseGet(conf, Configuration::new);
        this.parser = new Parser();
    }

    /*
    ###########################
    #         METHODS         #
    ###########################
    */

    public ArgsParser setArguments(List<Argument> arguments) {
        if (arguments != null) {
            this.arguments = arguments;
        }
        return this;
    }

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
            parser.parse(tokens, arguments);
            return Args.newInstance(
                    arguments,
                    parser.initialize()
            );
        }
        catch (TypeConversionException e) {
            conf.err().println(conf.getTypeConversionExceptionFormatter().apply(e));
        }
        catch (NoSuchArgumentException e) {
            conf.err().println(conf.getNoSuchArgumentExceptionFormatter().apply(e));
        }
        catch (MissingArgumentValueException e) {
            conf.err().println(conf.getMissingArgumentValueExceptionFormatter().apply(e));
        }
        catch (MalformedArgumentException e) {
            conf.err().println(conf.getMalformedArgumentExceptionFormatter().apply(e));
        }
        catch (MissingArgumentException e) {
            conf.err().println(conf.getMissingArgumentExceptionFormatter().apply(e));
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
}
