package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao {
//Agora aqui este padrão (Design Pattern) de projeto se chama command (as ações definem apenas um método), apenas uma classe que encapsula a execução de alguma coisa.
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Listando as empresas...");
		
//		HttpSession sessao = request.getSession();//pegando o JSESSIONID no cookie da requisição
//		if(sessao.getAttribute("usuarioLogado") == null) {//verificando se na página ListaEmpresas o usuário fez login ou não
//			return "redirect:entrada?acao=LoginForm";//se não fez login antes de ir pra página ListaEmpresas, ele é redirecionado para a página de login
//		}
		
		Banco banco = new Banco();// precisa instanciar a classe para poder usar o getEmpresas através da classe
		// Banco

		List<Empresa> lista = banco.getEmpresas();// chamando o método getEmpresas tipo lista para atribuir à variável
		// lista a lista das empresas cadastradas

		request.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";

	}

}
