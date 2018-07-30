package org.user.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.user.model.Asset;
import org.user.model.Collateral;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class CollateralAssetSheet extends AbstractHtmlContainer {
	
	private final Collateral collateral;
	Map<HtmlContainerAttribute, AttributeValue> attributes = new HashMap<>();
	
	public CollateralAssetSheet(Collateral collateral) {
		super();
		this.collateral = collateral;
		setStyle("border: solid black 1px;");
	}
	
	public void setStyle(String styleCss) {
		attributes.put(HtmlContainerAttribute.DomainElement.style, AttributeValue.attrValue(styleCss));
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
		children.add(new KeyValuePair("Collateral ID", collateral.getUniqueId()));
		children.add(new KeyValuePair("Allocated value", collateral.getAllocatedVal()));
		Asset backingAsset = collateral.getAsset();
		if(backingAsset!=null) {
			children.add(new KeyValuePair("Backing asset", backingAsset.getDescription()));
			children.add(new KeyValuePair("Asset valuation rate", backingAsset.getValuationRate()));
			children.add(new KeyValuePair("Base value of asset", backingAsset.getBaseValue()));
			children.add(new KeyValuePair("Acceptable value", backingAsset.getAcceptableValue()));
		}
		else {
			children.add(new KeyValuePair("Backing asset", "none"));
		}
		return children;
	}

	@Override
	public HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.table;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return attributes;
	}

	@Override
	public TextContent getContent() {
		return null;
	}

}
