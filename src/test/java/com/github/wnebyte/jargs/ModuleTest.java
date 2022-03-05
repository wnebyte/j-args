package com.github.wnebyte.jargs;

import org.junit.Test;
import org.junit.Assert;
import com.github.wnebyte.jarguments.factory.ArgumentFactory;

public class ModuleTest {

    @Test
    public void testRequired() {
        ArgsParser parser = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(ArgumentFactory.builder().build()
                        .setName("-a", "--a", "---a")
                        .setType(String.class)
                        .setIsRequired()
                        .append()
                        .setName("-b", "--b", "---b")
                        .setIsRequired()
                        .setType(String.class)
                        .append()
                        .get());
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
    public void testOptional() {
        ArgsParser parser = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(ArgumentFactory.builder().build()
                        .setName("-a", "--a", "---a")
                        .setType(String.class)
                        .setIsOptional()
                        .setDefaultValue("def0")
                        .append()
                        .setName("-b", "--b", "---b")
                        .setIsOptional()
                        .setDefaultValue("def1")
                        .setType(String.class)
                        .append()
                        .get());
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
    public void testPositional() {
        ArgsParser parser = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(ArgumentFactory.builder().build()
                        .setIsPositional()
                        .append(String.class)
                        .setIsPositional()
                        .append(String.class)
                        .get());
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
    public void testComposition() {
        ArgsParser parser = Args.parser(new Configuration()
                .setExit(false))
                .setArguments(ArgumentFactory.builder().build()
                        .setName("-a", "--a", "---a")
                        .setIsPositional()
                        .append(String.class)
                        .setName("-b", "--b", "---b")
                        .setIsRequired()
                        .append(int.class)
                        .setName("-c", "--c", "---c")
                        .setIsOptional()
                        .setDefaultValue("'default value'")
                        .append(String.class)
                        .get());
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
