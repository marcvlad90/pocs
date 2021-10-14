package com.tools.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocitySample {
    public static void main(String[] args) throws Exception {
        helloVlad();
        petsSale();
    }

    public static void helloVlad() throws Exception {
        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /* next, get the Template */
        Template t = ve.getTemplate("helloworld.vm");
        /* create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "Vlad");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
        System.out.println(writer.toString());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void petsSale() {
        ArrayList list = new ArrayList();
        HashMap map = new HashMap();
        map.put("name", "horse");
        map.put("price", "10");
        list.add(map);
        map = new HashMap();
        map.put("name", "cow");
        map.put("price", "7");
        list.add(map);
        map = new HashMap();
        map.put("name", "chicken");
        map.put("price", "100");
        list.add(map);
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.setProperty("classpath.resource.loader.cache", "false");
        ve.setProperty("velocity.engine.resource.manager.cache.enabled", "false");
        ve.setProperty("resource.manager.cache.enabled", "false");
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("petList", list);
        Template t = ve.getTemplate("petssale.vm");
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println(writer.toString());
    }
}
