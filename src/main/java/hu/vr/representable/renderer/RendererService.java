package hu.vr.representable.renderer;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * A renderer interface for rendering {@link XmlRepresentable}-s as an xml markup string.
 * <br>It supports rendering of
 * <ul>
 *   <li>arbitrary Objects</li>
 *   <li>leaf elements ({@link XmlRepresentable}-s)</li>
 *   <li>container elements ({@link XmlRepresentableContainer}-s)</li>
 * </ul>
 * It can also function as a visitor in the "overload visitor" pattern, thus
 * both Model and Representation can remain fully rendering-strategy-agnostic.
 */
public interface RendererService {
	/**
	 * Renders arbitrary Object as String.
	 * @param anyObject
	 * @return rendered form
	 */
	public String render(Object anyObject);
	
	/**
	 * Renders XML element representation as String.
	 * @param XML element representation
	 * @return rendered form
	 */
	public String render(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr);
	
	/**
	 * Renders XML container element representation as String.
	 * @param XML container element representation
	 * @return rendered form
	 */
	public String render(XmlRepresentableContainer<? extends Tag, ? extends Attribute, ? extends Tag, ? extends Attribute> xmlReprCont);	
}
