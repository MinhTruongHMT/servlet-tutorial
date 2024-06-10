package com.truong.helleservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", urlPatterns = "/translate")
public class TranslateServlet extends HttpServlet {
    private Map<String, String> disctionry;

    public TranslateServlet() {
        disctionry = new HashMap<>();
        disctionry.put("hello", "xin chao");
        disctionry.put("yello", "vang");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <form action=\"/translate\" method=\"post\">\n" +
                "        <div>\n" +
                "            <label for=\"name\">User Name</label>\n" +
                "            <input id=\"name\" type=\"text\" name=\"userName\" />\n" +
                "            <button type=\"submit\">SEND</button>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>\n" +
                "\n" +
                "</html>");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String name = request.getParameter("userName");
        String result = disctionry.get(name.toLowerCase());
        String strOutputOriginal = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <form action=\"/translate\" method=\"post\">\n" +
                "        <div>\n" +
                "            <label for=\"name\">User Name</label>\n" +
                "            <input id=\"name\" type=\"text\" name=\"userName\" value='%s'/>\n" +
                "            <button type=\"submit\">SEND</button>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "           <label>%s</label>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        String str = String.format(strOutputOriginal, name, "ket qua : " + result);
        PrintWriter out = response.getWriter();
        out.println(str);

    }

    public void destroy() {
    }
}
