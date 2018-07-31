package hu.vr.representable;

import java.util.Map;

import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.Tag;
import hu.vr.representable.taxonomy.TextContent;

/**
 * An XML element representation that has tag name from set T and attribute names from set A.
 *
 * @param <T> The set (class) of applicable tag names.
 * @param <A> The set (class) of applicable attribute names.
 */
public interface XmlRepresentable<T extends Tag, A extends Attribute> {
	public T getTag();
    public Map<? extends A, AttributeValue> getAttributes();
    public TextContent getContent();
    
    /**
     * Accept a renderer in order to render this element using "overloading visitor" pattern.
     * It is advised to override this method in all (differently rendered) subclasses with a default implementation:
     * <pre>return renderer.render(this);</pre>
     * Reason: the "overloading visitor" pattern needs access to actual type of <b>this</b> (and not superclass).
     * 
     * @param renderer
     * @return rendered element
     */
    public String acceptRenderer(RendererService renderer);
}
