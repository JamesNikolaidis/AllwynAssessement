package com.allwyn.dimitris_nikolaidis.assessment.context;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "com.allwyn.dimitris_nikolaidis.assessment.tests",
        "com.allwyn.dimitris_nikolaidis.assessment.apihelper",
        "com.allwyn.dimitris_nikolaidis.assessment.context"
})
public class SpringContext {
}
