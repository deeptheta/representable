package hu.vr.representable.taxonomy;

/**
 * Is a searchable domain of syntactically correct XML Tags that are instances of class T.
 *
 * @param <T>
 */
public interface IsTagDomain<T> extends IsDomain<T>{
	public T getExactElement(String exactName);
	public default T getElementBy(String rawName) {
		return Tag.tagName(rawName, this);
	}
}
