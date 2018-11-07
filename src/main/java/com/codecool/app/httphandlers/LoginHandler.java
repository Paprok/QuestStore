package com.codecool.app.httphandlers;

import com.codecool.app.dao.DAOAccounts;
import com.codecool.app.login.Account;
import com.codecool.app.login.cookies.CookieHelper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpCookie;
import java.net.URLDecoder;
import java.util.*;

public class LoginHandler implements HttpHandler {
    private final String LOGIN_PAGE_URL = "static/login.html";
    private final String SESSION_COOKIE_NAME = "sessionId";
    private CookieHelper cookieHelper = new CookieHelper(SESSION_COOKIE_NAME);
    private DAOAccounts daoAccounts;

    public LoginHandler(DAOAccounts daoAccounts) {
        this.daoAccounts = daoAccounts;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();

        if (method.equals("GET")){
            handleRequestGET(httpExchange);
        }

        else if (method.equals("POST")){
            System.out.println("is post");
            handleRequestPOST(httpExchange);
        }
    }


    private void handleRequestGET(HttpExchange httpExchange) throws  IOException{
        StringBuilder result = new StringBuilder();
        String response = "";
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
            System.out.println(String.format("Couldn't read %s file", LOGIN_PAGE_URL));
        }
        sendResponse(httpExchange, response);
    }

    private  void handleRequestPOST(HttpExchange httpExchange) throws IOException{
        Optional<HttpCookie> cookie = cookieHelper.getSessionIdCookie(httpExchange);
        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String formData = br.readLine();
        System.out.println(formData);
        Map inputs = parseFormData(formData);
        String password = (String) inputs.get("password");
        String nick = (String) inputs.get("nick");
        System.out.println(nick + " " + password);
        try {
            Account account = daoAccounts.getAccountByNicknameAndPassword(nick, password);
            String sessionId = UUID.randomUUID().toString();
            cookie = Optional.of(new HttpCookie(SESSION_COOKIE_NAME, sessionId));
            httpExchange.getResponseHeaders().add("Set-Cookie", cookie.get().toString());
            httpExchange.getResponseHeaders().add("Location", "/static/a");


        } catch (NoSuchElementException e) {
            httpExchange.getResponseHeaders().add("Location", "/");
        }
        httpExchange.sendResponseHeaders(303, 0);
    }

    private void sendResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            // We have to decode the value because it's urlencoded. see: https://en.wikipedia.org/wiki/POST_(HTTP)#Use_for_submitting_web_forms
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }
}
