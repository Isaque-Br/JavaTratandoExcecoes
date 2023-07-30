package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados da conta");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine(); // Consumindo a linha depois do enter pós numero digitado
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit); // OBJETO INSTANCIADO DO TIPO CONTA

		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();

	
		try {
			acc.withdraw(amount); // CHAMANDO A CNTA PRA SAQUE
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());

		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}