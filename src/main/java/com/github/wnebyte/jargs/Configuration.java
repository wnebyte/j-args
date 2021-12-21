package com.github.wnebyte.jargs;

import java.util.Collection;
import java.util.regex.Pattern;
import com.github.wnebyte.jargs.io.IWriter;
import com.github.wnebyte.jargs.io.Writer;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.exception.ParseException;

public class Configuration {

    /*
    ###########################
    #      STATIC FIELDS      #
    ###########################
    */

    public static final Formatter<Collection<Argument>> DEFAULT_HELP_FORMATTER = new HelpFormatter();

    public static final Formatter<ParseException> DEFAULT_PARSE_EXCEPTION_FORMATTER =
            new Formatter<ParseException>() {
                @Override
                public String apply(ParseException e) {
                    return e.getMessage();
                }
            };

    /*
    ###########################
    #          FIELDS         #
    ###########################
    */

    private Formatter<Collection<Argument>> helpFormatter = DEFAULT_HELP_FORMATTER;

    private Formatter<ParseException> parseExceptionFormatter = DEFAULT_PARSE_EXCEPTION_FORMATTER;

    private IWriter writer = new Writer();

    private Pattern helpPattern = Pattern.compile("^(--help|-h)$");

    /*
    ###########################
    #          SETTERS        #
    ###########################
    */

    public Configuration setHelpFormatter(Formatter<Collection<Argument>> formatter) {
        if (formatter != null) {
            this.helpFormatter = formatter;
        }
        return this;
    }

    public Configuration setParseExceptionFormatter(Formatter<ParseException> formatter) {
        if (formatter != null) {
            this.parseExceptionFormatter = formatter;
        }
        return this;
    }

    public Configuration setWriter(IWriter writer) {
        if (writer != null) {
            this.writer = writer;
        }
        return this;
    }

    public Configuration setHelpPattern(String regex) {
        if (regex != null) {
            this.helpPattern = Pattern.compile(regex);
        }
        return this;
    }

    /*
    ###########################
    #          GETTERS        #
    ###########################
    */

    protected Formatter<Collection<Argument>> getHelpFormatter() {
        return helpFormatter;
    }

    protected Formatter<ParseException> getParseExceptionFormatter() {
        return parseExceptionFormatter;
    }

    protected Pattern getHelpPattern() {
        return helpPattern;
    }

    protected IWriter getWriter() {
        return writer;
    }
}