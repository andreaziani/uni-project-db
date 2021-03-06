package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoParrocchiaRS {
	
	private String codiceParrocchia;
	private String codiceEvento;
	private String tipo;
	private Date dataInizio;
	private Date dataFine;
	private String località;
	private String descrizione;
	private DBConnection con = new DBConnectionImpl();
	
	public EventoParrocchiaRS(String codiceParrocchia, String codiceEvento, String tipo, Date dataInizio,
			Date dataFine, String località, String descrizione) {
		super();
		this.codiceParrocchia = codiceParrocchia;
		this.codiceEvento = codiceEvento;
		this.tipo = tipo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.località = località;
		this.descrizione = descrizione;
	}

	public int inserimentoEvento() {
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into E_P_RS(codiceParrocchia, codiceEvento, tipo, dataInizio, dataFine, località, descrizione) VALUES(?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, codiceParrocchia);
			st.setString(2, codiceEvento);
			st.setString(3, tipo);
			st.setDate(4, dataInizio);
			st.setDate(5, dataFine);
			st.setString(6, località);
			st.setString(7, descrizione);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return rs;
	}

}
