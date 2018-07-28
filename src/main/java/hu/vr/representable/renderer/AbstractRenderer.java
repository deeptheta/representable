package hu.vr.representable.renderer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import hu.vr.representable.XmlRepresentable;

public abstract class AbstractRenderer implements RendererService {
	
	private final Map<Class<?>, Function<Object, XmlRepresentable>> wrapperFactoryMethods = 
		new HashMap<Class<?>, Function<Object, XmlRepresentable>>();

	@Override
	public String render(Object anyObject) {
		if(anyObject == null) {
			return "";	// nothing default
		}
		
		Function<Object, XmlRepresentable> f = wrapperFactoryMethods.get(anyObject.getClass());
		if(f!=null) {
			return f.apply(anyObject).acceptRenderer(this);
		}
		
		return "";		// base default
	}


}
