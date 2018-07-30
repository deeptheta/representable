package hu.vr.representable.renderer;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.factory.RepresentableFactory;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

public abstract class AbstractRenderer implements RendererService {
	
	private RepresentableFactory factory = null;
	
	public AbstractRenderer() {	}
	public AbstractRenderer(RepresentableFactory factory) {
		this.factory = factory;
	}

	@Override
	public String render(Object anyObject) {
		if(anyObject == null) {
			return "";	// nothing default
		}
		
		XmlRepresentable<? extends Tag, ? extends Attribute> representation = null;
		if(this.factory!=null) {
			representation = factory.getRepresentationOf(anyObject);
			if(representation!=null) {
				return representation.acceptRenderer(this);
			}
		}
		
		return "";		// base default
	}
	
}
