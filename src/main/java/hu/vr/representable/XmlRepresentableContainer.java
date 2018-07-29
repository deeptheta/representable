package hu.vr.representable;

import java.util.List;

import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

public interface XmlRepresentableContainer<T extends Tag, A extends Attribute, TChild extends Tag, AChild extends Attribute> extends XmlRepresentable<T, A> {
	public List<XmlRepresentable<? extends TChild, ? extends AChild>> getChildren();
}
