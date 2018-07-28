package hu.vr.representable;

import java.util.Map;

import hu.vr.representable.renderer.RendererService;

public interface XmlRepresentable {
	public AnyTag getTag();
    public Map<String, String> getAttributes();
    public String getContent();
    public String acceptRenderer(RendererService renderer);
}
