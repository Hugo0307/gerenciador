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

		String login = request.getParameter("login");// vai recupara o login informado pelo usuário
		senha = request.getParameter("senha");// vai recuperar a senha que o usuário informou

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usuario existe!");
			System.out.println("Bem vindo ao sistema " + login + " !");

			/**
			 * Quando o usuário envia uma requisição, o Tomcat atribui um
			 * JSESSIONID(hexadecimal) à requisição para saber se aquele usuario e navegador
			 * são os mesmos na próximas requisições. E atrela essa JSESSIONID a um objeto
			 * do tipo HttpSession. A partir dessa dinâmica o usuário logado pode ser
			 * identificado nas próximas requisições.
			 */
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);// está dando um apelido(usuárioLogado) ao objeto HttpSession
															// para ser usado como identificação do usuário que fez o
															// login na página
			// caso o login seja validado com sucesso, o usuário será redirecionado para a
			// página de ListaEmpresas
			return "redirect:entrada?acao=ListaEmpresas";// redirecionando...
		} else {
			return "redirect:entrada?acao=LoginForm";// caso o usuario não seja validado com sucesso, será redirecionado
														// para a página de login novamente
		}
	}

}
