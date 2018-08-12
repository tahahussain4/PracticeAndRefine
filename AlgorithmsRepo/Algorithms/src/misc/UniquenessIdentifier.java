package misc;

import java.util.HashSet;

public class UniquenessIdentifier {
	Action action;
	IteratorAlgorithm algorithm;
	String string;
	
	public static void main(String[] args) {
		UniquenessIdentifier finder = new UniquenessIdentifier();
//		System.out.println(finder.isUnique(""));
		System.out.println(finder.repeatingCharacters("erertyuiy").toString());
	}


	public boolean isUnique(String string) {
		// TODO Auto-generated method stub
		for(int charPos = 0; charPos< string.length() - 1 ; charPos++) {
			for(int compareCharPos = charPos + 1; compareCharPos < string.length() ;compareCharPos++) {
				if(string.charAt(charPos) == string.charAt(compareCharPos)) {
					return false;
				}
			}
		}
		return true;
	}

	public UniquenessIdentifier() {
		super();
		algorithm = (action,string) -> {
			for(int charPos = 0; charPos< string.length() - 1 ; charPos++) {
				for(int compareCharPos = charPos + 1; compareCharPos < string.length() ;compareCharPos++) {
					if(string.charAt(charPos) == string.charAt(compareCharPos)) {
						action.action(new Object[10]);
						if(action.midReturnObject != null) {
							action.midReturnObject;
						}
					}
				}
			}
			return aciton.returnObject;
		};
		
	}


	public HashSet<Character> repeatingCharacters(String string) {
		HashSet<Character> characterSet = new HashSet<Character>();
		for(int charPos = 0; charPos< string.length() - 1 ; charPos++) {
			for(int compareCharPos = charPos + 1; compareCharPos < string.length() ;compareCharPos++) {
				if(string.charAt(charPos) == string.charAt(compareCharPos)) {
//					return false;
					char character = string.charAt(charPos);
					if(!characterSet.contains(character)) {
						characterSet.add(character);
					}
				}
			}
		}
		return characterSet;
	}
	
	interface IteratorAlgorithm {
		public abstract Object iterate(Action action,String string);
	}

	interface Action {
		public abstract Object action(Object[] list);
	}
}

