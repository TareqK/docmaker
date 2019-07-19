/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.docmaker;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.RootDoc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.kisoft.docmaker.strategy.IndexDocmakerStrategy;
import me.kisoft.docmaker.strategy.ClassDocmakerStrategy;

/**
 *
 * @author tareq
 */
public abstract class LanguageClassDocmaker {

  private static final String[] SINGLE_OPTS_ARRAY = {"-protected", "-author", "-use", "-version", "-Xdoclint:none"};
  private static final String[] DOUBLE_OPTS_ARRAY = {"-linkoffline"};
  private static final ArrayList<String> SINGLE_OPTS = new ArrayList(Arrays.asList(SINGLE_OPTS_ARRAY));
  private static final ArrayList<String> DOUBLE_OPTS = new ArrayList(Arrays.asList(DOUBLE_OPTS_ARRAY));
  private static final Logger LOG = Logger.getLogger(LanguageClassDocmaker.class.getName());

  public static boolean start(RootDoc root, ClassDocmakerStrategy strat, IndexDocmakerStrategy indexStrat) {
    return processClasses(root.classes(), strat, indexStrat);
  }

  private static boolean processClasses(ClassDoc[] classes, ClassDocmakerStrategy strat, IndexDocmakerStrategy indexStrat) {
    ArrayList<ClassDoc> arr = new ArrayList();

    for (ClassDoc c : classes) {
      if (strat.processClass(c)) {
        arr.add(c);
      }
    }
    LOG.log(Level.INFO, "Processed Classes : {0}", arr.size());
    ClassDoc[] classesProcessed = arr.toArray(new ClassDoc[arr.size()]);
    indexStrat.createIndexFile(classesProcessed, strat);
    return true;
  }

  public static int optionLength(String option) {
    if (SINGLE_OPTS.contains(option)) {
      return 1;
    }
    if (DOUBLE_OPTS.contains(option)) {
      return 3;
    }

    return 2;
  }

  public static boolean validOptions(String options[][], DocErrorReporter reporter) {
    return true;
  }
}
