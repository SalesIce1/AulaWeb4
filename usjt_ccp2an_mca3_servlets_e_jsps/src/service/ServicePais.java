package service;
import model.Pais;
import dao.DAOPais;

public class ServicePais 
{
	private DAOPais dao;
	public ServicePais() 
	{
		dao = new DAOPais();
	}
	public void criar(Pais pais) 
	{
		pais.setId(dao.criar(pais.getNome(), pais.getPopulacao(), pais.getArea()));
	}
	public void atualizar(Pais pais) 
	{
		dao.atualizar(pais.getId(),pais.getNome(),pais.getPopulacao(), pais.getArea());
	}
	public void excluir (int id) 
	{
		dao.excluir(id);
	}
	public Pais carregar(Pais pais) 
	{
		Pais aux = dao.carregar(pais.getId());
		pais.setNome(aux.getNome());
		pais.setPopulacao(aux.getPopulacao());
		pais.setArea(aux.getArea());	
		return pais;
	}
	public void maiorP(Pais pais)
	{	
		dao.maiorPopulacao(pais);
		}
	public Pais[] vetorTresPaises() 
	{
		Pais x[] = new Pais[3];	
		for(int i=0;i<3;i++) 
		{
			x[i]=dao.carregar(i+1);
		}
		return x;
	}
	public void menorA(Pais pais)
	{
		dao.menorArea(pais);
	}
}