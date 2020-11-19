package banco;

public class Conta {
	Pessoa cliente;
	int nrConta;
	double saldo;
	
	public Conta(Pessoa cliente, int nrConta, double saldo) {
		super();
		this.cliente=cliente;
		this.nrConta=nrConta;
		this.saldo=saldo;
	}
	
	
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public int getNrConta() {
		return nrConta;
	}
	public void setNrConta(int nrConta) {
		this.nrConta = nrConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	protected Boolean temSaldo(Double valor) {
		return (valor <= this.saldo);
	}
	
	
	private void adicionar(Double valor) {
		this.saldo += valor;
	}
	
	private void debitar(Double valor) {
		this.saldo -= valor;
	}
	
	public void sacar(Double valor) {
		if(this.temSaldo(valor)) {
			this.debitar(valor);
			System.out.println("Saque efetuado! Saldo atualizado: "+this.saldo);
		}else{
			System.out.println("Saldo Insuficiente");
		}
	}
	
	
	public void transferir(Double valor, Conta destino) {
		if(this.temSaldo(valor)) {
			this.debitar(valor);
			destino.adicionar(valor);
			System.out.println("Transferencia efetuada! Saldo atualizado: "+this.saldo);
		}else {
			System.out.println("Saldo Insuficiente");
		}
	}
	
	public void depositar(Double valor) {
		this.adicionar(valor);
		System.out.println("Deposito efetuado!");
		System.out.println("Saldo atualizado:"+this.saldo);
	}
	
	
}
