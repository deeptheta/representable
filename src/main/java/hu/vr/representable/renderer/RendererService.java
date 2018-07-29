package hu.vr.representable.renderer;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

public interface RendererService {
	public String render(Object anyObject);
	public String render(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr);
	public String render(XmlRepresentableContainer<? extends Tag, ? extends Attribute, ? extends Tag, ? extends Attribute> xmlReprCont);	
}
