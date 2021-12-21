# jargs
java-library

## About
This java library lets the user add higher-level arguments/options to 
their java executables. 

## Sample


Sample code demonstrates how to use the classes found in this library.

    public class Sample {
        public static void main(String[] args) {
            Args a = Args.parser()
                    .setArguments(ArgumentFactory.builder().build()
                           .setName("--host", "-h")
                           .append(String.class)
                           .setName("--port", "-p")
                           .setIsOptional()
                           .setDefaultValue("2000")
                           .append(int.class)
                           .get()
                ).parse(args);
                
            String host = a.get("-h", String.class);
            int port = a.get("-p", int.class);
        }
    }  
