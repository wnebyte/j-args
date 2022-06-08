package com.github.wnebyte.jargs;

import org.junit.Test;
import org.junit.Assert;
import com.github.wnebyte.jarguments.util.ArgumentFactory;

public class IntegrationTest {

    @Test
    public void requiredTest00() {
        ArgumentFactory factory = new ArgumentFactory();
        factory.create("---a, --a, -a", null, true,
                null, null, null, String.class);
        factory.create("---b, --b, -b", null, true,
                null, null, null, String.class);
        ArgsParser parser = new ArgsParser(new ArgsParserConfiguration().setExit(false), factory.getAll());
        String i0 = "--a 'my input' -b \"hello hello\"";
        String i1 = "---b 'hello hello' -a 'hej hej'";
        String i2 = "---a hej --b 'hej hej'";
        Assert.assertNotNull(parser.parse(i0));
        Assert.assertNotNull(parser.parse(i1));
        Assert.assertNotNull(parser.parse(i2));
        String i3 = "--a hej";
        String i4 = "-b hej";
        String i5 = "";
        String i6 = "-a hej -b 'hello hello' -c";
        Assert.assertNull(parser.parse(i3));
        Assert.assertNull(parser.parse(i4));
        Assert.assertNull(parser.parse(i5));
        Assert.assertNull(parser.parse(i6));
    }

    @Test
    public void optionalTest00() {
        ArgumentFactory factory = new ArgumentFactory();
        factory.create("---a, --a, -a", null, false,
                null, null, "def0", String.class);
        factory.create("---b, --b, -b", null, false,
                null, null, "def1", String.class);
        ArgsParser parser = new ArgsParser(new ArgsParserConfiguration().setExit(false), factory.getAll());
        String i0 = "-a hello -b hej";
        String i1 = "--b hello --a 'hej hej'";
        String i2 = "-a \"hello there\"";
        String i3 = "---b 'hello there'";
        String i4 = "";
        Assert.assertNotNull(parser.parse(i0));
        Assert.assertNotNull(parser.parse(i1));
        Assert.assertNotNull(parser.parse(i2));
        Assert.assertNotNull(parser.parse(i3));
        Assert.assertNotNull(parser.parse(i4));
        Assert.assertEquals("def1", parser.parse(i2).getAsString("-b"));
        Assert.assertEquals("def0", parser.parse(i3).getAsString("-a"));
        String i5 = "-a hello -b hej -c";
        Assert.assertNull(parser.parse(i5));
        String a = parser.parse(i0).get("-a", String.class);
        Assert.assertEquals("hello", a);
    }

    @Test
    public void positionalTest00() {
        ArgumentFactory factory = new ArgumentFactory();
        factory.create(null, null, true,
                null, null, null, String.class);
        factory.create(null, null, true,
                null, null, null, String.class);
        ArgsParser parser = new ArgsParserBuilder()
                .setConfiguration(new ArgsParserConfiguration().setExit(false))
                .setArguments(factory.getAll())
                .build();
        String i0 = "'hello there' hello";
        String i1 = "\"hello there govna\" hej";
        Assert.assertNotNull(parser.parse(i0));
        Assert.assertNotNull(parser.parse(i1));
        String i2 = "'hello there'";
        String i3 = "";
        Assert.assertNull(parser.parse(i2));
        Assert.assertNull(parser.parse(i3));
    }

    @Test
    public void allTest00() {
        ArgumentFactory factory = new ArgumentFactory();
        factory.create(null, null, true,
                null, null, null, String.class);
        factory.create("---b, --b, -b", null, true,
                null, null, null, int.class);
        factory.create("---c, --c, -c", null, false,
                null, null, "'default value'", String.class);
        ArgsParser parser = new ArgsParserBuilder()
                .setConfiguration(new ArgsParserConfiguration().setExit(false))
                .setArguments(factory.getAll())
                .build();
        // Todo: test more inputs
        String i0 = "\"this positional value\" -b 100 -c 'optional value'";
        String i1 = "\"this positional value\" -c 'optional value' -b 100";
        String i2 = "\"this positional value\" -b 100";
        Assert.assertNotNull(parser.parse(i0));
        Assert.assertNotNull(parser.parse(i1));
        Assert.assertNotNull(parser.parse(i2));
        Assert.assertEquals("default value", parser.parse(i2).getAsString("-c"));
        String i3 = "-b 100 -c 'optional value'";
        String i4 = "";
        Assert.assertNull(parser.parse(i3));
        Assert.assertNull(parser.parse(i4));
    }
}
