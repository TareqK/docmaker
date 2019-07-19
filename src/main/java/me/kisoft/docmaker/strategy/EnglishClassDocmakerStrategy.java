/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

import com.sun.javadoc.Tag;
import org.commonmark.node.Node;

/**
 *
 * @author tareq
 */
public class EnglishClassDocmakerStrategy extends LanguageDocmakerClassStrategy {

  @Override
  public String getTagName() {
    return "doc.en";
  }

  @Override
  public String getFolderName() {
    return "en";
  }

  @Override
  public Tag preprocessTag(Tag tag) {
    return tag;
  }

  @Override
  public Node postprocessHtml(Node document) {
    return document;
  }

}
