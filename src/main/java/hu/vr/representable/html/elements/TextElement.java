package hu.vr.representable.html.elements;

import java.util.Map;

import hu.vr.representable.html.AbstractHtmlElement;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * Represents simple textual content found between tags.
 */
public abstract class TextElement extends AbstractHtmlElement {

	@Override
	public final HtmlTag getTag() {
		return null;
	}

	@Override
	public final Map<? extends HtmlAttribute, AttributeValue> getAttributes() {
		return null;
	}

}
