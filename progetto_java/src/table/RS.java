package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class RS {

	private String codiceRS;
	private DBConnection con = new DBConnectionImpl();

	public RS(String codiceRS) {
		this.codiceRS = codiceRS;

	}

	public int inserisciRS() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement("insert into RS(codiceRS) VALUES(?)");
			st.setString(1, this.codiceRS);
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}

	public String getCodiceRS() {
		return codiceRS;
	}

	public void setCodiceRS(String codiceRS) {
		this.codiceRS = codiceRS;
	}

}
