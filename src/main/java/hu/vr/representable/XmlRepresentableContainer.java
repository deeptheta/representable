package hu.vr.representable;

import java.util.List;

public interface XmlRepresentableContainer extends XmlRepresentable {
	public List<XmlRepresentable> getChildren();
}
