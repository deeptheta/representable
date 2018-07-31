package hu.vr.representable.taxonomy;

/**
 * An arbitrary XML attribute value with valid syntax.
 */
public interface AttributeValue {
	/**
	 * Simple domain element holder. Can only be created through factory methods that handle validation.
	 */
	public static final class DomainElement implements AttributeValue{
		private final String attrValue;
		private DomainElement(String attrValue){
			this.attrValue = attrValue;
		}
		@Override
		public final String toString() {
			return attrValue;
		}
	}
	
	/**
	 * Validating AttributeValue factory.
	 */
	public static AttributeValue attrValue(String attrValue) {
		if(attrValue==null) {
			return null;
		}
		return new DomainElement(attrValue.replaceAll("\"", "'"));
	}
}
