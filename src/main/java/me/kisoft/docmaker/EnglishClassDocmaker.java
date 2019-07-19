/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker;

import com.sun.javadoc.RootDoc;
import static me.kisoft.docmaker.LanguageClassDocmaker.start;
import me.kisoft.docmaker.strategy.LanguageIndexDocmakerStrategy;
import me.kisoft.docmaker.strategy.EnglishClassDocmakerStrategy;

/**
 *
 * @author tareq
 */
public class EnglishClassDocmaker extends LanguageClassDocmaker {

  public static boolean start(RootDoc root) {
    return start(root, new EnglishClassDocmakerStrategy(), new LanguageIndexDocmakerStrategy());
  }
}
