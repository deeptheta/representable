package hu.vr.representable.html.elements;

import java.util.Map;

import hu.vr.representable.html.AbstractHtmlLeaf;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * Convenience class for extension: represents simple textual content found between tags.
 * @author Viktor Remeli
 *
 */
public abstract class TextElement extends AbstractHtmlLeaf {

	@Override
	public final HtmlTag getTag() {
		return null;
	}

	@Override
	public final Map<? extends HtmlAttribute, AttributeValue> getAttributes() {
		return null;
	}

}
