package com.nortal.commander;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class LsTest {
    Environment environment;
    ArrayList<String> args;

    @Before
    public void init() {
        args = new ArrayList<>();
        environment = null;
    }

    @Test
    public void listFiles() {
        File rootDir = Mockito.mock(File.class);
        File[] files = getTestFiles();
        Mockito.when(rootDir.listFiles()).thenReturn(files);

        String expected = "foo.txt" + System.lineSeparator() +
                "bar.txt" + System.lineSeparator() +
                "temp/";
        String actual = Ls.listDirectory(rootDir);

        Assert.assertEquals(expected, actual);
    }

    public File[] getTestFiles() {
        File directory = Mockito.mock(File.class);
        Mockito.when(directory.isDirectory()).thenReturn(true);
        Mockito.when(directory.getName()).thenReturn("temp");

        return new File[]{
                new File("foo.txt"),
                new File("bar.txt"),
                directory
        };
    }
}
