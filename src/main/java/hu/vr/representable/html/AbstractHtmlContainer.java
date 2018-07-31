package hu.vr.representable.html;

import hu.vr.representable.RendererService;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * An HTML container (allowing all <i>container specific</i> html tags and attributes)
 * that may contain zero or more children that are html elements (allowing <i>all</i> html tags and attributes).
 * Depending on (container/contained) subclass, further taxonomical restrictions may apply.
 *  
 * @see XmlRepresentableContainer
 */
public abstract class AbstractHtmlContainer implements XmlRepresentableContainer<HtmlContainerTag, HtmlContainerAttribute, HtmlTag, HtmlAttribute> {
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
}
