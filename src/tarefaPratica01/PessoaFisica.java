package banco;

import java.util.Date;
import java.util.Calendar;

public class PessoaFisica extends Pessoa{
	int cpf;
	Date dataNascimento;
	String genero;
	
	public PessoaFisica(int id, String nome, String endereco,int cpf,Date dataNascimento, String genero) {
		super(id, nome, endereco);
		this.cpf=cpf;
		this.dataNascimento=dataNascimento;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	public Integer getIdade() {
		Calendar calHoje = Calendar.getInstance();
		Calendar calNascimento = Calendar.getInstance();
		calNascimento.setTime(dataNascimento);
		
		@SuppressWarnings("deprecation")
		int anoNascimento = dataNascimento.getYear(); 
		int anoAtual = calHoje.get(Calendar.YEAR);
		
		if (calNascimento.getTimeInMillis() >= calHoje.getTimeInMillis()) { 
			return anoAtual - anoNascimento; 
		} else {
			return anoAtual - anoNascimento - 1;
		}
		
	}
	
}
