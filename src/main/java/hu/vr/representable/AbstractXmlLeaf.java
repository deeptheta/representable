package hu.vr.representable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hu.vr.representable.renderer.RendererService;

public abstract class AbstractXmlLeaf implements XmlRepresentable {
	
	private final Map<AnyAttribute, String> attributes = new HashMap<>();
	private final Map<AnyAttribute, String> unmodAttributes = Collections.unmodifiableMap(attributes);

	@Override
	public final AnyTag getTag() {
		return AnyTag.Domain.tagName(getRawTagName());
	}

	@Override
	public final Map<AnyAttribute, String> getAttributes() {
		attributes.clear();
		if(getRawAttributeKeys()==null) {
			return unmodAttributes;
		}
		for(String rawKey : getRawAttributeKeys()) {
			setAttributeFormatted(rawKey, getRawAttribute(rawKey));
		}
		return unmodAttributes;
	}

	@Override
	public final String getContent() {
		if(getRawContent()==null) {
			return null;
		}
		return getRawContent().replaceAll("<","&lt;").replaceAll(">","&gt;");
	}

	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}
	
	private final void setAttributeFormatted(String rawKey, String rawValue) {
		AnyAttribute keyAttribute = AnyAttribute.Domain.attrName(rawKey);
		String formattedValue = rawValue==null ? null : rawValue.replaceAll("\"", "'");
		attributes.put(keyAttribute, formattedValue);
	}
	
	protected abstract String getRawTagName();
	protected abstract String getRawContent();
	protected abstract Set<String> getRawAttributeKeys();
	protected abstract String getRawAttribute(String key);

}
