package hu.vr.representable.taxonomy;

/**
 * Is a searchable domain of instances of class T.
 *
 * @param <T>
 */
public interface IsDomain<T> {
	/**
	 * Return domain element by exact matching.
	 * @param exactName
	 * @return domain element
	 */
	public T getExactElement(String exactName);
	
	/**
	 * Return domain element by first validating and transforming the raw name,
	 * and then seeking an exact match.
	 * 
	 * @param rawName
	 * @return domain element
	 */
	public T getElementBy(String rawName);
}
