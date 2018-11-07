package com.codecool.app.httphandlers;

import com.codecool.app.cookies.CookieHelper;
import com.codecool.app.dao.DAOAccounts;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


public class AdminHandler implements HttpHandler {
    private TemplatesPaths templatesPaths = new TemplatesPaths();
    private Map<String, String> adminOptions = new LinkedHashMap<>();
    private DAOAccounts daoAccounts;
    private CookieHelper cookieHelper;

    public AdminHandler(DAOAccounts daoAccounts, CookieHelper cookieHelper) {
        this.daoAccounts = daoAccounts;
        this.cookieHelper = cookieHelper;
        initializeAdminOptions();
    }

    private void initializeAdminOptions(){
        adminOptions.put("Profile", "/admin/profile");
        adminOptions.put("Mentors", "/admin/mentors");
        adminOptions.put("Classes", "/admin/classes");
        adminOptions.put("Levels", "/admin/levels");
        adminOptions.put("Log out", "/");
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();

        if (method.equals("GET")){
            // TODO: Check if sessionId stored in cookies is active and user has admin privileges
            // TODO: should handler use AdminController for better clean code???
            Optional<HttpCookie> cookie = cookieHelper.getSessionIdCookie(httpExchange);
            String sessionId = cookie.get().getValue();
            sessionId = sessionId.replace("\"", "");

            if(daoAccounts.isValidUserType( sessionId, "ADMIN")) {
                JtwigTemplate template = JtwigTemplate.classpathTemplate(templatesPaths.HOME_PAGE_TEMPLATE_PATH);
                JtwigModel model = JtwigModel.newModel();

                // Example
                model.with("userName", "Uther");
                model.with("userNickname", "The Lightbringer");
                model.with("options", adminOptions);
                model.with("contentPath", "");

                String response = template.render(model);

                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                System.out.println("Unauthorized request for admin");
                httpExchange.getResponseHeaders().add("Location", "/");
                httpExchange.sendResponseHeaders(303, 0);

            }
        }
    }
}
