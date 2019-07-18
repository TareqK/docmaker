/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker.strategy;

/**
 *
 * @author tareq
 */
public class ArabicLanguageClassDocmakerStrategy extends LanguageClassDocmakerStrategy {

  @Override
  public String getTagName() {
    return "doc.ar";
  }

  @Override
  public String getFolderName() {
    return "ar";
  }
}
