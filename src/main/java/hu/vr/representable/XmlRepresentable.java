package hu.vr.representable;

import java.util.Map;

import hu.vr.representable.renderer.RendererService;

public interface XmlRepresentable {
	public String getTagName();
    public Map<String, String> getAttributes();
    public String getContent();
    public String acceptRenderer(RendererService renderer);
}
