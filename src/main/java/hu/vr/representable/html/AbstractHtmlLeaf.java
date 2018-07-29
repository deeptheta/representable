package hu.vr.representable.html;

import hu.vr.representable.AbstractXmlLeaf;
import hu.vr.representable.renderer.RendererService;

public abstract class AbstractHtmlLeaf extends AbstractXmlLeaf {
	
//	private final Map<HtmlAttribute, String> attributes = new HashMap<>();
//	private final Map<HtmlAttribute, String> unmodAttributes = Collections.unmodifiableMap(attributes);
	
	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}

//	@Override
//	protected Tag inferTagFrom(String rawTag) {
//		return HtmlTag.Domain.tagName(rawTag);
//	}
//	
//	@Override
//	protected Attribute inferAttributeFrom(String rawKey) {
//		return HtmlAttribute.Domain.attrName(rawKey);
//	}
//
//	protected abstract String getRawTagName();
//	protected abstract String getRawContent();
//	protected abstract Set<String> getAttributeKeys();
//	protected abstract String getRawAttribute(String key);

}
