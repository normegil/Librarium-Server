package be.normegil.librarium.model.rest.services;

import be.normegil.librarium.Constants;
import be.normegil.librarium.model.data.Universe;
import be.normegil.librarium.rest.RESTService;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.UUID;

@Path(Constants.URL.PATH_SEPARATOR + "universes")
public class UniverseREST implements RESTService<Universe> {
	@Override
	public Response getAll(@Context final UriInfo info, final Long offset, final Integer limit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Response get(@Context final UriInfo info, final UUID id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Response create(@Context final UriInfo info, final Universe entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Response updateByPUT(final UUID id, final Universe entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Response updateByPOST(@Context final UriInfo info, final UUID id, final Universe entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Response delete(final UUID id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class<? extends Universe> getSupportedClass() {
		return Universe.class;
	}
}