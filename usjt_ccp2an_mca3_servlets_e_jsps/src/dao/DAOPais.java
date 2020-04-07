package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pais;
public class DAOPais 
{
	public Pais maiorPopulacao(Pais pais) 
	{
		String sqlSelect = "Select  id,nome, populacao,area from Pais  order by populacao  desc limit 1;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) 
		{
			try (ResultSet rs = stm.executeQuery();) 
			{
				if (rs.next()) 
				{
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} else 
				{
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
				return pais;
			} catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
		} catch (SQLException e1) 
		{
			System.out.print(e1.getStackTrace());
			return null;
		}	
	}
	public Pais menorArea(Pais pais) 
	{
		String sqlSelect = "Select * from Pais order by area asc limit 1;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) 
		{
			try (ResultSet rs = stm.executeQuery();) 
			{
				if (rs.next()) 
				{
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} else
				{
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
				return pais;
			} catch (SQLException e)
			{
				e.printStackTrace();
				return null;
			}
		} catch (SQLException e1) 
		{
			System.out.print(e1.getStackTrace());
			return null;
		}	
	}
	
	public int criar (String nome, long populacao, double area) 
	{
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) 
		{
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) 
			{
				rs.next();
					return(rs.getInt(1));
			} catch (SQLException e) 
			{
				e.printStackTrace();
				return -1;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	public void atualizar (int id ,String nome, long populacao, double area) 
	{
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) 
		{
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);
			stm.setInt(4, id);
			stm.execute();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	public void excluir(int id) 
	{
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) 
		{
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	public Pais carregar(int id) 
	{
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) 
		{
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) 
			{
				Pais pais = new Pais(id);
				if (rs.next()) 
				{
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} else 
				{
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
				return pais;
			} catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
		} catch (SQLException e1)
		{
			System.out.print(e1.getStackTrace());
			return null;
		}
	}
}
