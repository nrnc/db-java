package com.unbxd.dao.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieDaoImpl implements MovieDao {
    private String url = "jdbc:postgresql://localhost/movies?user=unbxd";
    private Connection conn;
    public MovieDaoImpl(){
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public Movie insertMovie(Movie movie){
        try {
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
        return movie;
    }
    public Movie getMovie(int id){
        Movie movie = new Movie("",""); 
        try {
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
        return movie;
    }

    public Movie updateMovie(int id, Movie movie){
        try {
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
        return movie;
    }

    public void deleteMovie(int id){
        try {
            PreparedStatement ps=conn.prepareStatement("delete from movies where id=?");  
            
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            System.out.println(i + " records deleted");
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
