package com.codecool.app.httphandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

public class AdminHandler implements HttpHandler {
    private TemplatesPaths templatesPaths = new TemplatesPaths();
    private Map<String, String> adminOptions = new LinkedHashMap<>();

    public AdminHandler() {
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
            // TODO: Check if sessionId stored in cookies is active and user has admin privilages
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
        }
    }
}
