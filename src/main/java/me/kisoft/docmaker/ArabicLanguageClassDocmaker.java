/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker;

import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.RootDoc;
import me.kisoft.docmaker.strategy.ArabicLanguageClassDocmakerStrategy;
import me.kisoft.docmaker.strategy.LanguageIndexDocmakerStrategy;

/**
 *
 * @author tareq
 */
public class ArabicLanguageClassDocmaker {

  public static boolean start(RootDoc root) {
    return ClassDocmaker.start(root, new ArabicLanguageClassDocmakerStrategy(), new LanguageIndexDocmakerStrategy());
  }

  public static int optionLength(String option) {
    return ClassDocmaker.optionLength(option);
  }

  public static boolean validOptions(String options[][], DocErrorReporter reporter) {
    return ClassDocmaker.validOptions(options, reporter);
  }
}
