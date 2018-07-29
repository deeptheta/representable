package hu.vr.representable.renderer;

import hu.vr.representable.Attribute;
import hu.vr.representable.Tag;
import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;

public interface RendererService {
	public String render(Object anyObject);
	public String render(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr);
	public String render(XmlRepresentableContainer<? extends Tag, ? extends Attribute> xmlReprCont);	
}
