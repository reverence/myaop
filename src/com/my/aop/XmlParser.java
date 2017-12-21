public class XmlParser {  
    public static Map<String,BeanDefinition> parse(String path) throws Exception {  
        InputStream is = XmlParser.class.getResourceAsStream("/"+path);  
        SAXReader saxReader = new SAXReader();  
        Document document = saxReader.read(is);  
        Element element = document.getRootElement();//root elements must be beans  
        if(!element.getName().equalsIgnoreCase("beans"))  
            throw new Exception("wrong xml format");  
        Map<String,BeanDefinition> map = new HashMap<>();  
        List<Element> elements = element.elements();  
        for(Element elem : elements){  
            String name = elem.getName();  
            //考虑到applicationContext.xml可以加入更多的标签进行解析,我们将对应的parser从策略工厂里获取  
            StrategyFactory.getBeanDefinitionParser(name).parse(elem,map);  
        }  
        return map;  
    }  
}  
