package interview;

/**
 * Created by morsi on 25/04/2017.
 */
public class LoadConfig
{
//  // This is the text editor interface.
//  // Anything you type or change here will be seen by the other person in real time.
//
//  servers = staging,production,test
//  staging = 1.2.3.4,http_port
//  production = 1.2.3.5,http_port,secret_key
//  http_port = 80
//  test = localhost
//  secret_key = qweasd
//
//  load_config(“servers”) = 1.2.3.4,80,1.2.3.5,80,qweasd,localhost
//
//  Map<String,List<String>> map = new HashMap<>();
//map.put("servers",Arrays.asList("staging","production","test");
//..
//
//  public String load_config(String input)
//  {
//
//    List<String> valueInTheMap = map.get(input);
//    if(valueInTheMap==null)
//    {
//      return input;
//    }
//    if(valueInTheMap.size()==1)
//    {
//      return valueInTheMap.get(0);
//    }
//    if(valueInTheMap.size()!=0) {
//      StringBuilder sb = new StringBuilder();
//      for(String actualValue: valueInTheMap)
//      {
//        // check if it is a string or a key
//        if(map.contains(actualValue))
//        {
//          sb.append(load_config(actualValue));
//        } else
//        {
//          sb.append(actualValue);
//        }
//        sb.append(",");
//      }
//      return sb.toString();
//    } else
//    {
//      return "";
//    }
//
//
//  }
//
//  // staging, production, test
//  // 1.2.3.4
}
