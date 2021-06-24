package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class Login implements Acao {

	String senha = null;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");// vai recupara o login informado pelo usu�rio
		senha = request.getParameter("senha");// vai recuperar a senha que o usu�rio informou

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usuario existe!");
			System.out.println("Bem vindo ao sistema " + login + " !");

			/**
			 * Quando o usu�rio envia uma requisi��o, o Tomcat atribui um
			 * JSESSIONID(hexadecimal) � requisi��o para saber se aquele usuario e navegador
			 * s�o os mesmos na pr�ximas requisi��es. E atrela essa JSESSIONID a um objeto
			 * do tipo HttpSession. A partir dessa din�mica o usu�rio logado pode ser
			 * identificado nas pr�ximas requisi��es.
			 */
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);// est� dando um apelido(usu�rioLogado) ao objeto HttpSession
															// para ser usado como identifica��o do usu�rio que fez o
															// login na p�gina
			// caso o login seja validado com sucesso, o usu�rio ser� redirecionado para a
			// p�gina de ListaEmpresas
			return "redirect:entrada?acao=ListaEmpresas";// redirecionando...
		} else {
			return "redirect:entrada?acao=LoginForm";// caso o usuario n�o seja validado com sucesso, ser� redirecionado
														// para a p�gina de login novamente
		}
	}

}
