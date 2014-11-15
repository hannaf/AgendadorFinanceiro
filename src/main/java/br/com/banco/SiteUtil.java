package br.com.banco;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * 
 * @author Hanna
 *
 */
public class SiteUtil {
	
	/**
	 * Calcula quantidade de dias da data atual até a data agendada.
	 * 
	 * @param dtAgendamento
	 * @return int
	 */
	public static int calculaDias(Date dtAgendamento) {
		DateTime dataAtual = new DateTime();
		DateTime dataAgendada = new DateTime(dtAgendamento);
		return Days.daysBetween(dataAtual.withTimeAtStartOfDay(), dataAgendada.withTimeAtStartOfDay()).getDays();
	}
	
	/**
	 * Converte String para BigDecimal
	 * @param valor
	 * @return
	 */
	public static BigDecimal converteStringParaBigDecimal(String valor) {
		try {
			return new BigDecimal(valor);
		} catch (NumberFormatException e) {
			return null;	
		}
	}

	/**
	 * Converte String para Date
	 * @param data
	 * @return
	 */
	public static Date converteStringParaDate(String data) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			return df.parse(data);
		} catch (ParseException e) {
			return null;

		}
	}

}
