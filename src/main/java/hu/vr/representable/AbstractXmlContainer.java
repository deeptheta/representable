package hu.vr.representable;

import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * @see XmlRepresentableContainer
 */
public abstract class AbstractXmlContainer implements XmlRepresentableContainer<Tag, Attribute, Tag, Attribute> {
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
}
