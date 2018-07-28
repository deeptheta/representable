package hu.vr.representable.renderer;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;

public interface RendererService {
	public String render(Object anyObject);
	public String render(XmlRepresentable xmlRepr);
	public String render(XmlRepresentableContainer xmlReprCont);	
}
