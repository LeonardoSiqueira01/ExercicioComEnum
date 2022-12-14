package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import EntidadesEnum.NivelExperiencia;

public class Trabalho {
	private String nome;
	private NivelExperiencia nivel;
	private double SalarioBase;

	private Departamento departamento;

	List<ContratoHora> contratos = new ArrayList<>();

	Trabalho() {
	}

	public Trabalho(String nome, NivelExperiencia nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		SalarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelExperiencia getNivel() {
		return nivel;
	}

	public void setNivel(NivelExperiencia nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		SalarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public double renda(int ano, int mes) {
		double soma = SalarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoHora c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.ValorTotal();
			}
		}
		return soma;
	}
}