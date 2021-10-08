package com.github.wnebyte.jargs;

import com.github.wnebyte.args.ArgumentFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

public class SystemTest {

    @Test
    public void testOnlyRequired() {
        ArgumentContext context = new ArgumentContext(new Configuration()
                .setArguments(new ArgumentFactoryBuilder().build()
                        .setNames("-a", "--a", "---a")
                        .setType(String.class)
                        .setRequired()
                        .create()
                        .setNames("-b", "--b", "---b")
                        .setRequired()
                        .setType(String.class)
                        .create()
                        .getArguments())
                .exit(false)
        );
        String i0 = "--a 'my input' -b \"hello hello\"";
        String i1 = "---b 'hello hello' -a 'hej hej'";
        String i2 = "---a hej --b 'hej hej'";
        Assert.assertNotNull(context.parse(i0));
        Assert.assertNotNull(context.parse(i1));
        Assert.assertNotNull(context.parse(i2));
        String i3 = "--a hej";
        String i4 = "-b hej";
        String i5 = "";
        String i6 = "-a hej -b 'hello hello' -c";
        Assert.assertNull(context.parse(i3));
        Assert.assertNull(context.parse(i4));
        Assert.assertNull(context.parse(i5));
        Assert.assertNull(context.parse(i6));
    }

    @Test
    public void testOnlyOptional() {
        ArgumentContext context = new ArgumentContext(new Configuration()
                .setArguments(new ArgumentFactoryBuilder().build()
                        .setNames("-a", "--a", "---a")
                        .setType(String.class)
                        .setOptional()
                        .setDefaultValue("def0")
                        .create()
                        .setNames("-b", "--b", "---b")
                        .setOptional()
                        .setDefaultValue("def1")
                        .setType(String.class)
                        .create()
                        .getArguments())
                .exit(false)
        );
        String i0 = "-a hello -b hej";
        String i1 = "--b hello --a 'hej hej'";
        String i2 = "-a \"hello there\"";
        String i3 = "---b 'hello there'";
        String i4 = "";
        Assert.assertNotNull(context.parse(i0));
        Assert.assertNotNull(context.parse(i1));
        Assert.assertNotNull(context.parse(i2));
        Assert.assertNotNull(context.parse(i3));
        Assert.assertNotNull(context.parse(i4));
        Assert.assertEquals("def1", context.parse(i2).getAsString("-b"));
        Assert.assertEquals("def0", context.parse(i3).getAsString("-a"));
        String i5 = "-a hello -b hej -c";
        Assert.assertNull(context.parse(i5));
    }

    @Test
    public void testOnlyPositional() {
        ArgumentContext context = new ArgumentContext(new Configuration()
                .setArguments(new ArgumentFactoryBuilder().build()
                        .setPositional()
                        .create(String.class)
                        .setPositional()
                        .create(String.class)
                        .getArguments())
                .exit(false)
        );
        String i0 = "'hello there' hello";
        String i1 = "\"hello there govna\" hej";
        Assert.assertNotNull(context.parse(i0));
        Assert.assertNotNull(context.parse(i1));
        String i2 = "'hello there'";
        String i3 = "";
        Assert.assertNull(context.parse(i2));
        Assert.assertNull(context.parse(i3));
    }

    @Test
    public void testComposition() {
        ArgumentContext context = new ArgumentContext(new Configuration()
                .setArguments(new ArgumentFactoryBuilder().build()
                        .setNames("-a", "--a", "---a")
                        .setPositional()
                        .create(String.class)
                        .setNames("-b", "--b", "---b")
                        .setRequired()
                        .create(int.class)
                        .setNames("-c", "--c", "---c")
                        .setOptional()
                        .setDefaultValue("'default value'")
                        .create(String.class)
                        .getArguments())
                .exit(false)
        );
        String i0 = "\"this positional value\" -b 100 -c 'optional value'";
        String i1 = "\"this positional value\" -c 'optional value' -b 100";
        String i2 = "\"this positional value\" -b 100";
        Assert.assertNotNull(context.parse(i0));
        Assert.assertNotNull(context.parse(i1));
        Assert.assertNotNull(context.parse(i2));
        Assert.assertEquals("'default value'", context.parse(i2).getAsString("-c"));
        String i3 = "-b 100 -c 'optional value'";
        String i4 = "";
        Assert.assertNull(context.parse(i3));
        Assert.assertNull(context.parse(i4));
    }

}