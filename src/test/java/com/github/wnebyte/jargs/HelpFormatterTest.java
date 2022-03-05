package com.github.wnebyte.jargs;

import java.util.List;
import org.junit.Test;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.factory.ArgumentFactory;

public class HelpFormatterTest {

    @Test
    public void test00() {
        List<Argument> c = ArgumentFactory.builder().build()
                .setName("-a", "--a")
                .setIsRequired()
                .append(int.class)
                .setName("-b", "--b")
                .setIsOptional()
                .append(String.class)
                .get();
        System.out.println("=begin");
        System.out.print(new HelpFormatter().apply(c));
        System.out.println("=end");
    }
}
