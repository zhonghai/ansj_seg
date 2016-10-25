package org.ansj.recognition.impl;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;

public class SynonymsRecgnitionTest {

	@Test
	public void test() {
		//使用默认的同义词词典
		SynonymsRecgnition synonymsRecgnition = new SynonymsRecgnition() ;
		
		String str = "我国中国就是华夏,也是天朝" ;
		
		for (Term term : ToAnalysis.parse("我国中国就是华夏")) {
			System.out.println(term.getName()+"\t"+(term.getSynonyms()));
		}
		
		System.out.println("-------------init library------------------");
		
		for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
			System.out.println(term.getName()+"\t"+(term.getSynonyms()));
		}
		

		System.out.println("---------------insert----------------");
		synonymsRecgnition.insert(new String[]{"中国","我国"});
		
		for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
			System.out.println(term.getName()+"\t"+(term.getSynonyms()));
		}
		
		System.out.println("---------------append----------------");
		synonymsRecgnition.append(new String[]{"中国","华夏","天朝"});
		
		for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
			System.out.println(term.getName()+"\t"+(term.getSynonyms()));
		}
		
		
		System.out.println("---------------remove----------------");
		synonymsRecgnition.remove("我国");
		
		for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
			System.out.println(term.getName()+"\t"+(term.getSynonyms()));
		}
		
		
	}

}
