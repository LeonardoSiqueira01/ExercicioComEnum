package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidades.ContratoHora;
import Entidades.Departamento;
import Entidades.Trabalho;
import EntidadesEnum.NivelExperiencia;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os Dados do Trabalho");
		System.out.print("Nome: ");
		String NomeTrabalhador = sc.nextLine();
		System.out.print("Nivel Experiencia:");
		String nivel = sc.nextLine();
		System.out.print("Salário Base:");
		double salarioBase = sc.nextDouble();

		Trabalho trabalhador = new Trabalho(NomeTrabalhador, NivelExperiencia.valueOf(nivel), salarioBase,
				new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos este trabalhador tem? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("ENTRE COM OS DADOS DO #" + i + " CONTRATO");
			System.out.print("Data (DD/MM/YYYY): ");
			Date DataContrato = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(DataContrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		System.out.println();
		System.out.print("Entre com o Mês e Ano para calcular o salário (MM/YYYY): ");
		String MesAno = sc.next();
		int mes = Integer.parseInt(MesAno.substring(0, 2));
		int ano = Integer.parseInt(MesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Salario de " + MesAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));

		sc.close();
	}

}
