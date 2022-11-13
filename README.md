# j-args

A flexible argument-parser library.

## Table of Contents

- [Sample](#sample)

## Sample

### 1: How to declare and parse arguments

The code below creates two arguments using the ArgumentFactory class; one required argument of type int, 
and one optional argument of type string.

    ArgumentFactory factory = new ArgumentFactory();
    factory.create("-foo, --foo", "description", true,
            null, "FOO", null, int.class);
    factory.create("-bar, --bar", null, false, 
            null, "BAR", "default value", String.class);
    Set<Argument> arguments = factory.getAll();

The below snippet demonstrates how to parse arguments and retrieve their 
values.

    ArgsParser parser = new ArgsParser(arguments);
    Args args = parser.parse("-bar 'this is a string' -foo 55");
    int foo = args.get("-foo", int.class);
    String bar = args.get("-bar", String.class);
    // do something with your initialized arguments

See: www.github.com/wnebyte/j-arguments for additional documentation 
on how to use the ArgumentFactory class. 
