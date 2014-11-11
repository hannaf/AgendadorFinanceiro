package br.com.banco;

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

}
