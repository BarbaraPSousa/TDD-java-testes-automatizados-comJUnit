package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
			BigDecimal percentualreajuste = desempenho.percenteualReajuster();
			BigDecimal reajuste = funcionario.getSalario().multiply(percentualreajuste);
			funcionario.reajustarSalario(reajuste);
	}
}
