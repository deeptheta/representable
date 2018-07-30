package hu.vr.representable.html.elements;

import java.util.Map;

import hu.vr.representable.html.AbstractHtmlLeaf;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class LineBreak extends AbstractHtmlLeaf {

	@Override
	public final HtmlTag getTag() {
		return HtmlTag.DomainElement.br;
	}

	@Override
	public final Map<? extends HtmlAttribute, AttributeValue> getAttributes() {
		return null;
	}

	@Override
	public final TextContent getContent() {
		return null;
	}

}
