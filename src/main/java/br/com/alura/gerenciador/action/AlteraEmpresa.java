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

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String nomeEmpresa = request.getParameter("nome");// recebendo o parâmetro passado no input no navegador
		String dataEmpresa = request.getParameter("data");// recebendo o parâmetro passado no input no navegador
		String paramId = request.getParameter("id");// aqui a requisição vai pegar um parâmetro que é do tipo String,
													// mas para isso funcionar precisa converter para String o tipo do
													// id que é Integer
		Integer id = Integer.valueOf(paramId);// aqui faz a conversão do Integer para String. Usa o valueOf ao invés de
												// parse, porque o valueOf é do tipo int Integer e não int int

		System.out.println("Altera empresa..." + id);

		Date dataAbertura = null;// inicializando a variável antes do try catch para que possa ser usada fora do
									// escopo do try cach
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);// parseando a data de abertura, de string para Date
		} catch (ParseException e) {
			throw new ServletException(e);// tratando a excessão que pode ser gerada pelo parseamento e jogando ela para
											// tratar como uma ServletException
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);// usando o método para buscar a empresa e setar o novo nome e
														// data de abertura conforme abaixo...
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		return "redirect:entrada?acao=ListaEmpresas";// redirecionando para o navegador, para que os dados novos
															// apareçam listados

	}

}
