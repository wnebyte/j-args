package com.github.wnebyte.jargs;

import org.junit.Test;
import org.junit.Assert;
import com.github.wnebyte.jarguments.util.ArgumentFactory;

public class ArgsParserTest {

    @Test
    public void test00() {
        ArgumentFactory factory = new ArgumentFactory();
        factory.create("-a", null, false,
                null, null, "5", int.class);
        ArgsParser parser = new ArgsParser(new ArgsParserConfiguration().setExit(false), factory.getAll());
        Args args = parser.parse("-a 10");
        int a = args.get("-a", int.class);
        Assert.assertEquals(10, a);
    }

    @Test
    public void test01() {
        ArgumentFactory factory = new ArgumentFactory();
        factory.create("--host, -host, host", null, false,
                null, null, "localhost", String.class);
        factory.create("--port, -port, port", null, false,
                null, null, "2000", int.class);
        ArgsParser parser = new ArgsParser(new ArgsParserConfiguration().setExit(false), factory.getAll());
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
        ArgumentFactory factory = new ArgumentFactory();
        factory.create("--host, -host, host", null, true,
                null, null, null, String.class);
        factory.create("--port, -port, port", null, false,
                null, null, "2000", int.class);
        ArgsParser parser = new ArgsParser(new ArgsParserConfiguration().setExit(false), factory.getAll());
        String input = "host 127.0.0.1 port 2505";
        Args args = parser.parse(input);
        Assert.assertNotNull(args);
        String[] input1 = { "host", "127.0.0.1", "port", "2505" };
        args = parser.parse(input1);
        Assert.assertNotNull(args);
    }
}