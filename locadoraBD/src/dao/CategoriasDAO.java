package dao;

import model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class CategoriasDAO extends DbConnection{
    private Connection conn;
    private final String sqlInsert = "INSERT INTO mydb.Categoria(Sigla, Categoria) VALUES (?,?)";
    private final String sqlUpdate = "UPDATE mydb.Categoria SET Categoria = ? WHERE Sigla = ? ";
    private final String sqlRemove = "DELETE FROM mydb.Categoria WHERE Sigla = ?";
    private final String sqlList   = "SELECT Sigla, Categoria FROM mydb.Categoria ORDER BY Categoria";
    private final String sqlFind   = "SELECT Sigla, Categoria FROM mydb.Categoria WHERE Sigla = ?";

    public void insert(Categoria categoria) throws SQLException{
        conn = connect();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sqlInsert);
            ps.setString(1, categoria.getSigla());
            ps.setString(2, categoria.getNomeCategoria());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }
        
    }
    
    public void update(Categoria categoria) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, categoria.getNomeCategoria());
            ps.setString(2, categoria.getSigla());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }
    }
    
    public void remove(String sigla) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlRemove);
            ps.setString(1, sigla);
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }

    }
    
    public ArrayList<Categoria> list() throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            ArrayList<Categoria> list = new ArrayList<>();
            Categoria categoria;
            while (rs.next()){
                categoria = new Categoria();
                categoria.setSigla(rs.getString("Sigla"));
                categoria.setNomeCategoria(rs.getString("Categoria"));
                list.add(categoria);
            }
            return list;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }
    }

    public Categoria find(String id)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setString(1, id);

            rs = ps.executeQuery();
            Categoria categoria = null ;

            if (rs.next()){
                categoria = new Categoria();
                categoria.setSigla(rs.getString("Sigla"));
                categoria.setNomeCategoria(rs.getString("Categoria"));
            }
            return categoria;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }       
    }
}