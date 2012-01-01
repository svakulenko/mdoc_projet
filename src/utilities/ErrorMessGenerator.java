package utilities;

public  class ErrorMessGenerator {

	private ErrorMessGenerator() {}
	
	static public String getDbErrorCode(Types.eDbError_t ec) {
		System.out.println("getDbErrorCode eDbError_t=" );
		String retval = "";
		
		if      (ec == Types.eDbError_t.ENONE)
			retval = "l'action a été exécuté"; // no error
		else if (ec == Types.eDbError_t.ERECORD_EXIST)	{
			retval = "le record existe dans database";
		}
		else if (ec == Types.eDbError_t.ERECORD_NOT_EXIST)
			retval = "le record n'existe pas dans database";
			
		else if (ec == Types.eDbError_t.EUNKNOWN)
			retval = "l'erreur inconnu";
		else if (ec == Types.eDbError_t.ENO_CONNECTION)
			retval = "pas de connection à dataBase, désolé :(";
		
		return retval;
		
	}
}
