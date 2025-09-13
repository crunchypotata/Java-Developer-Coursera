package org.example.ASD_C7_M3L207_Activity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.example.ASD_C7_M3L207_Activity.controller.CalculatorController;
import org.example.ASD_C7_M3L207_Activity.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(CalculatorController.class) // Load only the controller in the test context
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests

    @MockBean
    private CalculatorService calculatorService;


    @Test
    void testAddition() throws Exception {
        // TODO 2: Write a test case to validate addition.
        mockMvc.perform(get("/calculator/calculate")
                        .param("num1", "5")
                        .param("num2", "3")
                        .param("operation", "add"))
                .andExpect(status().isOk()) // Check if the response status is 200 OK.
                .andExpect(content().string("8.0")); // Check if the response content is "8.0".
    }

    @Test
    void testSubtraction() throws Exception {
        // TODO 3: Write a test case to validate subtraction.
        mockMvc.perform(get("/calculator/calculate")
                        .param("num1", "10")
                        .param("num2", "4")
                        .param("operation", "subtract"))
                .andExpect(status().isOk()) // Check if the response status is 200 OK.
                .andExpect(content().string("6.0")); // Check if the response content is "6.0".
    }

    @Test
    void testMultiplication() throws Exception {
        // TODO 4: Write a test case to validate multiplication.
        mockMvc.perform(get("/calculator/calculate")
                        .param("num1", "3")
                        .param("num2", "7")
                        .param("operation", "multiply"))
                .andExpect(status().isOk()) // Check if the response status is 200 OK.
                .andExpect(content().string("21.0")); // Check if the response content is "21.0".
    }

    @Test
    void testDivision() throws Exception {
        // TODO 5: Write a test case to validate division.
        mockMvc.perform(get("/calculator/calculate")
                        .param("num1", "20")
                        .param("num2", "4")
                        .param("operation", "divide"))
                .andExpect(status().isOk()) // Check if the response status is 200 OK.
                .andExpect(content().string("5.0")); // Check if the response content is "5.0".
    }

    @Test
    void testDivisionByZero() throws Exception {
        // TODO 6: Write a test case to validate division by zero.
        mockMvc.perform(get("/calculator/calculate")
                        .param("num1", "20")
                        .param("num2", "0")
                        .param("operation", "divide"))
                .andExpect(status().isBadRequest()); // Check if the response status is 400 Bad Request.
    }

    @Test
    void testInvalidOperation() throws Exception {
        // TODO 7: Write a test case to validate an unsupported operation.
        mockMvc.perform(get("/calculator/calculate")
                        .param("num1", "5")
                        .param("num2", "3")
                        .param("operation", "invalid"))
                .andExpect(status().isBadRequest()); // Check if the response status is 400 Bad Request.
    }
}
