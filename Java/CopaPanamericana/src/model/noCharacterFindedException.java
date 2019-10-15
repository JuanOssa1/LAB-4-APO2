 
package model;

public class noCharacterFindedException extends Exception{
	public noCharacterFindedException(String moltenCoreWarning) {
		super(moltenCoreWarning);
	}
}