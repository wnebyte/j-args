package com.github.wnebyte.jargs;

import com.github.wnebyte.jarguments.Argument;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HelpFormatter implements Formatter<Collection<Argument>> {

    private static final Function<Collection<Argument>, String> ARG_COLLECTION_TO_STRING_FUNCTION =
            new Function<Collection<Argument>, String>() {
                @Override
                public String apply(Collection<Argument> args) {
                    return args.stream().map(Argument::toPaddedDescriptiveString)
                            .collect(Collectors.joining(" "));
                }
            };

    private static final Function<Argument, String> ARG_TO_STRING_FUNCTION = Argument::toPaddedString;

    @Override
    public String apply(Collection<Argument> args) {
        StringBuilder out = new StringBuilder();
        out.append("Usage: ").append(ARG_COLLECTION_TO_STRING_FUNCTION.apply(args))
                .append("\n\n").append("OPTIONS: ").append("\n");

        if (!args.isEmpty()) {
            int maxLength  = maxToStringLength(args);
            int maxTotalLength = maxTotalLength(args);

            for (Argument arg : args) {
                String s = ARG_TO_STRING_FUNCTION.apply(arg);
                String indent = indent((maxLength + 1) - s.length());
                String ln = new StringBuilder().append("\t").append(s).append(indent)
                        .append(arg.hasDesc() ? arg.getDesc() : "").toString();
                out.append(ln);
                indent = indent((maxTotalLength + 1) - ln.length());
                out.append(indent).append("\n");
              //  out.append(indent).append("<").append(arg.getType().getSimpleName()).append(">").append("\n");
            }
        }

        return out.toString();
    }

    private int maxToStringLength(final Collection<Argument> args) {
        return args.stream().map(ARG_TO_STRING_FUNCTION).max(Comparator.comparingInt(String::length))
                .orElse("")
                .length();
    }

    private int maxTotalLength(final Collection<Argument> args) {
        int max = maxToStringLength(args);

        return args.stream().map(new Function<Argument, String>() {
            @Override
            public String apply(Argument arg) {
                String s = ARG_TO_STRING_FUNCTION.apply(arg);
                String indent = indent((max + 1) - s.length());
                StringBuilder out = new StringBuilder();
                out.append(" ").append(s).append(indent).append(arg.hasDesc() ? arg.getDesc() : "");
                return out.toString();
            }
        }).max(Comparator.comparingInt(String::length)).orElse("").length();
    }

    private String indent(int len) {
        char[] arr = new char[len];
        Arrays.fill(arr, ' ');
        return new String(arr);
    }
}
