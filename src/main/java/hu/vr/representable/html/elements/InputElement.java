package hu.vr.representable.html.elements;

import java.util.HashMap;
import java.util.Map;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.renderer.RendererService;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.InputAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * Convenience class for extension: represents an [input ... /] element of any type (text, password, button, etc).
 * @author Viktor Remeli
 *
 */
public abstract class InputElement implements XmlRepresentable<HtmlTag, InputAttribute> {
	
	protected Map<InputAttribute, AttributeValue> attributes = new HashMap<>();

	@Override
	public final HtmlTag getTag() {
		return HtmlTag.DomainElement.input;
	}

	@Override
	public final TextContent getContent() {
		return null;
	}
	
	@Override
	public final Map<? extends InputAttribute, AttributeValue> getAttributes() {
		return attributes;
	}
	
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}

}
