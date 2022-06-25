package com.github.wnebyte.jargs;

import java.util.Set;
import java.io.PrintStream;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.conf.Configuration;
import com.github.wnebyte.jarguments.exception.ParseException;
import com.github.wnebyte.jarguments.util.IConsole;
import com.github.wnebyte.jarguments.formatter.Formatter;

/**
 * This class is used to specify configuration options for instances of {@link ArgsParser}.
 */
public class ArgsParserConfiguration extends Configuration {

    /*
    ###########################
    #          FIELDS         #
    ###########################
    */

    private boolean exit = true;


    /*
    ###########################
    #          METHODS        #
    ###########################
    */

    @Override
    public ArgsParserConfiguration setOut(PrintStream out) {
        super.setOut(out);
        return this;
    }

    @Override
    public ArgsParserConfiguration setErr(PrintStream err) {
        super.setErr(err);
        return this;
    }

    @Override
    public ArgsParserConfiguration setConsole(IConsole console) {
        super.setConsole(console);
        return this;
    }

    @Override
    public ArgsParserConfiguration setHelpFormatter(Formatter<Set<Argument>> formatter) {
        super.setHelpFormatter(formatter);
        return this;
    }

    @Override
    public <T extends ParseException> ArgsParserConfiguration setFormatter(
            Class<T> cls, Formatter<T> formatter) {
        super.setFormatter(cls, formatter);
        return this;
    }

    public ArgsParserConfiguration setExit(boolean value) {
        this.exit = value;
        return this;
    }

    public boolean isExit() {
        return exit;
    }

}