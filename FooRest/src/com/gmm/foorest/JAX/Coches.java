package com.gmm.foorest.JAX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gmm.foorest.data.Coche;

@Path("coches")
public class Coches {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Coche getIt() {
		Coche c = new Coche();
		c.setMarca("Ferrari");
		c.setModelo("F45");
		c.setPotencia(430);
		return c;
	}

}
