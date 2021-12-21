package com.github.wnebyte.jargs;

import com.github.wnebyte.jarguments.factory.ArgumentFactory;
import org.junit.Test;
import java.util.List;
import com.github.wnebyte.jarguments.Argument;

public class HelpFormatterTest {

    @Test
    public void test00() {
        List<Argument> args = ArgumentFactory.builder().build()
                .setName("-a", "--a")
                .setIsRequired()
                .append(int.class)
                .setName("-b", "--b")
                .setIsOptional()
                .append(String.class)
                .get();
        System.out.println("=begin");
        System.out.print(new HelpFormatter().apply(args));
        System.out.println("=end");
    }
}
