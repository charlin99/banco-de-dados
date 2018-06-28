package dao;

import model.Funcionario;
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
public class FuncionariosDAO {
    private Connection conn;
    private final String sqlInsert = "INSERT INTO mydb.Funcionario(CPF, Nome, Data_Contratação, Locadora_CNPJ) VALUES (?,?,?,?)";
    private final String sqlUpdate = "UPDATE mydb.Funcionario SET Nome = ?, Data_Contratação = ?, Locadora_CNPJ = ?, WHERE CPF = ? ";
    private final String sqlRemove = "DELETE FROM mydb.Funcionario WHERE CPF = ?";
    private final String sqlList   = "SELECT CPF, Nome, Data_Contratação, Locadora_CNPJ FROM mydb.Funcionario ORDER BY Nome";
    private final String sqlFind   = "SELECT CPF, Nome, Data_Contratação, Locadora_CNPJ FROM mydb.Funcionario WHERE CPF = ?";
    
    public void insert(Funcionario funcionario) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlInsert);
        
            ps.setString(1, funcionario.getCPF());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getData());
            ps.setString(4, funcionario.getLocadora().getCNPJ());
            ps.execute();
        }
        finally{
            ps.close();
            close(conn);
        }        
    }
    
    public void update(Funcionario funcionario) throws SQLException{
        PreparedStatement ps = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, funcionario.getCPF());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getData());
            ps.setString(4, funcionario.getLocadora().getCNPJ());
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

    public ArrayList<Funcionario> list() throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            ArrayList<Funcionario> list = new ArrayList<>();
            Funcionario funcionario;
            LocadorasDAO locadorasDao = new LocadorasDAO();
            while (rs.next()){
                funcionario = new Funcionario();
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setData(rs.getString("Data_Contratação"));
                funcionario.setLocadora(locadorasDao.find(rs.getString("Locadora_CNPJ")));
                list.add(funcionario);
            }
            return list;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }
    }

    public Funcionario find(int id)throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            Funcionario funcionario = null ;
            LocadorasDAO locadorasDao = new LocadorasDAO();
            if (rs.next()){
                funcionario = new Funcionario();
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setData(rs.getString("Data_Contratação"));
                funcionario.setLocadora(locadorasDao.find(rs.getString("Locadora_CNPJ")));
            }
            return funcionario;
        }
        finally{
            rs.close();
            ps.close();
            close(conn);
        }
        
    }

    private Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
