package hu.vr.representable.testrepresentations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import hu.vr.representable.AbstractXmlContainer;
import hu.vr.representable.XmlRepresentable;

public class CompositeXmlTag extends AbstractXmlContainer {
	
	private XmlRepresentable child01 = new SimpleXmlTag();
	private XmlRepresentable child02 = new SimpleTextLeaf();

	@Override
	public List<XmlRepresentable> getChildren() {
		List<XmlRepresentable> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		return result;
	}

	@Override
	protected String getRawTagName() {
		return "complex tag";
	}

	@Override
	protected String getRawContent() {
		return "This is some rather complex textual content...";
	}

	@Override
	protected Set<String> getRawAttributeKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getRawAttribute(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
