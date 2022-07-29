package com.github.wnebyte.jargs;

import java.util.Set;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.ContextView;
import com.github.wnebyte.jarguments.Formatter;
import com.github.wnebyte.jarguments.exception.*;
import com.github.wnebyte.jarguments.parser.AbstractParser;
import com.github.wnebyte.jarguments.parser.Parser;
import com.github.wnebyte.jarguments.util.Objects;
import com.github.wnebyte.jarguments.util.Strings;
import com.github.wnebyte.jarguments.util.TokenSequence;

@SuppressWarnings("resource")
public class ArgsParser implements AbstractArgsParser {

    /*
    ###########################
    #      STATIC METHODS     #
    ###########################
    */

    static ContextView toContextView(String description, Set<Argument> arguments) {
        return (description == null) ? ContextView.of(arguments) : ContextView.of(description, arguments);
    }

    static boolean isHelp(TokenSequence tokens) {
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

    private String description;

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

    public ArgsParser setArguments(Set<Argument> arguments) {
        this.arguments = arguments;
        return this;
    }

    public ArgsParser setDescription(String description) {
        this.description = description;
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
            Formatter<ContextView> formatter
                    = conf.getHelpFormatter();
            conf.out().println(formatter.apply(toContextView(description, arguments)));

            if (conf.isExit()) {
                System.exit(0);
            } else {
                return null;
            }
        }

        try {
            Object[] values = parser.parse(input, tokens, arguments);
            return Args.newInstance(arguments, values);
        }
        catch (NoSuchArgumentException e) {
            Formatter<NoSuchArgumentException> formatter
                    = conf.getFormatter(NoSuchArgumentException.class);
            conf.err().println(formatter.apply(e));
        }
        catch (MalformedArgumentException e) {
            Formatter<MalformedArgumentException> formatter
                    = conf.getFormatter(MalformedArgumentException.class);
            conf.err().println(formatter.apply(e));
        }
        catch (MissingArgumentException e) {
            Formatter<MissingArgumentException> formatter
                    = conf.getFormatter(MissingArgumentException.class);
            conf.err().println(formatter.apply(e));
        }
        catch (TypeConversionException e) {
            Formatter<TypeConversionException> formatter
                    = conf.getFormatter(TypeConversionException.class);
            conf.err().println(formatter.apply(e));
        }
        catch (ConstraintException e) {
            Formatter<ConstraintException> formatter
                    = conf.getFormatter(ConstraintException.class);
            conf.err().println(formatter.apply(e));
        }
        catch (Exception ignored) { }

        Formatter<ContextView> formatter
                = conf.getHelpFormatter();
        conf.out().println(formatter.apply(toContextView(description, arguments)));

        if (conf.isExit()) {
            System.exit(0);
        } else {
            return null;
        }

        return null;
    }
}
