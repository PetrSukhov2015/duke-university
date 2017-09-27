package level4.earthquake.task;

public class PhraseFilter implements Filter{
	private String typeRequest=null;
	private String phrase=null;
	private final static String FILTER_NAME="PhraseFilter";
	public PhraseFilter(String req, String phr) {
		typeRequest = req.toLowerCase();
		phrase = phr;
		//if typeRequest.toLowerCase()equals("any")
				// TODO Auto-generated constructor stub
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		String tmpQeInfo=qe.getInfo();
		switch (typeRequest){
			case "start":
				if (tmpQeInfo.startsWith(phrase)){return true;}
				break;
			case "end":
				if (tmpQeInfo.endsWith(phrase)){return true;}
				break;
			case "any":
				if (tmpQeInfo.contains(phrase)){return true;}
				break;
			default:
				return false;
				
		}
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return FILTER_NAME;
	}
	

}
