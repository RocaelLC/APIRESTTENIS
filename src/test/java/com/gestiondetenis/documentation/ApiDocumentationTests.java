package com.gestiondetenis.documentation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class ApiDocumentationTests {

    @SuppressWarnings("unused")
    private MockMvc mockMvc;

    @Test
    public void documentEndpoints() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(null/* WebApplicationContext */)
                .apply(MockMvcRestDocumentation.documentationConfiguration(null/* Snippets */))
                .alwaysDo(MockMvcRestDocumentation.document("{method-name}",
                        Preprocessors.preprocessResponse(Preprocessors.prettyPrint())))
                .build();

        // Test your endpoints here to generate documentation
    }
}
