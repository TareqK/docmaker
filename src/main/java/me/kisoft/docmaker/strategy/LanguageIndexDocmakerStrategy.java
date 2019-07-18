/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

import com.sun.javadoc.ClassDoc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 *
 * @author tareq
 */
public class LanguageIndexDocmakerStrategy implements IndexDocmakerStrategy {

  @Override
  public void createIndexFile(ClassDoc[] classes, ClassDocmakerStrategy strat) {
    ArrayList<String> classNames = new ArrayList<>();
    for (ClassDoc c : classes) {
      classNames.add(strat.processClassName(c));
    }
    StringBuilder sb = new StringBuilder();
    for (String className : classNames) {
      sb.append("[").append(className).append("]").append("(./").append(className).append(")\n\n");
    }
    File f = new File(strat.getFolderName() + "/index.html");
    f.getParentFile().mkdirs();
    Parser parser = Parser.builder().build();
    Node document = parser.parse(sb.toString());
    HtmlRenderer renderer = HtmlRenderer.builder().build();
    String html = renderer.render(document);
    try (FileOutputStream out = new FileOutputStream(f)) {
      out.write(html.getBytes());
    } catch (IOException ex) {
      Logger.getLogger(LanguageIndexDocmakerStrategy.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
