package com.github.wnebyte.jargs;

import java.io.PrintStream;
import java.util.Collection;

import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.exception.*;

/**
 * This class is used to specify configuration options for instances of {@link ArgsParser}.
 */
public class Configuration {

    /*
    ###########################
    #      STATIC FIELDS      #
    ###########################
    */

    /**
     * Default impl
     */
    public static final Formatter<Collection<Argument>> DEFAULT_HELP_FORMATTER
            = new HelpFormatter();

    /**
     * Default impl.
     */
    public static final Formatter<TypeConversionException> DEFAULT_TYPE_CONVERSION_EXCEPTION_FORMATTER =
            new Formatter<TypeConversionException>() {
                @Override
                public String apply(TypeConversionException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<NoSuchArgumentException> DEFAULT_NO_SUCH_ARGUMENT_EXCEPTION_FORMATTER =
            new Formatter<NoSuchArgumentException>() {
                @Override
                public String apply(NoSuchArgumentException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<MissingArgumentValueException> DEFAULT_MISSING_ARGUMENT_VALUE_EXCEPTION_FORMATTER =
            new Formatter<MissingArgumentValueException>() {
                @Override
                public String apply(MissingArgumentValueException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<MalformedArgumentException> DEFAULT_MALFORMED_ARGUMENT_EXCEPTION_FORMATTER =
            new Formatter<MalformedArgumentException>() {
                @Override
                public String apply(MalformedArgumentException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<MissingArgumentException> DEFAULT_MISSING_ARGUMENT_EXCEPTION_FORMATTER =
            new Formatter<MissingArgumentException>() {
                @Override
                public String apply(MissingArgumentException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
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

    private PrintStream out = System.out;

    private PrintStream err = System.err;

    private boolean exit = true;

    private Formatter<Collection<Argument>> helpFormatter
            = DEFAULT_HELP_FORMATTER;

    private Formatter<TypeConversionException> typeConversionExceptionFormatter =
            DEFAULT_TYPE_CONVERSION_EXCEPTION_FORMATTER;

    private Formatter<NoSuchArgumentException> noSuchArgumentExceptionFormatter =
            DEFAULT_NO_SUCH_ARGUMENT_EXCEPTION_FORMATTER;

    private Formatter<MissingArgumentValueException> missingArgumentValueExceptionFormatter =
            DEFAULT_MISSING_ARGUMENT_VALUE_EXCEPTION_FORMATTER;

    private Formatter<MalformedArgumentException> malformedArgumentExceptionFormatter =
            DEFAULT_MALFORMED_ARGUMENT_EXCEPTION_FORMATTER;

    private Formatter<MissingArgumentException> missingArgumentExceptionFormatter =
            DEFAULT_MISSING_ARGUMENT_EXCEPTION_FORMATTER;

    private Formatter<ParseException> parseExceptionFormatter
            = DEFAULT_PARSE_EXCEPTION_FORMATTER;

    /*
    ###########################
    #          SETTERS        #
    ###########################
    */

    public Configuration setOut(PrintStream out) {
        if (out != null) {
            this.out = out;
        }
        return this;
    }

    public Configuration setErr(PrintStream err) {
        if (err != null) {
            this.err = err;
        }
        return this;
    }

    /**
     * Specifies whether {@link System#exit(int)} should be called after failing or help.
     * @param value a boolean.
     * @return this (for chaining).
     */
    public Configuration setExit(boolean value) {
        this.exit = value;
        return this;
    }

    public Configuration setHelpFormatter(Formatter<Collection<Argument>> formatter) {
        if (formatter != null) {
            this.helpFormatter = formatter;
        }
        return this;
    }

    public Configuration setTypeConversionExceptionFormatter(Formatter<TypeConversionException> formatter) {
        if (formatter != null) {
            this.typeConversionExceptionFormatter = formatter;
        }
        return this;
    }

    public Configuration setNoSuchArgumentExceptionFormatter(Formatter<NoSuchArgumentException> formatter) {
        if (formatter != null) {
            this.noSuchArgumentExceptionFormatter = formatter;
        }
        return this;
    }

    public Configuration setMissingArgumentValueExceptionFormatter(Formatter<MissingArgumentValueException> formatter) {
        if (formatter != null) {
            this.missingArgumentValueExceptionFormatter = formatter;
        }
        return this;
    }

    public Configuration setMalformedArgumentExceptionFormatter(Formatter<MalformedArgumentException> formatter) {
        if (formatter != null) {
            this.malformedArgumentExceptionFormatter = formatter;
        }
        return this;
    }

    public Configuration setMissingArgumentExceptionFormatter(Formatter<MissingArgumentException> formatter) {
        if (formatter != null) {
            this.missingArgumentExceptionFormatter = formatter;
        }
        return this;
    }

    /*
    ###########################
    #          GETTERS        #
    ###########################
    */

    public PrintStream out() {
        return out;
    }

    public PrintStream err() {
        return err;
    }

    public boolean isExit() {
        return exit;
    }

    public Formatter<Collection<Argument>> getHelpFormatter() {
        return helpFormatter;
    }
    
    public Formatter<TypeConversionException> getTypeConversionExceptionFormatter() {
        return typeConversionExceptionFormatter;
    }
    
    public Formatter<NoSuchArgumentException> getNoSuchArgumentExceptionFormatter() {
        return this.noSuchArgumentExceptionFormatter;
    }
    
    public Formatter<MissingArgumentValueException> getMissingArgumentValueExceptionFormatter() {
        return this.missingArgumentValueExceptionFormatter;
    }
    
    public Formatter<MalformedArgumentException> getMalformedArgumentExceptionFormatter() {
        return this.malformedArgumentExceptionFormatter;
    }
    
    public Formatter<MissingArgumentException> getMissingArgumentExceptionFormatter() {
        return this.missingArgumentExceptionFormatter;
    }
}