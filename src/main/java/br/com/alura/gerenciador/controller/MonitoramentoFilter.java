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

		long antes  = System.currentTimeMillis();//pega o tempo em milesegundos (contado a partir de 1970) antes de iniciar a a��o
		
		String acao = request.getParameter("acao");//recupera a a��o da requisi��o
		chain.doFilter(request, response);//diz para a execu��o da a��o continuar, caso contr�rio, vai parar
		
		long depois = System.currentTimeMillis();//pega o tempo em milesegundos (contado a partir de 1970) depois de executar a a��o
		
		System.out.println("Tempo de execu��o da a��o " + acao + ": " + (depois - antes));

	}

}
