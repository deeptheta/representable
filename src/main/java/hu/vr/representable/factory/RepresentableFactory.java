package hu.vr.representable.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

public class RepresentableFactory {
	private final Map<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>> factoryMethods = 
			new HashMap<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>>();
	
	public XmlRepresentable<? extends Tag, ? extends Attribute> getRepresentationOf(Object anyObject){
		Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>> f = factoryMethods.get(anyObject.getClass());
		if(f!=null) {
			return f.apply(anyObject);
		}
		else {
			return null;
		}
	}

	public Map<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>> getFactoryMethods() {
		return factoryMethods;
	}
}
