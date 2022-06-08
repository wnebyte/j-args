package com.github.wnebyte.jargs;

import java.util.Set;
import java.io.PrintStream;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.exception.*;
import com.github.wnebyte.jarguments.util.IConsole;
import com.github.wnebyte.jarguments.formatter.Formatter;
import com.github.wnebyte.jarguments.formatter.HelpFormatter;

/**
 * This class is used to specify configuration options for instances of {@link ArgsParser}.
 */
public class ArgsParserConfiguration {

    /*
    ###########################
    #      STATIC FIELDS      #
    ###########################
    */

    /**
     * Default impl.
     */
    public static final Formatter<Set<Argument>> DEFAULT_HELP_FORMATTER
            = HelpFormatter.get();

    /**
     * Default impl.
     */
    public static final Formatter<TypeConversionException> DEFAULT_TYPE_CONVERSION_FORMATTER
            = new Formatter<TypeConversionException>() {
                @Override
                public String apply(TypeConversionException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<NoSuchArgumentException> DEFAULT_NO_SUCH_ARGUMENT_FORMATTER
            = new Formatter<NoSuchArgumentException>() {
                @Override
                public String apply(NoSuchArgumentException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<MalformedArgumentException> DEFAULT_MALFORMED_ARGUMENT_FORMATTER
            = new Formatter<MalformedArgumentException>() {
                @Override
                public String apply(MalformedArgumentException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<MissingArgumentException> DEFAULT_MISSING_ARGUMENT_FORMATTER
            = new Formatter<MissingArgumentException>() {
                @Override
                public String apply(MissingArgumentException e) {
                    return e.getMessage();
                }
            };

    /**
     * Default impl.
     */
    public static final Formatter<ConstraintException> DEFAULT_CONSTRAINT_EXCEPTION_FORMATTER
            = new Formatter<ConstraintException>() {
                @Override
                public String apply(ConstraintException e) {
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

    private Formatter<Set<Argument>> helpFormatter
            = DEFAULT_HELP_FORMATTER;

    private Formatter<TypeConversionException> typeConversionFormatter
            = DEFAULT_TYPE_CONVERSION_FORMATTER;

    private Formatter<NoSuchArgumentException> noSuchArgumentFormatter
            = DEFAULT_NO_SUCH_ARGUMENT_FORMATTER;

    private Formatter<MalformedArgumentException> malformedArgumentFormatter
            = DEFAULT_MALFORMED_ARGUMENT_FORMATTER;

    private Formatter<MissingArgumentException> missingArgumentFormatter
            = DEFAULT_MISSING_ARGUMENT_FORMATTER;

    private Formatter<ConstraintException> constraintExceptionFormatter
            = DEFAULT_CONSTRAINT_EXCEPTION_FORMATTER;

    /*
    ###########################
    #          SETTERS        #
    ###########################
    */

    public ArgsParserConfiguration setOut(PrintStream out) {
        if (out != null) {
            this.out = out;
        }
        return this;
    }

    public ArgsParserConfiguration setErr(PrintStream err) {
        if (err != null) {
            this.err = err;
        }
        return this;
    }

    public ArgsParserConfiguration setConsole(IConsole console) {
        if (console != null) {
            setOut(console.out());
            setErr(console.err());
        }
        return this;
    }

    /**
     * Specifies whether {@link System#exit(int)} should be called after failing or help.
     * @param value a boolean.
     * @return this (for chaining).
     */
    public ArgsParserConfiguration setExit(boolean value) {
        this.exit = value;
        return this;
    }

    public ArgsParserConfiguration setHelpFormatter(Formatter<Set<Argument>> formatter) {
        if (formatter != null) {
            this.helpFormatter = formatter;
        }
        return this;
    }

    public ArgsParserConfiguration setTypeConversionFormatter(Formatter<TypeConversionException> formatter) {
        if (formatter != null) {
            this.typeConversionFormatter = formatter;
        }
        return this;
    }

    public ArgsParserConfiguration setNoSuchArgumentFormatter(Formatter<NoSuchArgumentException> formatter) {
        if (formatter != null) {
            this.noSuchArgumentFormatter = formatter;
        }
        return this;
    }

    public ArgsParserConfiguration setMalformedArgumentFormatter(Formatter<MalformedArgumentException> formatter) {
        if (formatter != null) {
            this.malformedArgumentFormatter = formatter;
        }
        return this;
    }

    public ArgsParserConfiguration setMissingArgumentFormatter(Formatter<MissingArgumentException> formatter) {
        if (formatter != null) {
            this.missingArgumentFormatter = formatter;
        }
        return this;
    }

    public ArgsParserConfiguration setConstraintExceptionFormatter(Formatter<ConstraintException> formatter) {
        if (formatter != null) {
            this.constraintExceptionFormatter = formatter;
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

    public Formatter<Set<Argument>> getHelpFormatter() {
        return helpFormatter;
    }
    
    public Formatter<TypeConversionException> getTypeConversionFormatter() {
        return typeConversionFormatter;
    }
    
    public Formatter<NoSuchArgumentException> getNoSuchArgumentFormatter() {
        return this.noSuchArgumentFormatter;
    }
    
    public Formatter<MalformedArgumentException> getMalformedArgumentFormatter() {
        return this.malformedArgumentFormatter;
    }
    
    public Formatter<MissingArgumentException> getMissingArgumentFormatter() {
        return this.missingArgumentFormatter;
    }

    public Formatter<ConstraintException> getConstraintExceptionFormatter() {
        return constraintExceptionFormatter;
    }
}