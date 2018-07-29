package hu.vr.representable.taxonomy;

public interface IsDomain<T> {
	public T getExactElement(String exactName);
	public T getElementBy(String rawName);
}
