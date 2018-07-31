package hu.vr.representable;

import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * @see XmlRepresentable
 */
public abstract class AbstractXmlElement implements XmlRepresentable<Tag, Attribute> {
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
}
