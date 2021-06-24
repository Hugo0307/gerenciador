package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.action.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "deprecation", "rawtypes" })
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.alura.gerenciador.action." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("usuarioLogado") != null) {
			String[] tipoEEndereco = nome.split(":");
			if (tipoEEndereco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(tipoEEndereco[1]);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/formLogin.jsp");
			rd.forward(request, response);
		}
		
	}

}

		
		//ABAIXO TODO O CÓDIGO ACIMA COM OS PASSOS PARA CHEGAR A ESSE FIM
		
//		String nomeDaClasse = "br.com.alura.gerenciador.action." + paramAcao; // aqui pega o nome codificado da classe e
//																				// atribui à referência nomeDaClasse. OBS.:
//																				//procura a ação dentro deste pacote
//																				//br.com.alura.gerenciador.action.
//		String nome;
//		try {//usa um try/multi-catch Block porque o método service só pode jogar ServletException e IOException e não é possível adicionar novas excessões nesse método por causa da herança
//			
//			Class classe = Class.forName(nomeDaClasse);// agora digo: JVM, pega o nome dessa classe e carrega essa classe pra
//														// mim (carrega o nome da classe com o nome da string). Ele retorna
//														// uma representação em memória da classe. Isso não é um objeto, é o
//														// meu código compilado em memória lá que a JVM carregou.
//
//			//Object obj = classe.newInstance(); // Se você quer ter um objeto, tem que ter primeiro a classe, a JVM precisa
//												// carregar uma classe, então agora baseado nesse classe instanciamos o objeto.
//												// Está marcado porque talvez em alguma versão no futuro esse método possa ser
//												// removido e deixar de existir. Essa newInstance() retorna um objeto
//
//			//Acao acao = (Acao) obj;// transforma a referência obj do tipo genério em uma referência do tipo
//									// específico para que através do obj eu possa chamar o método executa(). Agora
//									// todo o código baseado em repetição de ifs pode deixar de existir(está
//									// comentado abaixo).
//
//			Acao acao = (Acao) classe.newInstance(); //criando a instância da ação já fazendo um cast para a interface Acao para o tipo de referencia acao
//			
//			nome = acao.executa(request, response);//chamando aqui o método executa. 
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
//				| IOException e) {
//			throw new ServletException(e);//aqui crio uma ServletException e digo para ela levar a exceção original
//		}
//		
//		/**
//		 * Acontece que tirando das classes actions, as responsabilidades de delegar o fluxo a ser seguido,
//		 * agora quem vai controlar o fluxo das requisições é a classe controladora (servlet) e para isso
//		 * acontecer, é preciso dizer pra servlet o que ela precisa fazer: escolher se vai encaminhar
//		 * a requisição a uma classe action (requestDispatcher), ou se vai devolver uma resposta ao
//		 * navegador pedindo que ele faça uma nova requisição a um endereço especificado pela servlet
//		 * (sendRedirect). Para isso acontecer terei um if que terá como condição a comparação de uma
//		 * posição de um array com o retorno da action. Ou seja, o navegador vai enviar a requisição
//		 * através de um parâmetro para a classe action que vai executar uma ação no método executa(),
//		 * e ao fim do método vai ter como retorno um [tipo] de direcionamento da requisição(forward
//		 * ou redirect) e um [endereço] para onde vai ser direcionado (referência do array posição [0]
//		 * e posição [1]), seja através do requestDispatcher ou do sendRedirect. Com isso a servlet vai
//		 *  saber o que fazer com a requisição, ou um ou outro.
//		 */
//		
//		String[] tipoEEndereco = nome.split(":");
//		if (tipoEEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);// aqui informa ao requestDispatcher
//																									// que os arquivos .jsp estão dentro
//																									// da pasta WEB-INF/view/
//			rd.forward(request, response);
//		} else {
//			response.sendRedirect(tipoEEndereco[1]);
//		}

//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);// o parâmetro nome vai receber a ação executada na action ListaEmpresas
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();// instancia a ação
//			nome = acao.executa(request, response);// chama o método executa
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}

