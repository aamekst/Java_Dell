package br.com.dell.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dell.beans.Notebook;

public class NotebookDAO {
	
	private Connection con;
	
		
		public Connection getCon() {
			return con;
		}
	
		public void setCon(Connection con) {
			this.con = con;
		}
	
		public NotebookDAO(Connection con){
			setCon(con);
		}

		//metodo inserir
		public String inserirNotebook(Notebook notebook)
		{
			String sql = "insert into notebook(cor, peso, tamanhoTela) values (?,?,?)";
			
			try {
				
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1, notebook.getCor());
				ps.setDouble(2, notebook.getPeso());
				ps.setDouble(3, notebook.getTamanhoTela());
				if(ps.executeUpdate()>0) {
					return "Inserido com sucesso!";
				}else {
					return "Erro ao inserir";
				}
				
				
			}catch (SQLException e)
			{
				return e.getMessage();
			}
			
		}
}
