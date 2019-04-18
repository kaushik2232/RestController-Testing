package com.RestController.Testing.Rest.TestingMockito;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldControllerTest {

	private MockMvc mockMvc;

//    @Mock
//    private HelloWorldController helloService;

    @InjectMocks
    private HelloWorldController helloResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloResource)
                .build();
    }

    @Test
    public void testHelloWorld() throws Exception {

       // when(helloService.hello()).thenReturn("hello");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));

        //verify(helloService).hello();
    }

//    @Test
//    public void testHelloWorldJson() throws Exception {
//        mockMvc.perform(get("/hello/json")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//    }
//
//    @Test
//    public void testPost() throws Exception {
//        String json = "{\n" +
//                "  \"title\": \"Greetings\",\n" +
//                "  \"value\": \"Hello World\"\n" +
//                "}";
//        mockMvc.perform(post("/hello/post")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//    }
	

}
