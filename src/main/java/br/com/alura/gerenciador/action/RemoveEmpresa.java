package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("Removendo empresa...");

		String paramId = request.getParameter("id");// aqui a requisi��o vai pegar um par�metro que � do tipo String,
													// mas para isso funcionar precisa converter para String o tipo do
													// id que � Integer
		Integer id = Integer.valueOf(paramId);// aqui faz a convers�o do Integer para String. Usa o valueOf ao inv�s de
												// parse, porque o valueOf � do tipo int Integer e n�o int int

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";

	}

}
