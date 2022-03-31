package com.github.wnebyte.jargs;

import java.util.List;
import com.github.wnebyte.jarguments.Argument;
import com.github.wnebyte.jarguments.factory.ArgumentFactory;

public class SampleTest {

    public static void main(String[] args) {
        List<Argument> c = ArgumentFactory.builder().build()
                .setName("-a", "--a")
                .setDescription("my required argument")
                .isRequired()
                .append(int.class)
                .setName("-b", "--b")
                .setDescription("my optional argument")
                .isOptional()
                .append(String.class)
                .get();
        System.out.println("=begin");
        System.out.print(new HelpFormatter().apply(c));
        System.out.println("=end");
    }
}
