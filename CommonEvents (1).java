package coreUtilities.utils;

public class CommonEvents {
	public CommonEvents() {
	

	}
public Response getResponse(String url)
{
Response response=RestAssured.given().header("authorization",AuthUtil.getAuthHeader()).get(url);
return response;
}
public int getStatusCode(Response response)
{
return response.getStatusCode();
}
public String getStatus(Response response)
{
 String value=response.getStatusLine();

String arr[]=value.split(" ",3);
return arr[2];


}
public List<Map<String,Object>> getResultsList(Response response,String jsonValue)
{
return response.getJosnPath().getList(jsonValue);
}
public Map<String,Object>> getResultsMap(Response response,String jsonValue)
{
return response.getJosnPath().getMap(jsonValue);
}

}
