package com.nortal.commander;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnvTest {

    Env env;
    ArrayList<String> arguments;
    Environment environment;

    @Before
    public void init() {
        env = new Env();
        arguments = new ArrayList<>();
        environment = new Environment();
    }

    @Test
    public void emptyProperties() throws Exception {
        assertEquals("", env.execute(arguments, environment));
    }

    @Test
    public void oneProperty() throws Exception {
        environment.addProperty("foo", "bar");
        assertEquals("foo=bar", env.execute(arguments, environment));
    }

    @Test
    public void twoProperties() throws Exception {
        environment.addProperty("foo1", "bar1");
        environment.addProperty("foo2", "bar2");
        String expected = "foo1=bar1" + System.lineSeparator() + "foo2=bar2";
        assertEquals(expected, env.execute(arguments, environment));
    }
}