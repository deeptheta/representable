package hu.vr.representable.testrepresentables;

import java.util.HashMap;
import java.util.Map;

import hu.vr.representable.html.elements.Input;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.InputAttribute;

public class InputField extends Input {

	@Override
	public Map<? extends InputAttribute, AttributeValue> getAttributes() {
		Map<InputAttribute, AttributeValue> attributes = new HashMap<>();
		attributes.put(InputAttribute.DomainElement.type, AttributeValue.attrValue("text"));
		return attributes;
	}

}
