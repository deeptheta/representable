package hu.vr.representable;

public interface AnyAttribute {
	public static final class Domain implements AnyAttribute{
		private final String attrName;
		private Domain(String attrName){
			this.attrName = attrName;
		}
		public static final Domain attrName(String attrName) {
			if(attrName==null) {
				return null;
			}
			return new Domain(attrName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", ""));
		}
		@Override
		public final String toString() {
			return attrName;
		}
	}
}
