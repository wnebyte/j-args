package com.github.wnebyte.jargs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.util.Chars;
import com.github.wnebyte.jarguments.util.Objects;
import com.github.wnebyte.jarguments.util.Strings;

public class HelpFormatter implements Formatter<Collection<Argument>> {

    /*
    ###########################
    #     UTILITY METHODS     #
    ###########################
    */

    private static int maxLength(Collection<Argument> c) {
        return c.stream().map(ARGUMENT_FORMATTER)
                .max(Comparator.comparingInt(String::length))
                .orElse(Strings.EMPTY)
                .length();
    }

    private static int maxTotalLength(Collection<Argument> c) {
        int max = maxLength(c);

        return c.stream().map(new Formatter<Argument>() {
            @Override
            public String apply(Argument argument) {
                String s = ARGUMENT_FORMATTER.apply(argument);
                String indent = indent((max + 1) - s.length());
                StringBuilder out = new StringBuilder();
                out.append(Strings.WHITESPACE).append(s).append(indent)
                        .append(Objects.requireNonNullElseGet(argument.getDescription(), () -> Strings.EMPTY));
                return out.toString();
            }
        }).max(Comparator.comparingInt(String::length))
                .orElse(Strings.EMPTY)
                .length();
    }

    private static String indent(int len) {
        char[] arr = new char[len];
        Arrays.fill(arr, Chars.WHITESPACE);
        return new String(arr);
    }

    /*
    ###########################
    #      STATIC FIELDS      #
    ###########################
    */

    private static final Formatter<Collection<Argument>> COLLECTION_FORMATTER
            = new Formatter<Collection<Argument>>() {
                @Override
                public String apply(Collection<Argument> c) {
                    return c.stream().map(Argument::toPaddedDescriptiveString)
                            .collect(Collectors.joining(Strings.WHITESPACE));
                }
            };

    private static final Formatter<Argument> ARGUMENT_FORMATTER = Argument::toPaddedString;

    /*
    ###########################
    #         METHODS         #
    ###########################
    */

    @Override
    public String apply(Collection<Argument> c) {
        StringBuilder out = new StringBuilder();
        out.append("Usage: ").append(COLLECTION_FORMATTER.apply(c))
                .append("\n\n")
                .append("OPTIONS: ")
                .append("\n");

        if (!c.isEmpty()) {
            int maxLength  = maxLength(c);
           // int maxTotalLength = maxTotalLength(c);

            for (Argument argument : c) {
                String s = ARGUMENT_FORMATTER.apply(argument);
                String indent = indent((maxLength + 1) - s.length());
                String ln = new StringBuilder().append("\t").append(s).append(indent)
                        .append(Objects.requireNonNullElseGet(argument.getDescription(), () -> Strings.EMPTY)).toString();
                out.append(ln);
                /*
                indent = indent((maxTotalLength + 1) - ln.length());
                out.append(indent).append("\n");
                 */
                out.append("\n");
            }
        }

        return out.toString();
    }
}
