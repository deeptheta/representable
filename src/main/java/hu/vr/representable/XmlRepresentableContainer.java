package hu.vr.representable;

import java.util.List;

public interface XmlRepresentableContainer<T extends Tag, A extends Attribute> extends XmlRepresentable<T, A> {
	public List<XmlRepresentable<? extends T, ? extends A>> getChildren();
}
