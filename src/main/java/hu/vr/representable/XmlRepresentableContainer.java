package hu.vr.representable;

import java.util.List;

import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * A container XML element representation that has tag name from set T and attribute names from set A.
 *
 * @param <T> The set (class) of applicable tag names.
 * @param <A> The set (class) of applicable attribute names.
 * @param <TChild> The set (class) of applicable tag names for contained children.
 * @param <AChild> The set (class) of applicable attribute names for contained children.
 */
public interface XmlRepresentableContainer<T extends Tag, A extends Attribute, TChild extends Tag, AChild extends Attribute> extends XmlRepresentable<T, A> {
	
	/**
	 * @return all contained (i.e. child) xml elements.
	 */
	public List<XmlRepresentable<? extends TChild, ? extends AChild>> getChildren();

}
