package hu.vr.representable.taxonomy;

public interface TextContent {
	public static final class DomainElement implements TextContent{
		private final String text;
		private DomainElement(String text){
			this.text = text;
		}
		@Override
		public final String toString() {
			return text;
		}
	}
	
	public static TextContent text(String text) {
		if(text==null) {
			return null;
		}
		return new DomainElement(text.replaceAll("<","&lt;").replaceAll(">","&gt;"));
	}
}
