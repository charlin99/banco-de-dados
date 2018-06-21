package dao;

import model.Locadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André  Schwerz
 */
public class LocadorasDAO extends DbConnection{
    private Connection conn;
    private final String sqlInsert = "INSERT INTO mydb.Locadora(CNPJ, cidade) VALUES (?,?)";
    private final String sqlUpdate = "UPDATE mydb.Locadora SET cidade = ? WHERE CNPJ = ? ";
    private final String sqlRemove = "DELETE FROM mydb.Locadora WHERE CNPJ = ?";
    private final String sqlList   = "SELECT CNPJ, cidade FROM mydb.Locadora ORDER BY cidade";
    private final String sqlFind   = "SELECT CNPJ, cidade FROM mydb.Locadora WHERE CNPJ = ?";

    public void insert(Locadora locadora) throws SQLException{
        conn = connect();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sqlInsert);
            ps.setString(1, locadora.getCNPJ());
            ps.setString(2, locadora.getCidade());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }
        
    }
    
    public void update(Locadora locadora) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, locadora.getCidade());
            ps.setString(2, locadora.getCNPJ());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }
    }
    
    public void remove(String CNPJ) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlRemove);
            ps.setString(1, CNPJ);
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }

    }
    
    public ArrayList<Locadora> list() throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            ArrayList<Locadora> list = new ArrayList<>();
            Locadora locadora;
            while (rs.next()){
                locadora = new Locadora();
                locadora.setCNPJ(rs.getString("CNPJ"));
                locadora.setCidade(rs.getString("cidade"));
                list.add(locadora);
            }
            return list;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }
    }

    public Locadora find(String CNPJ)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setString(1, CNPJ);

            rs = ps.executeQuery();
            Locadora locadora = null ;

            if (rs.next()){
                locadora = new Locadora();
                locadora.setCNPJ(rs.getString("CNPJ"));
                locadora.setCidade(rs.getString("cidade"));
            }
            return locadora;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }       
    }
}