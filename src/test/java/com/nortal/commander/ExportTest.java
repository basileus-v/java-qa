package com.nortal.commander;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExportTest {

    Export export;
    ArrayList<String> arguments;
    Environment environment;

    @Before
    public void init() {
        export = new Export();
        arguments = new ArrayList<>();
        environment = new Environment();
    }

    @Test
    public void emptyArguments() throws Exception {
        export.execute(arguments, environment);
        assertTrue(environment.getProperties().isEmpty());
    }

    @Test
    public void oneArgument() throws Exception {
        arguments.add("foo=bar");
        assertNull(export.execute(arguments, environment));
        assertEquals(1, environment.getProperties().size());
        assertEquals("bar", environment.getProperties().get("foo"));
    }

    @Test
    public void invalidArgument() throws Exception {
        arguments.add("foobar");
        assertNull(export.execute(arguments, environment));
        assertEquals(0, environment.getProperties().size());
    }
}