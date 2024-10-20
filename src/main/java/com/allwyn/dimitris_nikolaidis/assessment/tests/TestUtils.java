package com.allwyn.dimitris_nikolaidis.assessment.tests;

import com.allwyn.dimitris_nikolaidis.assessment.apihelper.RestHelper;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;


public class TestUtils {

    @Autowired
    protected RestHelper restHelper;


    public String getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(classLoader.getResource(fileName).getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        return data;
    }
}
