package com.ba.qr.bd;

import java.sql.SQLException;

public interface IServiceQRQuery {

	/**
	 * Permite obtener la url del qr, por el id generado por la aplicacion web.
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String getUrlQr(String id) throws SQLException;
}
