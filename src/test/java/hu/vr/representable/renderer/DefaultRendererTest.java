package hu.vr.representable.renderer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.testrepresentations.CompositeXmlDeep;
import hu.vr.representable.testrepresentations.CompositeXmlTag;
import hu.vr.representable.testrepresentations.SimpleTextLeaf;
import hu.vr.representable.testrepresentations.SimpleXmlTag;
import hu.vr.representable.testrepresentations.SimpleXmlTagWithContent;

public class DefaultRendererTest {
	
	DefaultRenderer defRenderer = new DefaultRenderer();

	@Test
    public void renderSimpleObject() {
        Object o = new Object();
        String result = defRenderer.render(o);
        System.out.println("simple object :    " + result);
        
        assertTrue( result.startsWith("java.lang.Object@") );
    }
    
	@Test
    public void renderSimpleXml() {
        XmlRepresentable xmlRepr = new SimpleXmlTag();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml    :    " + result);

        assertTrue( result.startsWith("<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>") );
    }
    
	@Test
    public void renderSimpleXmlWithContent() {
        XmlRepresentable xmlRepr = new SimpleXmlTagWithContent();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml+txt:    " + result);

        assertTrue( result.startsWith("<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith(">Lorem 5 &lt; 6 ipsum...</simpletag>") );
    }
    
	@Test
    public void renderSimpleTextLeaf() {
        XmlRepresentable xmlRepr = new SimpleTextLeaf();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple txtLeaf:    " + result);

        assertTrue( "just some text...".equals(result) );
    }
    
	@Test
    public void renderCompositeTag() {
        XmlRepresentableContainer xmlReprCont = new CompositeXmlTag();
        String result = defRenderer.render(xmlReprCont);
        System.out.println("composite tag :    " + result);

        assertTrue( result.startsWith("<complextag>This is some rather complex textual content...<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>just some text...</complextag>") );
    }
    
	@Test
    public void renderCompositeDeep() {
        XmlRepresentableContainer xmlReprCont = new CompositeXmlDeep();
        String result = defRenderer.render(xmlReprCont);
        System.out.println("deep composite:    " + result);

        assertTrue( result.startsWith("<deeptag height=\"3\"><simpletag ") );
        assertTrue( result.substring(30, 83).contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.substring(30, 83).contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.substring(83, 205).equals(">Lorem 5 &lt; 6 ipsum...</simpletag>just some text..."
        		+ "<complextag>This is some rather complex textual content...<simpletag ") );
        assertTrue( result.substring(204, 257).contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.substring(204, 257).contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>just some text...</complextag>just some text...</deeptag>") );
    }
    
}
