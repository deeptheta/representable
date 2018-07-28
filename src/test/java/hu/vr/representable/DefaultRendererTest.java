package hu.vr.representable;

import hu.vr.representable.renderer.DefaultRenderer;
import hu.vr.representable.testrepresentations.SimpleTextLeaf;
import hu.vr.representable.testrepresentations.SimpleXmlTag;
import hu.vr.representable.testrepresentations.SimpleXmlTagWithContent;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DefaultRendererTest extends TestCase {
    
    public DefaultRendererTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(DefaultRendererTest.class);
    }

    public void testRenderSimpleObject() {
        Object o = new Object();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(o);
        System.out.println("simple object :    " + result);
        
        assertTrue( result.startsWith("java.lang.Object@") );
    }
    
    public void testRenderSimpleXml() {
        XmlRepresentable xmlRepr = new SimpleXmlTag();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml    :    " + result);

        assertTrue( result.startsWith("<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>") );
    }
    
    public void testRenderSimpleXmlWithContent() {
        XmlRepresentable xmlRepr = new SimpleXmlTagWithContent();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml+txt:    " + result);

        assertTrue( result.startsWith("<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith(">Lorem 5 &lt; 6 ipsum...</simpletag>") );
    }
    
    public void testRenderSimpleTextLeaf() {
        XmlRepresentable xmlRepr = new SimpleTextLeaf();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple txtLeaf:    " + result);

        assertTrue( "just some text...".equals(result) );
    }
    
}
