package hu.vr.representable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hu.vr.representable.renderer.RendererService;

public abstract class AbstractXmlLeaf implements XmlRepresentable {
	
	private final Map<String, String> attributes = new HashMap<>();
	private final Map<String, String> unmodAttributes = Collections.unmodifiableMap(attributes);

	@Override
	public final String getTagName() {
		if(getRawTagName()==null) {
			return null;
		}
		return getRawTagName().replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]", "");
	}

	@Override
	public final Map<String, String> getAttributes() {
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
		String key = rawKey==null ? null : rawKey.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]", "");
		String value = rawValue==null ? null : rawValue.replaceAll("\"", "'");
		attributes.put(key, value);
	}
	
	protected abstract String getRawTagName();
	protected abstract String getRawContent();
	protected abstract Set<String> getRawAttributeKeys();
	protected abstract String getRawAttribute(String key);

}
