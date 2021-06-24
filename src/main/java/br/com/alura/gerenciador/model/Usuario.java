package br.com.alura.gerenciador.model;

public class Usuario {

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean possuiCredenciais(String login, String senha) {// método que vai validar se o login e senha informados pelo
														// usuário é igual às informações que constam no banco de dados
		if (!this.login.equals(login)) {
			return false;
		}
		if (!this.senha.equals(senha)) {
			return false;
		}

		return true;
	}
}