package com.allwyn.dimitris_nikolaidis.assessment.tests;

import com.allwyn.dimitris_nikolaidis.assessment.context.SpringContext;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(classes = {SpringContext.class})
public class TestContextConfiguration {



}
