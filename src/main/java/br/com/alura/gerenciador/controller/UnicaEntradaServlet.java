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

		
		//ABAIXO TODO O C�DIGO ACIMA COM OS PASSOS PARA CHEGAR A ESSE FIM
		
//		String nomeDaClasse = "br.com.alura.gerenciador.action." + paramAcao; // aqui pega o nome codificado da classe e
//																				// atribui � refer�ncia nomeDaClasse. OBS.:
//																				//procura a a��o dentro deste pacote
//																				//br.com.alura.gerenciador.action.
//		String nome;
//		try {//usa um try/multi-catch Block porque o m�todo service s� pode jogar ServletException e IOException e n�o � poss�vel adicionar novas excess�es nesse m�todo por causa da heran�a
//			
//			Class classe = Class.forName(nomeDaClasse);// agora digo: JVM, pega o nome dessa classe e carrega essa classe pra
//														// mim (carrega o nome da classe com o nome da string). Ele retorna
//														// uma representa��o em mem�ria da classe. Isso n�o � um objeto, � o
//														// meu c�digo compilado em mem�ria l� que a JVM carregou.
//
//			//Object obj = classe.newInstance(); // Se voc� quer ter um objeto, tem que ter primeiro a classe, a JVM precisa
//												// carregar uma classe, ent�o agora baseado nesse classe instanciamos o objeto.
//												// Est� marcado porque talvez em alguma vers�o no futuro esse m�todo possa ser
//												// removido e deixar de existir. Essa newInstance() retorna um objeto
//
//			//Acao acao = (Acao) obj;// transforma a refer�ncia obj do tipo gen�rio em uma refer�ncia do tipo
//									// espec�fico para que atrav�s do obj eu possa chamar o m�todo executa(). Agora
//									// todo o c�digo baseado em repeti��o de ifs pode deixar de existir(est�
//									// comentado abaixo).
//
//			Acao acao = (Acao) classe.newInstance(); //criando a inst�ncia da a��o j� fazendo um cast para a interface Acao para o tipo de referencia acao
//			
//			nome = acao.executa(request, response);//chamando aqui o m�todo executa. 
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
//				| IOException e) {
//			throw new ServletException(e);//aqui crio uma ServletException e digo para ela levar a exce��o original
//		}
//		
//		/**
//		 * Acontece que tirando das classes actions, as responsabilidades de delegar o fluxo a ser seguido,
//		 * agora quem vai controlar o fluxo das requisi��es � a classe controladora (servlet) e para isso
//		 * acontecer, � preciso dizer pra servlet o que ela precisa fazer: escolher se vai encaminhar
//		 * a requisi��o a uma classe action (requestDispatcher), ou se vai devolver uma resposta ao
//		 * navegador pedindo que ele fa�a uma nova requisi��o a um endere�o especificado pela servlet
//		 * (sendRedirect). Para isso acontecer terei um if que ter� como condi��o a compara��o de uma
//		 * posi��o de um array com o retorno da action. Ou seja, o navegador vai enviar a requisi��o
//		 * atrav�s de um par�metro para a classe action que vai executar uma a��o no m�todo executa(),
//		 * e ao fim do m�todo vai ter como retorno um [tipo] de direcionamento da requisi��o(forward
//		 * ou redirect) e um [endere�o] para onde vai ser direcionado (refer�ncia do array posi��o [0]
//		 * e posi��o [1]), seja atrav�s do requestDispatcher ou do sendRedirect. Com isso a servlet vai
//		 *  saber o que fazer com a requisi��o, ou um ou outro.
//		 */
//		
//		String[] tipoEEndereco = nome.split(":");
//		if (tipoEEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);// aqui informa ao requestDispatcher
//																									// que os arquivos .jsp est�o dentro
//																									// da pasta WEB-INF/view/
//			rd.forward(request, response);
//		} else {
//			response.sendRedirect(tipoEEndereco[1]);
//		}

//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);// o par�metro nome vai receber a a��o executada na action ListaEmpresas
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();// instancia a a��o
//			nome = acao.executa(request, response);// chama o m�todo executa
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

