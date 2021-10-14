package com.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import com.config.ServiceApplication;

@Component
@ContextConfiguration(classes = ServiceApplication.class)
public class AbstractApiSteps {
    @Autowired
    private static Environment env;

    public static void main(String[] args) {
        System.out.println(System.getProperty("env"));
        System.out.println(env.getProperty("base.URL"));
    }
    //    private static final long serialVersionUID = 1L;
    //    public static RequestSpecification specs = null;
    //
    //    public AbstractApiSteps() {
    //        AppInjector.getInjector().injectMembers(this);
    //    }
    //
    //    public static RequestSpecification getSpecWithExtraHeaders() {
    //        specs = new RequestSpecBuilder()
    //        .setContentType(ContentType.JSON)
    //        .setBaseUri(EnvironmentConstants.API_BASE_URL)
    //        .build();
    //        return specs;
    //    }
    //
    //    protected static <T> T getResource(String path, Class<T> responseClass, Object... params) {
    //        return given().relaxedHTTPSValidation()
    //                .spec(getSpecWithExtraHeaders())
    //                .when().get(path, params)
    //                .then()
    //                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
    //                .extract().as(responseClass);
    //    }
    //
    //    protected static String getNotFoundResourceMessage(String path, Object requestBody, Object... params) {
    //        return given().relaxedHTTPSValidation()
    //                .spec(getSpecWithExtraHeaders())
    //                .body(requestBody)
    //                .when().get(path, params)
    //                .then()
    //                .assertThat().statusCode(404).extract().asString();
    //    }
    //
    //    protected static void updateResource(String path, Object requestBody, Object... params) {
    //        given().relaxedHTTPSValidation()
    //        .spec(getSpecWithExtraHeaders())
    //        .body(requestBody)
    //        .when().put(path, params)
    //        .then()
    //        .assertThat().statusCode(anyOf(is(201), is(200), is(302)));
    //    }
    //
    //    protected static void deleteResource(String path, String param) {
    //        given().relaxedHTTPSValidation()
    //        .spec(getSpecWithExtraHeaders())
    //        .when().delete(path, param)
    //        .then()
    //        .assertThat().statusCode(anyOf(is(201), is(200), is(302)));
    //    }
    //
    //    protected static <T> T createResource(String path, Object requestBody, Class<T> responseClass) {
    //        return given().relaxedHTTPSValidation()
    //                .spec(getSpecWithExtraHeaders())
    //                .body(requestBody)
    //                .when().post(path)
    //                .then()
    //                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
    //                .extract().as(responseClass);
    //    }
}
