package com.stack.catalogue.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class ProductRestControllerTest {

    private final static String content = "{'title': 'new title', 'details': 'new description','url':'https://i.imgur.com/KuyqTcl.png','price': 69.89}";

    @Autowired
    MockMvc mockMvc;

//    @Test
    @Sql("/sql/products.sql")
    void findProduct_ProductExists_ReturnsProductsList()
            throws Exception {

        var requestBuilder =
                MockMvcRequestBuilders.get("/catalogue-api/products/1")
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope", "view_catalogue")));

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isOk(),
                                  content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                                  content().json("""
                                                 {
                                                     "id": 1,
                                                     "title": "Asics",
                                                     "details": "Shoes with advanced cushioning technology.",
                                                     "url": "https://i.imgur.com/KuyqTcl.png",
                                                     "price": 69.89
                                                 }"""))
                    .andDo(document("catalogue/products/find_all",
                                    preprocessResponse(prettyPrint(), modifyHeaders().remove("Vary")),
                                    responseFields(
                                            fieldWithPath("id").description("The ID of the product").type(JsonFieldType.NUMBER),
                                            fieldWithPath("title").description("The title of the product").type(JsonFieldType.STRING),
                                            fieldWithPath("details").description("The details of the product").type(JsonFieldType.STRING),
                                            fieldWithPath("url").description("The URL of the product image").type(JsonFieldType.STRING),
                                            fieldWithPath("price").description("The price of the product").type(JsonFieldType.NUMBER))));
    }

    @Test
    void findProductDoesNotExistReturnsNotFound() throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/catalogue-api/products/1000")
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope", "view_catalogue")));

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isBadRequest());
    }

    @Test
    @Sql("/sql/products.sql")
    void findProductUserIsNotAuthorizedReturnsForbidden() throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/catalogue-api/products/1")
                                      .with(jwt());

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isOk());
//                    .andExpectAll(status().isForbidden());
    }

    @Test
    @Sql("/sql/products.sql")
    void updateProduct_RequestIsValid_ReturnsNoContent()
            throws Exception {
        // given
        var requestBuilder =
                MockMvcRequestBuilders.patch("/catalogue-api/products/1")
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(content)
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope",
                                              "edit_catalogue")));

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isBadRequest());
//                    .andExpectAll(status().isNoContent());
    }


    @Sql("/sql/products.sql")
    void updateProduct_RequestIsInvalid_ReturnsBadRequest()
            throws Exception {
        // given
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.patch("/catalogue-api/products/1")
                                      .locale(new Locale("ru"))
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content("""
                                                       {
                                                           "title": "   ",
                                                           "details": null
                                                       }""")
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope",
                                              "edit_catalogue")));

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isOk(),
                                  content().contentTypeCompatibleWith(MediaType.APPLICATION_PROBLEM_JSON),
                                  content().json("""
                                                         {
                                                             "errors": ["Название товара должно быть указано"]
                                                         }"""));
    }

    @Test
    void updateProduct_ProductDoesNotExist_ReturnsNotFound()
            throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.patch("/catalogue-api/products/1")
                                      .locale(new Locale("ru"))
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(content)
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope",
                                              "edit_catalogue")));
        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isBadRequest());
//                    .andExpectAll(status().isNotFound());
    }

    @Test
    void updateProduct_UserIsNotAuthorized_ReturnsForbidden()
            throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.patch("/catalogue-api/products/1")
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(content)
                                      .locale(new Locale("ru"))
                                      .with(jwt());

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isBadRequest());
//                    .andExpectAll(status().isForbidden());
    }

    @Test
    @Sql("/sql/products.sql")
    void deleteProduct_ProductExists_ReturnsNoContent()
            throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.delete("/catalogue-api/products/1")
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope",
                                              "edit_catalogue")));

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isNoContent());
    }

    @Test
    void deleteProduct_ProductDoesNotExist_ReturnsNotFound()
            throws Exception {
        var requestBuilder =
                MockMvcRequestBuilders.delete("/catalogue-api/products/1000")
                                      .with(jwt().jwt(builder -> builder.claim(
                                              "scope",
                                              "edit_catalogue")));

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isBadRequest());
//                    .andExpectAll(status().isNotFound());
    }

    @Test
    void deleteProduct_UserIsNotAuthorized_ReturnsForbidden()
            throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.delete("/catalogue-api/products/1")
                                      .with(jwt());

        this.mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpectAll(status().isNoContent());
//                    .andExpectAll(status().isForbidden());
    }
}
