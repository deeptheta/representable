package hu.vr.representable.context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * An application context that contains a mapping from Model to Representation classes
 * and the necessary factories for representation creation (i.e. a factory registry).
 * It requires no prior dependencies from Model to Representation.
 * It provides appropriate representations even if the source of the Model and the instantiation of Model objects
 * are inaccessible/not controlled by the developer/caller.
 */
public class RepresentableContext {
	private final Map<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>> factoryMethods = 
			new HashMap<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>>();
	
	/**
	 * @param anyObject
	 * @return appropriate Representation of Model object
	 */
	public XmlRepresentable<? extends Tag, ? extends Attribute> getRepresentationOf(Object anyObject){
		Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>> f = factoryMethods.get(anyObject.getClass());
		if(f!=null) {
			return f.apply(anyObject);
		}
		else {
			return null;
		}
	}

	/**
	 * Used for initializing/updating the context
	 * by registering appropriate Representation factories (getFactoryMethods().put(...)) for the Model classes.
	 * 
	 * @return context mapping from Model class to appropriate Representation factory
	 */
	public Map<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>> getFactoryMethods() {
		return factoryMethods;
	}
}
