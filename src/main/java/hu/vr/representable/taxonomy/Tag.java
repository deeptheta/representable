package hu.vr.representable.taxonomy;

/**
 * An arbitrary XML tag with valid syntax.
 */
public interface Tag {
	/**
	 * Simple domain element holder. Can only be created through factory methods that handle validation.
	 */
	public static final class DomainElement implements Tag{
		private final String tagName;
		private DomainElement(String tagName){
			this.tagName = tagName;
		}
		@Override
		public final String toString() {
			return tagName;
		}
	}
	
	/**
	 * Validating Tag factory.
	 */
	public static Tag tagName(String tagName) {
		if(tagName==null) {
			return null;
		}
		return new DomainElement(tagName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", ""));
	}
	
	/**
	 * Validating Tag factory for creation of (usually Tag subclass)
	 * domain instances belonging to a given Tag subdomain (or any domain that should be validated as a Tag).
	 * 
	 * @param tag name to search for
	 * @param subdomain of possible tags
	 * @return subclass of Tag (or any domain that should be validated as a Tag)
	 */
	public static <T> T tagName(String tagName, IsDomain<T> domain) {
		if(tagName==null) {
			return null;
		}
		tagName = tagName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", "").toLowerCase();
		T domainElement = null;
		try {
			domainElement = domain.getExactElement(tagName);
		}
		catch (IllegalArgumentException e) {
			System.out.println("[WARNING] Invalid tag: " + tagName + " in domain: " + domain.getClass().getName());
		}
		return domainElement;
	}
}
