package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

public class HomeControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void listClubs() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/api/listClubs");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void listMatches() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/api/listMatches");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void addRandomMatch() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/api/randomMatch");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void searchMatch() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/api/searchForMatch/2021-01-01");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

}
