package com.github.wnebyte.jargs;

import org.junit.Test;
import org.junit.Assert;
import com.github.wnebyte.jarguments.factory.ArgumentCollectionFactoryBuilder;

public class ArgsParserTest {

    @Test
    public void test00() {
        Args args = Args.parser()
                .setArguments(new ArgumentCollectionFactoryBuilder().build()
                        .setNames("-a")
                        .setType(int.class)
                        .setIsOptional()
                        .setDefaultValue("5")
                        .append()
                        .get()
                )
                .parse("-a 10");
        int a = args.get("-a", int.class);
        Assert.assertEquals(10, a);
    }

    @Test
    public void test01() {
        ArgsParser parser = Args.parser(new ArgumentCollectionFactoryBuilder().build()
                .setNames("host", "-host", "--host")
                .setIsOptional()
                .setDefaultValue("localhost")
                .append(String.class)
                .setNames("port", "-port", "--port")
                .setIsOptional()
                .setDefaultValue("2000")
                .append(int.class)
                .get()
        );
        Args args = parser.parse("");
        String host = args.get("host", String.class);
        int port = args.get("port", int.class);
        Assert.assertEquals("localhost", host);
        Assert.assertEquals(2000, port);

        args = parser.parse("-host 127.0.0.1");
        host = args.get("host", String.class);
        port = args.get("port", int.class);
        Assert.assertEquals("127.0.0.1", host);
        Assert.assertEquals(2000, port);
    }
}
