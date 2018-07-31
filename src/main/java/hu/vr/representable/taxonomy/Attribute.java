package hu.vr.representable.taxonomy;

/**
 * An arbitrary XML attribute with valid syntax.
 */
public interface Attribute {
	/**
	 * Simple domain element holder. Can only be created through factory methods that handle validation.
	 */
	public static final class DomainElement implements Attribute{
		private final String attrName;
		private DomainElement(String attrName){
			this.attrName = attrName;
		}
		@Override
		public final String toString() {
			return attrName;
		}
	}
	
	/**
	 * Validating Attribute factory.
	 */
	public static Attribute attrName(String attrName) {
		if(attrName==null) {
			return null;
		}
		return new DomainElement(attrName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", ""));
	}
	
	/**
	 * Validating Attribute factory for creation of (usually Attribute subclass)
	 * domain instances belonging to a given Attribute subdomain (or any domain that should be validated as an Attribute).
	 * 
	 * @param attribute name to search for
	 * @param subdomain of possible attributes
	 * @return subclass of Attribute (or any domain that should be validated as an Attribute)
	 */
	public static <T> T attrName(String attrName, IsDomain<T> domain) {
		if(attrName==null) {
			return null;
		}
		attrName = attrName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", "").toLowerCase();
		T domainElement = null;
		try{				
			domainElement = domain.getExactElement(attrName);
		}
		catch (IllegalArgumentException e) {
			System.out.println("[WARNING] Invalid attribute: " + attrName + " in domain: " + domain.getClass().getName());
		}
		return domainElement;
	}
		
}
