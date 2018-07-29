package hu.vr.representable.taxonomy;

public interface IsTagDomain<T> extends IsDomain<T>{
	public T getExactElement(String exactName);
	public default T getElementBy(String rawName) {
		return Tag.tagName(rawName, this);
	}
}
