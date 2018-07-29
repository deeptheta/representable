package hu.vr.representable;

import java.util.Map;

import hu.vr.representable.renderer.RendererService;

public interface XmlRepresentable<T extends Tag, A extends Attribute> {
	public T getTag();
    public Map<? extends A, AttributeValue> getAttributes();
    public TextContent getContent();
    public String acceptRenderer(RendererService renderer);
}
