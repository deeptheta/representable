package hu.vr.representable.example.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.elements.RecordElement;
import hu.vr.representable.html.elements.Label;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * A record representation type with two fields (columns): key and value.
 */
public class KeyValuePair extends RecordElement {
	
	private final List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
	
	public KeyValuePair(String key, String value) {
		super();
		this.children.add(new Label(key));
		this.children.add(new Label(value));
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		return children;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return null;
	}

}
