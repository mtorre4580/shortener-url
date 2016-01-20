package com.ba.qr.hub;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ba.qr.bd.IServiceQRQuery;

@RestController
public class URLRest {
	
	@Autowired
	private IServiceQRQuery serviceQRQuery;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void redirigirContenido(@PathVariable("id") String id,HttpServletResponse resp) throws Exception {
		String url = null;
		try{
			 url = serviceQRQuery.getUrlQr(id);
		}catch(SQLException e){
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Error al buscar la url del qr");
		}
		if (url!=null) {
			resp.sendRedirect(url);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"La url del qr solicitado no existe");
		}
	}
}


