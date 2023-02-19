package br.com.agenda.aplicacao;


import java.util.Date;
import java.util.Scanner;
import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);		
		Contato c = new Contato();	
		ContatoDAO contatoDAO = new ContatoDAO();
		
		System.out.println("MENU PRINCIPAL");		
		System.out.println("1 - CADASTRAR UM NOVO CONTATO");
		System.out.println("2 - ALTERAR UM CONTATO");
		System.out.println("3 - LISTAR TODOS OS CONTATOS");
		System.out.println("4 - REMOVER UM CONTATO");
		System.out.print("\nDIGITE A OPÇÃO DESEJADA: ");
		int op = entrada.nextInt();
		
		if(op == 1) {
			
			entrada.nextLine();
			System.out.print("Informe o nome do contato: ");
			String nome = entrada.nextLine();
			c.setNome(nome);		
			System.out.print("Informe a idade do contato: ");
			int idade = entrada.nextInt();
			c.setIdade(idade);
			entrada.nextLine();
			c.setDataCadastro(new Date());
			
			contatoDAO.save(c);
		}
		
		if (op == 2) {
			
		entrada.nextLine();
		
		System.out.print("Informe o novo nome do contato: ");
		String nome = entrada.nextLine();
		c.setNome(nome);
		System.out.print("Informe a nova idade do contato: ");
		int idade = entrada.nextInt();
		c.setIdade(idade);
		System.out.print("Informe o ID: ");
		int cod = entrada.nextInt();
		c.setId(cod);
		
		contatoDAO.update(c);
		}
		
		if (op == 3) {		
			contatoDAO.getContatos();
		}
	
		if (op == 4) {
			System.out.print("\nINFORME O ID DO CONTATO QUE DESEJA REMOVER: ");
			int id = entrada.nextInt();
			c.setId(id);
			contatoDAO.remover(c);
		}
		
		entrada.close();
	}

}
