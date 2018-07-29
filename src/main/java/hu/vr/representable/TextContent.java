package hu.vr.representable;

public interface TextContent {
	public static final class Domain implements TextContent{
		private final String text;
		private Domain(String text){
			this.text = text;
		}
		public static final Domain text(String text) {
			if(text==null) {
				return null;
			}
			return new Domain(text.replaceAll("<","&lt;").replaceAll(">","&gt;"));
		}
		@Override
		public final String toString() {
			return text;
		}
	}
}
