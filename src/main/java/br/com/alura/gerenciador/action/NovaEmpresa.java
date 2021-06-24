package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Cadastrando nova empresa...");

		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");

		Date dataAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		request.setAttribute("empresa", empresa.getNome());

		return "redirect:entrada?acao=ListaEmpresas"; // aqui está fazendo o redirecionamento (o navegador envia a requisição
												// ao NovaEmpresaServlet, este devolve ao navegador a resposta mandando
												// ele enviar outra requisição ao ListaEmpresasServlet, que por sua vez
												// vai dispachar ao listaEmpresas.jsp que devolverá ao navegador o
												// resultado esperado para exibição na tela

	}
}
