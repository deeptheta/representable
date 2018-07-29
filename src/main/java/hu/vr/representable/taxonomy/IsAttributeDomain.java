package hu.vr.representable.taxonomy;

public interface IsAttributeDomain<T> extends IsDomain<T>{
	public T getExactElement(String exactName);
	public default T getElementBy(String rawName) {
		return Attribute.attrName(rawName, this);
	}
}
