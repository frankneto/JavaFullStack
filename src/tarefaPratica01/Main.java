package banco;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main (String[] args) {
			
		//instancio e crio os dados da pessoa fisica
		// id, nome, endereco, cpf, data nascimento e genero
		@SuppressWarnings("deprecation")
		PessoaFisica frank = new PessoaFisica(1, "Francisco", "Goiania", 333, new Date(1987, 10, 4), "masculino");
		@SuppressWarnings("deprecation")
		PessoaFisica neto = new PessoaFisica(2, "Neto", "Goiania", 777, new Date(1987, 10, 4), "masculino");
		
		
		
		//instancio e crio os dados da pessoa juridica
		// id, nome, endereco, cnpj, e atividade
		PessoaJuridica restaurante = new PessoaJuridica(1, "Restaurante", "Goiania", 100, "alimentos");
		PessoaJuridica padaria = new PessoaJuridica(2, "Padaria", "Goiania", 200, "Alimentos");
		
		
		//instancio e crio os dados da conta especial vinculado ao nome da pessoa
		//cliente, nrConta, saldo, limite
		ContaEspecial ceFrank = new ContaEspecial(frank, 1, 1000.0, 1000.0);
		ContaPoupanca cpNeto = new ContaPoupanca(neto, 2, 1000.0, 1000.0);
		
		
		//instancio e crio os dados da conta especial vinculado ao nome da empresa
		//nome empresa, nrConta, saldo, limite
		ContaEspecial ceRestaurante = new ContaEspecial(restaurante, 2, 1000.0, 1000.0);
		ContaPoupanca cpPadaria = new ContaPoupanca(padaria, 3, 1000.0, 1000.0);
		
		System.out.println("Tenho na conta");
		System.out.println(ceFrank.getSaldo());
		System.out.print("\n");
		
		System.out.println("Tiro 100 reais");
		ceFrank.sacar(100.0);
		System.out.print("\n");
		
		System.out.println("Tenho na conta");
		System.out.println(cpNeto.getSaldo());
		System.out.print("\n");
		
		System.out.println("Deposito 200 na conta");
		cpNeto.depositar(200.0);
			
		
		
		System.out.print("\n");
		System.out.println("Tem na conta juridica");
		System.out.println(ceRestaurante.getSaldo());
		
		System.out.println("Transfiro 500 para o Neto");
		ceRestaurante.transferir(500.0, cpNeto);
		
		System.out.print("\n");
		System.out.println("O restaurante tem na conta agora: " +ceRestaurante.getSaldo());
		System.out.print("\n");
		
		System.out.println("Apos 500 de transferencia vindo do restaurante, o Neto fica com "+cpNeto.getSaldo());
		System.out.print("\n");
		System.out.print("\n");
		
		
		
		List<Conta> listConta = new ArrayList<Conta>();
		listConta.add(ceFrank);
		listConta.add(cpNeto);
		listConta.add(ceRestaurante);
		listConta.add(cpPadaria);
		
		//crio uma variavel zerada para receber os valores das contas
		Double totalContas = 0.0;
		
		//for para varrer as contas
		for(Conta c : listConta) {
			System.out.println("Nome: "+c.getCliente().getNome()+", saldo: R$ "+c.getSaldo());
			//aqui cada valor da conta é adicionado ao total
			totalContas += c.getSaldo();
		}
		
		System.out.print("\n");
		System.out.println("Total de todas as contas fisicas e juridicas: R$ "+totalContas);
	}
}
