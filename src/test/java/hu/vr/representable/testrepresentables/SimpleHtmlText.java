package hu.vr.representable.testrepresentables;

import java.util.Map;

import hu.vr.representable.html.AbstractHtmlLeaf;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class SimpleHtmlText extends AbstractHtmlLeaf {

	@Override
	public HtmlTag getTag() {
		return null;
	}

	@Override
	public Map<? extends HtmlAttribute, AttributeValue> getAttributes() {
		return null;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text("Random html text...");
	}

}
