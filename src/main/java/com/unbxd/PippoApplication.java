package com.unbxd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ro.pippo.core.Application;
import ro.pippo.core.HttpConstants;

/**
 * A simple Pippo application.
 *
 * @see com.unbxd.PippoLauncher#main(String[])
 */
public class PippoApplication extends Application {


    @Override
    protected void onInit() {
        getRouter().ignorePaths("/favicon.ico");
        // send 'Hello World' as response
        GET("/", routeContext -> routeContext.send("Hello World"));
        
        POST("/movies", routeContext -> {
            // String message;
            Movie movie;
            String url = "jdbc:postgresql://localhost/movies?user=unbxd";
            movie = routeContext.createEntityFromBody(Movie.class); 
            try {
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement ps=conn.prepareStatement("insert into movies (title,description,created_at,updated_at) values(?,?,?,?)");  
                
                ps.setString(1, movie.getTitle());
                ps.setString(2, movie.getDescription());
                ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
                ps.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                int i = ps.executeUpdate();
                System.out.println(i + " records inserted");
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            routeContext.json().send(movie);
        });

        PUT("/movies/{id}", routeContext -> {
            // String message;
            Movie movie;
            String url = "jdbc:postgresql://localhost/movies?user=unbxd";
            int id = routeContext.getParameter("id").toInt();
            movie = routeContext.createEntityFromBody(Movie.class); 
            try {
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement ps=conn.prepareStatement("update movies set title=?,description=?,created_at=?,updated_at=? where id = ?");  
                
                ps.setString(1, movie.getTitle());
                ps.setString(2, movie.getDescription());
                ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
                ps.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                ps.setInt(5, id);
                int i = ps.executeUpdate();
                System.out.println(i + " records updated");
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            routeContext.json().send(movie);
        });

        DELETE("/movies/{id}", routeContext -> {
            // String message;
            String url = "jdbc:postgresql://localhost/movies?user=unbxd";
            int id = routeContext.getParameter("id").toInt();
            try {
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement ps=conn.prepareStatement("delete from movies where id=?");  
                
                ps.setInt(1, id);
                int i = ps.executeUpdate();
                System.out.println(i + " records deleted");
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            routeContext.json().status(HttpConstants.StatusCode.OK);
        });

        GET("/movies/{id}", routeContext -> {
            String url = "jdbc:postgresql://localhost/movies?user=unbxd";
            int id = routeContext.getParameter("id").toInt();
            Movie movie = new Movie(); 
            try {
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement ps=conn.prepareStatement("select id,title,description,created_at,updated_at from movies where id=?");  
                
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                         
                    movie.setTitle(rs.getString("title"));
                    movie.setDescription(rs.getString("description"));
                 } 
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            routeContext.json().status(HttpConstants.StatusCode.OK).send(movie);;
        });
    }

}
