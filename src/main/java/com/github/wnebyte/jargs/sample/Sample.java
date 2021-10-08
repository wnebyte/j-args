package com.github.wnebyte.jargs.sample;

import com.github.wnebyte.jargs.Args;
import com.github.wnebyte.jargs.ArgumentContext;
import com.github.wnebyte.jargs.Configuration;
import com.github.wnebyte.args.ArgumentFactoryBuilder;

public class Sample {

    public static void main(String[] vargs) {
        ArgumentContext context = new ArgumentContext(new Configuration()
                .setArguments(new ArgumentFactoryBuilder().build()
                        .setNames("-a")
                        .setType(boolean.class)
                        .setRequired()
                        .create()
                        .getArguments())
                .exit(true)
        );
        Args args = context.parse("-a");
        int a = args.getAsInt("-a");
    }
}