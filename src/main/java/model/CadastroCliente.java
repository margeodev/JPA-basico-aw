package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroCliente {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager manager = emf.createEntityManager();
		
		Cliente cliente2 = new Cliente();
		
		cliente2.setNome("Banco Itau");
		
//		adiciona(cliente2, manager);
		
//		atualiza(cliente2, manager, 2L);
		
		remove(3L, manager);
		
		manager.close();
		emf.close();
	}
	
	private static void adiciona(Cliente cliente, EntityManager manager) {
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}	

	private static void atualiza(Cliente cliente, EntityManager manager, Long id) {
		Cliente c1 = manager.find(Cliente.class, id);
		c1.setNome(cliente.getNome());
		
		manager.getTransaction().begin();
		manager.persist(c1);
		manager.getTransaction().commit();
		manager.getTransaction().commit();
	}	
	
	private static void remove(Long id, EntityManager manager) {
		Cliente c1 = manager.find(Cliente.class, id);
		
		manager.getTransaction().begin();
		manager.remove(c1);
		manager.getTransaction().commit();
	}
	
}
