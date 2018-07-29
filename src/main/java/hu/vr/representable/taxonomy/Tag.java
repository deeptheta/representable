package hu.vr.representable.taxonomy;

public interface Tag {
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
	
	public static Tag tagName(String tagName) {
		if(tagName==null) {
			return null;
		}
		return new DomainElement(tagName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", ""));
	}
	
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
