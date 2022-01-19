package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.google.gson.Gson;

import database.Connexion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salle")
public class Server extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson _gson = null;

    public Server() {
        super();
        _gson = new Gson();
    }

    public void init() {
        System.out.println("Hello World!");
    }

    public void destroy() {
        System.out.println("Goodbye World!");
    }

    public void doGet(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        // show tables in database
        String query = "SELECT * FROM salles;";
        try (Connection connection = Connexion.getInstane().getConnection();
                java.sql.Statement statement = connection.createStatement();
                java.sql.ResultSet resultSet = statement.executeQuery(query)) {
            String json = _gson.toJson(resultSet);

            sendAsJson(response, json);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.getWriter().write("{\"message\":\"Hello World!\"}");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.getWriter().write("{\"message\":\"Hello World!\"}");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.getWriter().write("{\"message\":\"Hello World!\"}");
    }

    private void sendAsJson(
            HttpServletResponse response,
            String obj) throws IOException {

        String res = _gson.toJson(obj);

        PrintWriter out = response.getWriter();

        out.write(res);
        out.flush();
    }

}
