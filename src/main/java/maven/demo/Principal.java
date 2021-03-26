package maven.demo;

import java.util.*;

public class Principal {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();
		
		System.out.println("Digite 1, 2, 3, 4 ou 5:");
		System.out.println("1. Listar\n" + 
				"2. Inserir\n" + 
				"3. Excluir\n" + 
				"4. Atualizar\n" + 
				"5. Sair");
		
		int opcao;
		int codigo;

		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			Cientista[] cientistas = dao.getCientistas();
			for (int i = 0; i < cientistas.length; i++) {
				System.out.println(cientistas[i].toString());
			}
			break;
		case 2:
			String nome, area, contribuicao, nacionalidade;
			
			System.out.print("Digite o código: ");
			codigo = sc.nextInt();		
			System.out.print("Digite o nome: ");
			nome = sc.next();
			System.out.print("Digite o area: ");
			area = sc.next();			
			System.out.print("Digite o contribuicao: ");
			contribuicao = sc.next();
			System.out.print("Digite o nacionalidade: ");
			nacionalidade = sc.next();
			
			Cientista cientista = new Cientista(codigo, nome, area, contribuicao, nacionalidade);
			dao.inserirCientista(cientista);
			break;
		case 3:
			System.out.print("Digite o código do cientista para excluir: ");
			codigo = sc.nextInt();
			dao.excluirCientista(codigo);
			break;
		case 4:
			System.out.print("Digite o código do cientista para atualizar: ");
			codigo = sc.nextInt();
			System.out.print("Digite o nome do campo para atualizar: ");
			String coluna = sc.next();
			System.out.print("Digite o valor do campo para atualizar: ");
			String valor = sc.next();
			
			dao.atualizarCientista(codigo, coluna, valor);
			break;
		case 5:
			System.exit(0);;
		}
		
	}
}
