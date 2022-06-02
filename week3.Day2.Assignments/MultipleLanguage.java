/**
 * Assignment 1 - Abstraction
 * abstract class MultipleLanguage implements
 */
package week3.day2.assignments;

/**
 * @author vignesh
 *
 */
public abstract class MultipleLanguage implements Language, TestTool
{
	public void python() {
		System.out.println("Python - MultipleLanguage");
	}
	
	public abstract void ruby();

}
