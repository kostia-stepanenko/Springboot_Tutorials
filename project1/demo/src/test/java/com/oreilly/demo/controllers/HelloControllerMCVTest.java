package com.oreilly.demo.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest
public class HelloControllerMCVTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void autoWiringWorked(){
         assertNotNull (mvc);
    }
}
