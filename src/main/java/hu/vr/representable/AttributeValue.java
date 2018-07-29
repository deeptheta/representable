package hu.vr.representable;

public interface AttributeValue {
	public static final class Domain implements AttributeValue{
		private final String attrValue;
		private Domain(String attrValue){
			this.attrValue = attrValue;
		}
		public static final Domain attrValue(String attrValue) {
			if(attrValue==null) {
				return null;
			}
			return new Domain(attrValue.replaceAll("\"", "'"));
		}
		@Override
		public final String toString() {
			return attrValue;
		}
	}
}
