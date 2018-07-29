package hu.vr.representable;

public interface Tag {
	public static final class Domain implements Tag{
		private final String tagName;
		private Domain(String tagName){
			this.tagName = tagName;
		}
		public static final Domain tagName(String tagName) {
			if(tagName==null) {
				return null;
			}
			return new Domain(tagName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", ""));
		}
		@Override
		public final String toString() {
			return tagName;
		}
	}
}
