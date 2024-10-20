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
}
