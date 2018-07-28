package hu.vr.representable;

import hu.vr.representable.renderer.RendererService;

public abstract class AbstractXmlContainer extends AbstractXmlLeaf implements XmlRepresentableContainer {
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
}
