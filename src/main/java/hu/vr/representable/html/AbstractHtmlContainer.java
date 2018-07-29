package hu.vr.representable.html;

import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.renderer.RendererService;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * Convenience class for extension.
 * @author Viktor Remeli
 *
 */
public abstract class AbstractHtmlContainer implements XmlRepresentableContainer<HtmlContainerTag, HtmlContainerAttribute, HtmlTag, HtmlAttribute> {
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
}
