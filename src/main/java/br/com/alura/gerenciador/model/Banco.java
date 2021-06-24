package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();// atributo est�tico que retorna lista de empresas
	private static List<Usuario> listaUsuarios = new ArrayList<>();// atributo est�tico que retorna lista de usu�rios
	private static Integer chaveSequencial = 1;

	static {// esse � um bloco est�tico, logo quando a JVM carregar a classe, entrar� nesse
			// bloco e adicionar� as empresas setadas � lista de empresas
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Sorveteria Silva");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Malu Picoleteria");
		Banco.listaEmpresas.add(empresa);
		Banco.listaEmpresas.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("Hugo");
		usuario1.setSenha("12345");
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("Mayara");
		usuario2.setSenha("12345");
		
		Banco.listaUsuarios.add(usuario1);
		Banco.listaUsuarios.add(usuario2);
		

	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		listaEmpresas.add(empresa);

	}

	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}

	public void removeEmpresa(Integer id) {//apagar a empresa que possui esse id
		
		Iterator<Empresa> it = listaEmpresas.iterator();//faz a intera��o da lista com os elementos da classe Empresa

	    while(it.hasNext()) {//na intera��o tem um pr�ximo? enquanto houver um pr�ximo elemento a ser acessado, o la�o continuar�
	        Empresa emp = it.next();//se tem um pr�ximo, me d� esse pr�ximo e atribua � vari�vel emp

	        if(emp.getId() == id ) {//aqui pergunto: empresa, o seu id � igual ao id do par�metro? se for verdade...
	            it.remove();//remova da intera��o
	        }
//		for (Empresa empresa : listaEmpresas) {//la�o para gerar intera��o
//			if(empresa.getId() == id) {//aqui pergunto: empresa, o seu id � igual ao id do par�metro? se for verdade...
//				listaEmpresas.remove(empresa);//...ent�o remove a empresa da lista
//			}
//		}
		
		}
	
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {//para cada usuario na listaUsuarios
			if(usuario.possuiCredenciais(login, senha)) {//se login e senha usuario � igual ao cadastro, retorna usuario
				return usuario;
			}
		}
		return null;
	}

}