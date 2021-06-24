package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("Removendo empresa...");

		String paramId = request.getParameter("id");// aqui a requisição vai pegar um parâmetro que é do tipo String,
													// mas para isso funcionar precisa converter para String o tipo do
													// id que é Integer
		Integer id = Integer.valueOf(paramId);// aqui faz a conversão do Integer para String. Usa o valueOf ao invés de
												// parse, porque o valueOf é do tipo int Integer e não int int

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";

	}

}
