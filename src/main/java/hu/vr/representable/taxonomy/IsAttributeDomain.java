package hu.vr.representable.taxonomy;

/**
 * Is a searchable domain of syntactically correct XML Attributes that are instances of class T.
 *
 * @param <T>
 */
public interface IsAttributeDomain<T> extends IsDomain<T>{
	public T getExactElement(String exactName);
	public default T getElementBy(String rawName) {
		return Attribute.attrName(rawName, this);
	}
}
