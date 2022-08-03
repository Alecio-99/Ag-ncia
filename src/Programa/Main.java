package Programa;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta>  contasBancarias;
	
	public static void main(String[] args) {
	
	Locale.setDefault(Locale.US);	
	contasBancarias = new ArrayList<Conta>();
	operacoes();
		
		
	}
    
	public static void operacoes() {
		System.out.println("----------------------------------------------------");
		System.out.println("---------------Bem vindo a nossa Agência------------");
		System.out.println("----------------------------------------------------");
		System.out.println("*****Selecione uma operação que deseja realizar*****");
		System.out.println("----------------------------------------------------");
		System.out.println("|Opção 1 - Criar conta |");
		System.out.println("|Opção 2 - Depositar   |");
		System.out.println("|Opção 3 - Sacar       |");
		System.out.println("|Opção 4 - Transferir  |");
		System.out.println("|Opção 5 - Listar      |");
		System.out.println("|Opção 6 - Sair        |");
		
		int operacao = input.nextInt(); 
		
		switch(operacao) {
		case 1: 
			criarConta();
			break;
		case 2: 
			depositar();
			break;	
		case 3: 
			sacar();
			break;	
	    case 4: 
	        transferir();
	        break;
		case 5: 
		    ListaContas();
			break;
		case 6: 
		    System.out.println("Obrigado por usar nossa Agência!  ");
			System.exit(0);
			
			
			default:
				System.out.println("Opção inválida");
				operacoes ();
				break;
		}
	}
	public  static void criarConta() {
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCPF: ");
		String cpf = input.next();
		
		System.out.println("\nEmail: ");
		String email = input.next();
		
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(0, pessoa, 0);
		
		contasBancarias.add(conta);
		System.out.println("Sua conta foi crada com sucesso! ");
		
		operacoes();
	}
	private static Conta encontraConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
				conta = c;
			}
		  }
		}
		return conta;
	}
	public static void depositar() {
		System.out.println("Numero da contas: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontraConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual o valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			//System.out.println("Valor depositado com sucesso! ");
		}else {
			System.out.println("A conta não foi encontrada! ");
		}
		operacoes();
	}
	public static void sacar () {
		System.out.println("Numero da conta");
	int numeroConta = input.nextInt();
		
		Conta conta = encontraConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual o valor deseja sacar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			//System.out.println("saque realizado com sucesso! ");
		}else {
			System.out.println("A conta não foi encontrada! ");
		}
		operacoes();
	}
	public static void transferir() {
		System.out.println("Número da conta do remetente");
	    int   numeroContaRemetente = input.nextInt();
	 	
		Conta contaRemetente = encontraConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Número da conta do destinatario: ");
		   int numeroContaDestinatario = input.nextInt();
		   Conta contaDestinatario = encontraConta(numeroContaDestinatario);
		   
		   if(contaDestinatario != null) {
			   System.out.println("Valor da transferência:");
			   Double valor = input.nextDouble();
			   
			   contaRemetente.tranferir(contaDestinatario, valor);
		   }else {
			   System.out.println("A conta para depósitar não foi encontrada");
		   }
		   
		}else {
			System.out.println("Conta para tranferência não encontrada");
		}
        operacoes();
	}

	public static void ListaContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não a contas cadastrada");
		}
		operacoes();
	}
	
}
