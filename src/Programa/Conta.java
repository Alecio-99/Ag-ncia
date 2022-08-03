package Programa;

public class Conta {
  private static int contador =1;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;
	public Conta(int numeroConta, Pessoa pessoa, double saldo) {
		this.numeroConta = contador;
		this.pessoa = pessoa;
	    contador += 1;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", pessoa=" + pessoa + ", saldo=" + saldo + "]";
	}
	
	public void depositar(Double valor) {
		if(valor > 0 ) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado coms sucesso! ");
		}else {
			System.out.println("Não foi possível realizar o depósito! ");
		}
	}
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
		  setSaldo(getSaldo() -  valor);
		  System.out.println("Saque realizado com sucesso! ");
		}else {
			System.out.println("Não foi possível realizar o saque! ");
		}
	}
	
	public void tranferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			
			System.out.println("Tranferencia realizada com sucesso! ");
		}else {
			System.out.println("Não foi possível realizar a transferencia! ");
		}
	}
}
  