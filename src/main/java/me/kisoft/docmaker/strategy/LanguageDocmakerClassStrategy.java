/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Tag;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public abstract class LanguageDocmakerClassStrategy implements ClassDocmakerStrategy {

  private static final Logger LOG = Logger.getLogger(LanguageDocmakerClassStrategy.class.getName());

  @Override
  public String processClassName(ClassDoc classdoc) {
    return classdoc.typeName();
  }

  @Override
  public boolean processClass(ClassDoc classdoc) {
    Tag[] tags = classdoc.tags(getTagName());
    if (tags.length > 0) {
      if (tags.length < 1) {
        LOG.log(Level.SEVERE, "Please only use one single {0} tag", getTagName());
        return false;
      }
      String tagText = preprocessTag(tags[0]).text();
      Parser parser = Parser.builder().build();
      Node document = postprocessHtml(parser.parse(tagText));
      HtmlRenderer renderer = HtmlRenderer.builder().build();
      String html = renderer.render(document);
      File f = new File(getFolderName() + "/" + processClassName(classdoc));
      f.getParentFile().mkdirs();
      try (FileOutputStream out = new FileOutputStream(f)) {
        out.write(html.getBytes());
      } catch (IOException ex) {
        LOG.severe(ex.getMessage());
      }
      return true;
    } else {
      return false;
    }
  }

}
