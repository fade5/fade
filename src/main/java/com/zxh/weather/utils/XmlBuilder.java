package com.zxh.weather.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author zxh
 * @Title: XmlBuilder
 * @ProjectName weather
 * @Description: xml转换为vo对象
 * @date 2018/10/1810:42
 */
public class XmlBuilder {

    public static Object xmlToV(Class <?> clazz ,String  strXml) throws  Exception{
        Object objectXml =null;
        Reader reader=null;
        JAXBContext jaxbContext=JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        reader=new StringReader(strXml);
        objectXml=unmarshaller.unmarshal(reader);
        if(reader!=null){
            reader.close();
        }
        return objectXml;
    }
}
