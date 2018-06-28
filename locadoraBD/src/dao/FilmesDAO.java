package dao;

import model.Filme;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class FilmesDAO extends DbConnection{
    private Connection conn;
    private final String sqlInsert = "INSERT INTO mydb.Filme(ID, Nome, Preço, Categoria) VALUES (?,?,?,?)";
    private final String sqlUpdate = "UPDATE mydb.Filme SET Categoria = ?, Nome = ?, Preço = ?, WHERE ID = ? ";
    private final String sqlRemove = "DELETE FROM mydb.Filme WHERE ID = ?";
    private final String sqlList   = "SELECT ID, Nome, Preço, Categoria FROM mydb.Filme ORDER BY Nome";
    private final String sqlFind   = "SELECT ID, Nome, Preço, Categoria FROM mydb.Filme WHERE ID = ?";
    
    public void insert(Filme filme) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlInsert);
        
            ps.setInt(1, filme.getId());
            ps.setString(2, filme.getNome());
            ps.setFloat(3, filme.getPreco());
            ps.setString(4, filme.getCategoria().getSigla());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }        
    }

    public void update(Filme filme) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setInt(1, filme.getId());
            ps.setString(2, filme.getNome());
            ps.setFloat(3, filme.getPreco());
            ps.setString(4, filme.getCategoria().getSigla());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }
    }
    public void remove(int id) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlRemove);
            ps.setInt(1, id);
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }

    }
    
    public ArrayList<Filme> list() throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            ArrayList<Filme> list = new ArrayList<>();
            Filme filme;
            CategoriasDAO categoriasDao = new CategoriasDAO();
            while (rs.next()){
                filme = new Filme();
                filme.setId(rs.getInt("ID"));
                filme.setNome(rs.getString("Nome"));
                filme.setPreco(rs.getFloat("Preço"));
                filme.setCategoria(categoriasDao.find(rs.getString("Categoria")));
                list.add(filme);
            }
            return list;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }
    }

    public Filme find(int id)throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            Filme filme = null ;
            CategoriasDAO categoriasDao = new CategoriasDAO();
            if (rs.next()){
                filme = new Filme();
                filme.setId(rs.getInt("ID"));
                filme.setNome(rs.getString("Nome"));
                filme.setPreco(rs.getFloat("Preço"));
                filme.setCategoria(categoriasDao.find(rs.getString("Categoria")));
            }
            return filme;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }
        
    }
}