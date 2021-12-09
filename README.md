# jargs
java-library

## About
This is a java library which lets the user add higher level arguments to their java executables. 

## Sample
### Basic
Sample code demonstrates the basic usage of this library.

    public class Sample {
    
        public static void main(String[] vargs) {
            Args args = Args.parser(
                new ArgumentCollectionFactoryBuilder().build()
                        .setNames("host", "-host")
                        .setIsRequired()
                        .setType(String.class)
                        .append()
                        .setNames("port", "-port")
                        .setIsOptional()
                        .setType(int.class)
                        .setDefaultValue("2000")
                        .append()
                        .get()
            ).parse(vargs);
            // get the initialized argument values
            String host = args.get("host", String.class);
            int port = args.get("port", int.class);
            // do whatever...
        }
    }  

## Build

    dependencies {
        implementation 'com.github.wnebyte:jarguments:0.0.1'
    }
