package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {// teste salario com valor acima de 1000
		BonusService service = new BonusService();
//		assertThrows(IllegalArgumentException.class,
//				() -> service.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("25000"))));
		try { 
			service.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a Exception!");
		} catch (Exception e) {
			assertEquals("Funcionario com salario acima de 10000", e.getMessage());
		}
	}

	@Test
	void bonusDeveriaSerDezPorcentoDoSalario() {// teste salario com valor abaixo de 1000
		BonusService serce = new BonusService();
		BigDecimal bonus = serce.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioExatamenteDezMil() {// teste salario com valor = 1000
		BonusService serce = new BonusService();
		BigDecimal bonus = serce.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("1000.00")));

		assertEquals(new BigDecimal("100.00"), bonus);
	}
}
