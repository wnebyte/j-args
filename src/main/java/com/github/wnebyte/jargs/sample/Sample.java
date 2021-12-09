package com.github.wnebyte.jargs.sample;

import com.github.wnebyte.jargs.Args;
import com.github.wnebyte.jargs.ArgumentContext;
import com.github.wnebyte.jargs.Configuration;
import com.github.wnebyte.jarguments.factory.ArgumentCollectionFactoryBuilder;

public class Sample {

    public static void main(String[] vargs) {
        ArgumentContext context = new ArgumentContext(new Configuration()
                .setArguments(new ArgumentCollectionFactoryBuilder().build()
                        .setNames("-a")
                        .setType(boolean.class)
                        .setIsRequired()
                        .append()
                        .get())
                .exit(true)
        );
        Args args = context.parse("-a");
        int a = args.getAsInt("-a");
    }
}