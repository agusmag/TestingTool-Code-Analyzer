/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasDeParser;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.util.List;

/**
 *
 * @author maxim
 */
public class MethodNamePrinter extends  VoidVisitorAdapter<List<String>> {
  
 @Override
 public void visit(MethodDeclaration md, List<String> collector) {
    super.visit(md, collector);
    collector.add(md.getNameAsString());
 } 
}
