package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter (urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long antes  = System.currentTimeMillis();//pega o tempo em milesegundos (contado a partir de 1970) antes de iniciar a ação
		
		String acao = request.getParameter("acao");//recupera a ação da requisição
		chain.doFilter(request, response);//diz para a execução da ação continuar, caso contrário, vai parar
		
		long depois = System.currentTimeMillis();//pega o tempo em milesegundos (contado a partir de 1970) depois de executar a ação
		
		System.out.println("Tempo de execução da ação " + acao + ": " + (depois - antes));

	}

}
