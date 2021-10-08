# j-args
java-library

## Sample
To use this library simply have a look at the code below.

    ArgumentContext context = new ArgumentContext(new Configuration()
            .setArguments(new ArgumentFactoryBuilder().build()
                    .setPositional()
                    .setType(String.class)
                    .create()
                    .setNames("-a", "--a")
                    .setRequired()
                    .setType(String.class)
                    .create()
                    .setNames("-b", "--b")
                    .setOptional()
                    .setDefaultValue("50")
                    .setType(int.class)
                    .create()
                    .getArguments())
    );
    Args args = context.parse("'my positional value' -b 100 -a \"my required value\"");    
    int b = args.getAsInt("-b");