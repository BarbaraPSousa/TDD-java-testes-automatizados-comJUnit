package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTeste {

	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach // antes de cada um dos metodos
	public void inicializar() {
		System.out.println("Inicializar");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach // fim de cada teste
	public void finalizar() {
		System.out.println("Fim");
	}
	
	@BeforeAll // roda uma unica vez Antes de todos so test
	public static void antesDeTodos() {
		System.out.println("Antes de Todos");
	}
	
	@AfterAll // roda uma unica vez depois de todos os test
	public static void depoisDeTodos() {
		System.out.println("Depois de Todos");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcento() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorCento() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorCento() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}