/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

import com.sun.javadoc.ClassDoc;

/**
 *
 * @author tareq An Strategy interface for documenting classes
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

  String getFolderName();
}
