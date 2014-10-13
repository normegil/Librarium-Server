package be.normegil.librarium.model.data;

import be.normegil.librarium.WarningTypes;
import be.normegil.librarium.libraries.ClassWrapper;
import be.normegil.librarium.model.data.game.Game;
import be.normegil.librarium.tool.DataFactory;
import be.normegil.librarium.tool.FactoryRepository;
import be.normegil.librarium.tool.validation.Validator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;
import java.net.URI;

public class UTBaseMediaDigestSafety {

	@SuppressWarnings(WarningTypes.UNCHECKED_CAST)
	private static final DataFactory<Game> GAME_FACTORY = FactoryRepository.get(Game.class);
	private static final String URI_ADDRESS = "http://localhost:8080/";
	private static final ClassWrapper<BaseMedia.BaseMediaDigest> CLASS = new ClassWrapper<>(BaseMedia.BaseMediaDigest.class);
	private static final Method FROM_BASE_METHOD = CLASS.getMethod("fromBase", URI.class, BaseMedia.class);
	private static final Method TO_BASE_METHOD = CLASS.getMethod("toBase", BaseMedia.Init.class);
	private BaseMedia.BaseMediaDigest entity;

	@Before
	public void setUp() throws Exception {
		entity = new BaseMedia.BaseMediaDigest();
	}

	@After
	public void tearDown() throws Exception {
		entity = null;
	}

	@Test(expected = ConstraintViolationException.class)
	public void testFromBase_NullURI() throws Exception {
		Validator.validate(entity, FROM_BASE_METHOD, null, GAME_FACTORY.getNew());
	}

	@Test(expected = ConstraintViolationException.class)
	public void testFromBase_NullEntity() throws Exception {
		Validator.validate(entity, FROM_BASE_METHOD, URI.create(URI_ADDRESS), null);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testFromBase_NullEntityID() throws Exception {
		Validator.validate(entity, FROM_BASE_METHOD, URI.create(URI_ADDRESS), GAME_FACTORY.getNew());
	}

	@Test(expected = ConstraintViolationException.class)
	public void testToBase_Null() throws Exception {
		Validator.validate(entity, TO_BASE_METHOD, new Object[]{null});
	}
}
