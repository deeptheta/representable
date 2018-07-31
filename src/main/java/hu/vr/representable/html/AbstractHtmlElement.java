package hu.vr.representable.html;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.renderer.RendererService;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * An HTML element allowing all html tags and attributes.
 * Depending on the subclass, further taxonomical restrictions may apply.
 * 
 * @see XmlRepresentable
 */
public abstract class AbstractHtmlElement implements XmlRepresentable<HtmlTag, HtmlAttribute> {
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
}
