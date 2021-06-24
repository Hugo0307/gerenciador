package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/cheguei")//fdiz que a classe abaixo é uma servlet e faz o mapeamento da url que faz acessar essa classe, que será a /cheguei
public class chegueiNoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override //método sobrescrito - ServletRequest é de requisição; ServletResponse é a resposta no fluxo do serviço
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();// pega a escrita para a response e atribui à variável out que é do tipo
											// PrintWriter(printar a escrita na tela; se fosse System seria no console)
		
		out.println("<html>");// obrigatório: identifica que é uma página html
		out.println("<meta charset = UTF-8>");
		out.println("<body>");// aqui a tag que abre o corpo onde será exibida a mensagem
		out.println("<br>");
		out.println("<big>FELIZ ANIVERSÁRIO MEU AMOR!<br>QUE DEUS CUBRA DE BENÇÃOS SUA VIDA!"
				+ "<br>CONTINUE COM ESSA PAZ, ESSE AMOR QUE SEMPRE TRAZ NO TEU SORRISO!<br>TE AMO MUITO!</big>");
		//out.println("Cheguei no Servlet! hahaha");// mensagem que será exibida na tela do navegador
		out.println("</body>");// aqui a tag que encerra o corpo da mensagem
		out.println("</html>");// encerra a página html

		System.out.println("Executando o servlet!");// essa mensagem será exibida no console somente para ver que o
													// servlet foi executado
	}

}
