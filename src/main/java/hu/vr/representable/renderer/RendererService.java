package hu.vr.representable.renderer;

import hu.vr.representable.HtmlRepresentable;
import hu.vr.representable.XmlRepresentable;

public interface RendererService {
	public String render(Object anyObject);
	public String render(XmlRepresentable xmlRepr);
	public String render(HtmlRepresentable htmlRepr);
}
