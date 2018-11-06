package com.codecool.app.httphandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class LoginHandler implements HttpHandler {
    private final String LOGIN_PAGE_URL = "static/index.html";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();
        StringBuilder result = new StringBuilder();
        String response = "";

        if (method.equals("GET")){
            ClassLoader classLoader = getClass().getClassLoader();
            File loginPage = new File(classLoader.getResource(LOGIN_PAGE_URL).getFile());

            try (Scanner scanner = new Scanner(loginPage)){
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }
                response = result.toString();
            } catch (IOException e){
                e.printStackTrace();
            }


            httpExchange.sendResponseHeaders(200, 0);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
