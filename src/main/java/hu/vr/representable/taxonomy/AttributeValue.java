package hu.vr.representable.taxonomy;

public interface AttributeValue {
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
	
	public static AttributeValue attrValue(String attrValue) {
		if(attrValue==null) {
			return null;
		}
		return new DomainElement(attrValue.replaceAll("\"", "'"));
	}
}
