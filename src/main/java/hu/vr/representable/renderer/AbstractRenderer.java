package hu.vr.representable.renderer;

import hu.vr.representable.RendererService;
import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.context.RepresentableContext;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * Represents a renderer that performs a context check on received arbitrary Model Objects
 * and converts them to registered {@link XmlRepresentable}-s before rendering (if possible).
 * 
 * @see RendererService
 */
public abstract class AbstractRenderer implements RendererService {
	
	private RepresentableContext context = null;
	
	public AbstractRenderer() {	}
	
	/**
	 * @param context mapping Model classes to to Representation factories	
	 */
	public AbstractRenderer(RepresentableContext context) {
		this.context = context;
	}

	@Override
	public String render(Object anyObject) {
		if(anyObject == null) {
			return "";	// nothing default
		}
		
		XmlRepresentable<? extends Tag, ? extends Attribute> representation = null;
		if(this.context!=null) {
			representation = context.getRepresentationOf(anyObject);
			if(representation!=null) {
				return representation.acceptRenderer(this);
			}
		}
		
		return "";		// base default
	}
	
}
