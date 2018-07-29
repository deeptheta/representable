package hu.vr.representable.renderer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

public abstract class AbstractRenderer implements RendererService {
	
	private final Map<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>> wrapperFactoryMethods = 
		new HashMap<Class<?>, Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>>>();

	@Override
	public String render(Object anyObject) {
		if(anyObject == null) {
			return "";	// nothing default
		}
		
		Function<Object, XmlRepresentable<? extends Tag, ? extends Attribute>> f = wrapperFactoryMethods.get(anyObject.getClass());
		if(f!=null) {
			return f.apply(anyObject).acceptRenderer(this);
		}
		
		return "";		// base default
	}


}
