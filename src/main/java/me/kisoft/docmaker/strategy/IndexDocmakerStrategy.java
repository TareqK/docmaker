/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

import com.sun.javadoc.ClassDoc;

/**
 *
 * @author tareq
 */
public interface IndexDocmakerStrategy {

  /**
   * Creates an index file
   *
   * @param classes the classes to create index files for
   * @param strat the strat used to generate the classdoc
   */
  void createIndexFile(ClassDoc[] classes, ClassDocmakerStrategy strat);
}
