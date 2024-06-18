package com.gestiondetenis.documentation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@SpringBootTest
@AutoConfigureMockMvc
public class ApiDocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void documentEndpoints() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/api/productos"))
                .andDo(MockMvcRestDocumentation.document("{method-name}",
                        Preprocessors.preprocessResponse(Preprocessors.prettyPrint())));

        // Puedes realizar más aserciones en el resultado si lo necesitas
        result.andExpect(status().isOk());
    }
}
