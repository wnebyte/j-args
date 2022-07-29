package com.github.wnebyte.jargs;

import java.io.PrintStream;
import com.github.wnebyte.jarguments.ContextView;
import com.github.wnebyte.jarguments.Formatter;
import com.github.wnebyte.jarguments.BaseConfiguration;
import com.github.wnebyte.jarguments.exception.ParseException;
import com.github.wnebyte.jarguments.util.IConsole;

/**
 * This class is used to specify configuration options for instances of {@link ArgsParser}.
 */
public class ArgsParserConfiguration extends BaseConfiguration {

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
    public ArgsParserConfiguration setHelpFormatter(Formatter<ContextView> formatter) {
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