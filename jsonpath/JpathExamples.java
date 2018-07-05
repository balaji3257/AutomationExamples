import com.jayway.jsonpath.JsonPath;

public class JpathExamples {

	
	
	static String json ="{\r\n" + 
			"    \"result\": \"WQnRO8ZReFIOlEKTDCBqpylUJWYoCIoVYg7sCLiWHS_jLMdo7n24yWPUgohUl7srKwgipqJ9nyxTeBmcapEJ33wExVSrjA83h_8ev3kJh0kvIUOLGrNP-fQrjAUcZmlkbxSO3nAlSAK3mTogAIpt5etoiCsNs1DgvlhOe40pCMbuENPA0qjUPwi-t3PFgUrxEZZhJFzMqyTcuYk7md81NAhr8HjF_NHl_nubUXkdIrP4dhbS1NIZpcv8RUW4_VbDJPio0VkuR9b2r6R4nvPAbt_Ar-89nXc7TlX_OqRnzJ9UoErX-Sy0Rhu313wqRuvlARvK-sJXItqzoobVUXTwCeJZ-91kI-PdBGCWtDOxKmtYExeeAIguIMqmzNYWwKfcc5heZ70ziec6oVrat_lY7gcX_XKQyJLvF9zyg4hflBrNtB8Fx5dzjIbImUI5zkLwjFg50evcMiji7zEIVvfhdypjykmyxee3WDXDCktjWisye8E-zrCZNG08uL84iXN6EuoBCCU9cVzi4j3qXzIEAQ\",\r\n" + 
			"    \"targetUrl\": null,\r\n" + 
			"    \"success\": true,\r\n" + 
			"    \"error\": null,\r\n" + 
			"    \"unAuthorizedRequest\": false,\r\n" + 
			"    \"__abp\": true\r\n" + 
			"}";
	
	
	
	public static void main(String[] args) {
		
		
		
		String strCreatorID = JsonPath.read(json, "$['result']");
		System.out.println(strCreatorID);
	}
	
	
	
}
