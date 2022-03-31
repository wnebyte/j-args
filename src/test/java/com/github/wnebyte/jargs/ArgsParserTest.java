package com.github.wnebyte.jargs;

import org.junit.Test;
import org.junit.Assert;
import com.github.wnebyte.jarguments.factory.ArgumentFactory;
import com.github.wnebyte.jarguments.factory.ArgumentFactoryBuilder;

public class ArgsParserTest {

    @Test
    public void test00() {
        Args args = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(ArgumentFactory.builder().build()
                        .setName("-a")
                        .setType(int.class)
                        .isOptional()
                        .setDefaultValue("5")
                        .append()
                        .get())
                .parse("-a 10");

        int a = args.get("-a", int.class);
        Assert.assertEquals(10, a);
    }

    @Test
    public void test01() {
        ArgsParser parser = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(ArgumentFactory.builder().build()
                        .setName("host", "-host", "--host")
                        .isOptional()
                        .setDefaultValue("localhost")
                        .append(String.class)
                        .setName("port", "-port", "--port")
                        .isOptional()
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

    @Test
    public void test02() {
        ArgsParser parser = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(new ArgumentFactoryBuilder().build()
                        .setName("host", "-host", "--host")
                        .isRequired()
                        .append(String.class)
                        .setName("port", "-port", "--port")
                        .isOptional()
                        .setDefaultValue("2000")
                        .append(int.class)
                        .get());

        String input = "host 127.0.0.1 port 2505";
        Args args = parser.parse(input);
        Assert.assertNotNull(args);

        String[] arrInput = { "host", "127.0.0.1", "port", "2505" };
        args = parser.parse(arrInput);
        Assert.assertNotNull(args);
    }
}