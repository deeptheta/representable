package hu.vr.representable.taxonomy;

public interface Attribute {
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
	
	public static Attribute attrName(String attrName) {
		if(attrName==null) {
			return null;
		}
		return new DomainElement(attrName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", ""));
	}
	
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
