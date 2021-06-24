package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao {
//Agora aqui este padr�o (Design Pattern) de projeto se chama command (as a��es definem apenas um m�todo), apenas uma classe que encapsula a execu��o de alguma coisa.
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Listando as empresas...");
		
//		HttpSession sessao = request.getSession();//pegando o JSESSIONID no cookie da requisi��o
//		if(sessao.getAttribute("usuarioLogado") == null) {//verificando se na p�gina ListaEmpresas o usu�rio fez login ou n�o
//			return "redirect:entrada?acao=LoginForm";//se n�o fez login antes de ir pra p�gina ListaEmpresas, ele � redirecionado para a p�gina de login
//		}
		
		Banco banco = new Banco();// precisa instanciar a classe para poder usar o getEmpresas atrav�s da classe
		// Banco

		List<Empresa> lista = banco.getEmpresas();// chamando o m�todo getEmpresas tipo lista para atribuir � vari�vel
		// lista a lista das empresas cadastradas

		request.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";

	}

}
