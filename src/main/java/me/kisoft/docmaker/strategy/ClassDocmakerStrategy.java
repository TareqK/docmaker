/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Tag;
import org.commonmark.node.Node;

/**
 * An interface that represntes a strategy for processing a class
 *
 * @author tareq
 */
public interface ClassDocmakerStrategy {

  /**
   * The name of the doc tag we are looking for
   *
   * @return The name of the doc tag we are looking for
   */
  String getTagName();

  /**
   * Processes a class
   *
   * @param classdoc the classdoc to be passed for processing
   * @return true on success, false on failure
   */
  boolean processClass(ClassDoc classdoc);

  /**
   * Process a classdoc to a file name
   *
   * @param classdoc the classdoc to process
   * @return a String of the file name
   */
  String processClassName(ClassDoc classdoc);

  /**
   * Gets the name of the folder where the class doc files will be placed
   *
   * @return a string of the file name, relative to the root of the javadoc folder
   */
  String getFolderName();

  /**
   * Preprocesses a tag
   *
   * @param tag the tag to process
   * @return the processed tag
   */
  Tag preprocessTag(Tag tag);

  /**
   * Postprocesses the HTML Document produced from parsing markdown
   *
   * @param document an html document produced from parsing markdown
   * @return the proccessed nodez
   */
  Node postprocessHtml(Node document);
}
