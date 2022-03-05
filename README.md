# j-args
java-library

## Table of Contents

- [About](#about)
- [Sample](#sample)
- [Build](#build)
- [Documentation](#documentation)
- [Licence](#licence)

## About
This library lets a prospective user add higher-level arguments/options to 
their java executables.

## Sample

Sample demonstrates how to declare a parser & specify arguments:

    public static void main(String[] input) {
        ArgsParser = Args.parser()
                .setArguments(ArgumentFactory.builder().build()
                        .setName("-a", "--a")
                        .setDescription("my required argument")
                        .setType(String.class)
                        .append()
                        .setName("-b", "--b")
                        .setDescription("my optional argument")
                        .setIsOptional()
                        .setDefaultValue("2000")
                        .setType(int.class)
                        .append()
                        .get()
                );
    }
    
Sample demonstrates how to parse input & retrieve values:

    // parse
    Args args = parser.parse(input);
    
    // retrieve values
    String a = args.get("-a", String.class);
    int b = args.get("-b", int.class);

## Build

## Documentation

## Licence