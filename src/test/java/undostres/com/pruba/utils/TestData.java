package undostres.com.pruba.utils;

import java.util.HashMap;

public class TestData {
	
	
	
	
	//To get the operator name  by hashmap and  later we can add more operator code
	public static HashMap<Integer,String>getOperator()
	{
		HashMap<Integer,String> operatorCode=new HashMap<Integer,String>();
		
		operatorCode.put(1, "Telcel");
		operatorCode.put(2, "Movistar");
		operatorCode.put(15, "AT&T");
		operatorCode.put(3, "Iusacell");
		operatorCode.put(4, "Unefon");
		return operatorCode;
	}
	
	//To get the recharge value  by hashmap and  later we can add more recharge code code
	public static HashMap<Integer,String>getRechargeCode()
	{
		HashMap<Integer,String> rechargeCode=new HashMap<Integer,String>();	
		rechargeCode.put(10, "10");
		rechargeCode.put(20, "20");
		rechargeCode.put(29, "29");
		return rechargeCode;
	}
	
	public enum CARDINFO
	{
		CARDHOLDER("Test"),
		VISA("4111111111111111"),
		MASTER("4111111111111111"),
		CVV("111"),
		YEAR("2025"),
		MONTH("11"),
		EMAIL("test@test.com"),
		EMAIL2("marze.zr@gmail.com"),
		PASSWORD("123456");
		String cardInfo;
    	public String getCardInfo()
    	{
    		return cardInfo;
    	}
    	CARDINFO(String cardInfo)
    	{
    		this.cardInfo=cardInfo;
    	}
	}
	
	public enum PAYEMENTOPTION
	{
		COINPURSE,CARD,PAYPAL,SPEI
	}
	
	public enum MESSAGE
	{
		INVALIDLOGIN("Correo/Movil o contraseña no válido!"),
		SUCCESSFULL("Recharge Successfull");
		
		String message;
    	public String getMessageInfo()
    	{
    		return message;
    	}
    	MESSAGE(String message)
    	{
    		this.message=message;
    	}
	}
	
	

}
