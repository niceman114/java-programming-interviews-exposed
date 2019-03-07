package com.wiley.javainterviewsexposed.chapter18;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ApacheCommons {

    @Test
    public void escapeStrings() {
        final String exampleText = "Left & Right";
        final String escapedString =
                StringEscapeUtils.escapeHtml4(exampleText);

        assertEquals("Left &amp; Right", escapedString);
    }

    @Test
    public void connectStreams() throws IOException {
        final String exampleText = "Text to be streamed";
        final InputStream inputStream =
                new ByteArrayInputStream(exampleText.getBytes());

        final OutputStream outputStream = new ByteArrayOutputStream();

        IOUtils.copy(inputStream, outputStream);

        final String streamContents = outputStream.toString();
        assertEquals(exampleText, streamContents);
        assertNotSame(exampleText, streamContents);
    }

    @Test
    public void outputStreamToString() throws IOException {
        String exampleText = "An example String";
        final InputStream inputStream =
                new ByteArrayInputStream(exampleText.getBytes());

        final String consumedString = IOUtils.toString(inputStream);

        assertEquals(exampleText, consumedString);
        assertNotSame(exampleText, consumedString);
    }

    @Test
    public void outputStreamSplit() throws IOException {
        final String exampleText = "A string to be streamed";
        final InputStream inputStream = IOUtils.toInputStream(exampleText);

        final File tempFile = File.createTempFile("example", "txt");
        tempFile.deleteOnExit();
        final OutputStream stream1 = new FileOutputStream(tempFile);
        final OutputStream stream2 = new ByteArrayOutputStream();

        final OutputStream tee = new TeeOutputStream(stream1, stream2);

        IOUtils.copy(inputStream, tee);

        final FileInputStream fis = new FileInputStream(tempFile);
        final String stream1Contents = IOUtils.toString(fis);
        final String stream2Contents = stream2.toString();

        assertEquals(exampleText, stream1Contents);
        assertEquals(exampleText, stream2Contents);
    }
}
