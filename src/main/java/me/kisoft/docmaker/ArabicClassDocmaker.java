/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker;

import com.sun.javadoc.RootDoc;
import me.kisoft.docmaker.strategy.ArabicClassDocmakerStrategy;
import me.kisoft.docmaker.strategy.LanguageIndexDocmakerStrategy;

/**
 *
 * @author tareq
 */
public class ArabicClassDocmaker extends LanguageClassDocmaker {

  public static boolean start(RootDoc root) {
    return start(root, new ArabicClassDocmakerStrategy(), new LanguageIndexDocmakerStrategy());
  }
}
