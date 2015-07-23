import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




class TestMain {  
	  /**
	   * covert time str to mins count from 00:00am
	   * @param str the time str (H:Mxm)
	   * @return mins count from 00:00am
	   */
	  static int covertTime(String str){
		  int res, mins;
		  if(str == "12:00am") return 0;
		  Pattern p = Pattern.compile("\\d\\d?");
		  Matcher m = p.matcher(str);
		  m.find();
		  String hh = m.group();
		  m.find();
		  String mm = m.group();
		  mins = Integer.parseInt(hh)*60+Integer.parseInt(mm);
		  return (Pattern.compile("am").matcher(str).find()|| mins>=720)? mins: mins+720;
	  }

	  /**
	   * count the occupation of  the greatest number of repeated letter
	   * @param s the sentence String to be counted
	   * @return the occupation number of the letter
	   */
	  static int countMaxAppearedLetter(String s) {
		  int max = 1;
		  int count = 1;
		  char[] arr = s.toCharArray();
		  Arrays.sort(arr);
		  for(int i=1; i<arr.length; i++){
			  if(arr[i]==arr[i-1]){
				  count++;
				  max= count>max? count: max;
			  }
			  else count = 1;
		  }
		  return max;
	  }
	  
	  /** 
	   * shift the characters in a string by 1 to the right based off their positions in the alphabet  
	   * @param str the string value to be changed
	   * @return result string which has characters shifted by 1
	   */
	  String letterChanges(String str) {
//		StringBuffer s = new StringBuffer(str);
		String[] buff = str.split("");
		String lower = "abcdefghijklmnopqrstuvwxyz";
		return Arrays.stream(buff).map(s -> {
			int index = lower.indexOf(s);
			if(index == -1){
				return s;
			}else{
				return Character.toString(lower.charAt((index+1)%25));
			}
		}).map(s -> "aeiou".indexOf(s) == -1? s: s.toUpperCase()).collect(Collectors.joining(""));
	  }
	  
	  /**
	   * sum up all the numbers from 0 to the target number.
	   * @param num the target number
	   * @return the sum
	   */
	  int simpleAdding(int num) {
		  return IntStream.range(0,	num+1).sum();
	  }
	  
	  /**
	   * Capitalize each word first letter
	   * @param sen the sentence to be capitalized
	   * @return sentence of first letter of each word capitalized 
	   */
	  String letterCap(String sen) {
		  return Arrays.stream(sen.split(" "))
				  .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
				  .collect(Collectors.joining(" "));
	  }
	  
	  /**
	   * sort characters in a string into alphabet order
	   * @param str the string value to be sorted
	   * @return string of characters in alphabet order
	   */
	  String alphabetSoup(String str){
		  String[] arr = str.split("");
		  Arrays.sort(arr);
		  return String.join("", arr);
	  }

	  /**
	   * count the number of vowels in a string
	   * @param str the string to be counted
	   * @return the number of vowels
	   */
	  long vowelCount(String str){
//		  return Arrays.stream(str.split("")).filter(s -> "aeiouAEIOU".indexOf(s) != -1 ).count();
		  return Pattern.compile("").splitAsStream(str).filter(s -> "aeiouAEIOU".indexOf(s) != -1).count();
	  }
	  
	  /**
	   * check if a string is palindrome (reverse order of the characters is the same as the String)
	   * @param str the string to be checked
	   * @return true if the string is palindrome
	   */
	  String palindrome(String str){
//		  String[] buff = str.split(" ");
//		  String dst = String.join("", buff);
		  return str.equals(new StringBuffer(str).reverse().toString())? "true": "false";
	  }
	  
	  /**
	   * find the longest word in a sentence
	   * @param sen the sentence to find longest word within
	   * @return the longest word
	   */
	  String LongestWord(String sen) { 
		  Pattern p = Pattern.compile("\\W+"); // will match ' as well
		  String[] buff = p.split(sen);
		  System.out.println("title..........." + Arrays.asList(buff));
//		  List<String> l = Arrays.asList(buff);
		  return Arrays.stream(buff).reduce((temp, word) -> word.length() > temp.length()? word: temp).get();
	  }

	  /**
	   * multiply all the numbers from 1 to the target number
	   * @param num the target number
	   * @return the product
	   */
	  int FirstFactorial(int num) { 
		  return IntStream.iterate(1, n -> ++n).limit(num)
				  .reduce((product,item) -> product*item).getAsInt();
	  }

	  /**
	   * find all the numbers and sum them up
	   * @param str the string value to find numbers in
	   * @return the sum
	   */
	  int numAddiction(String str){
		  return Pattern.compile("\\D+").splitAsStream(str)
				  .filter(s -> s != "")
				  .mapToInt(Integer::parseInt).sum();
	  }

	  /**
	   * check if there is a digit in the first number appears 3 times and the same digit appears 2 times in the 2nd number
	   * @param num1 
	   * @param num2
	   * @return true if there is a digit in the first number appears 3 times and the same digit appears 2 times in the 2nd number
	   */
	  int tripleDouble(int num1, int num2){
		  Pattern p = Pattern.compile("(\\d)(\\1{2})");
		  Matcher m = p.matcher(String.valueOf(num1));
		  while(m.find()){
			  if(String.valueOf(num2).indexOf(m.group(2)) != -1)
					  return 1;
		  }
		  return 0;
	  }

	  /**
	   * check if the brackets are matched correctly
	   * @param str the string to be checked
	   * @return true if they are all matched
	   */
	  int BracketMatcher(String str){
		  str = str.replaceAll("[^()]", "");
		  int count = 0;
		  for(int i=0; i<str.length(); i++) {
			  count = str.charAt(i) == '('? ++count: --count;
			  if(count<0) return 0;
		  }
		  return count == 0? 1: 0;
	  }

	  /**
	   * check if a number is the power of 2
	   * @param num the number to be checked
	   * @return true if the number is power of 2
	   */
	  String PowersofTwo(int num) { 
		  double temp = (double)num/2;
		  while (temp>1){
			  temp /= 2;
		  }
		  return temp == 1? "true": "false";
	  }

	  
	  int AdditivePersistence(int num) { 
		  int count = 0;
		  while(num>9){
			  count++;
			   num = Pattern.compile("").splitAsStream(Integer.toString(num)).mapToInt(Integer::parseInt).sum();
		  }
		  return count;
	  }
	  
	  /**
	   * test if a date is between 5 years in the past and 1 year in the future
	   * @param date the date value to test
	   * @return true if the date is within the boundary
	   */
	  public static boolean testDate(Date date){
	    Date lowerBoundary = getBoundary(-5);
	    Date upperBoundary = getBoundary(1);
	    return date.compareTo(lowerBoundary) >=0 && date.compareTo(upperBoundary) <= 0;
	  }
	  
	  /**
	   * get lower/upper year boundary for Date
	   * @param years amount to roll, negative to roll down
	   * @return date boundary
	   */
	  public static Date getBoundary(int amount){
	    SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setLenient(false);
	    cal.roll(Calendar.YEAR, amount);
	    Date res = cal.getTime();
	    try {
	    res = sf.parse(sf.format(res));
	    } catch (ParseException e) {
	    e.printStackTrace();
	    }
	    return res;
	  }
	  
	  int myfunc(String str) {
		  return 1;
	  }
	  
	  /**
	   * match date string in 3 ways: 10-03-1999, 1999-10-03 and 03-DEC-1999. separators: .-/. time is optional.
	   * @param dateStr
	   * @return true if dateStr is a valid date
	   */
	  public static boolean validateDate(String dateStr) {
		  String s1 = "^(?=\\d)(?:(?!(?:(?:0?[5-9]|1[0-4])(?:\\.|-|\\/)10(?:\\.|-|\\/)(?:1582))|(?:(?:0?[3-9]|1[0-3])(?:\\.|-|\\/)0?9(?:\\.|-|\\/)(?:1752)))(31(?!(?:\\.|-|\\/)(?:0?[2469]|11))|30(?!(?:\\.|-|\\/)0?2)|(?:29(?:(?!(?:\\.|-|\\/)0?2(?:\\.|-|\\/))|(?=\\D0?2\\D(?:(?!000[04]|(?:(?:1[^0-6]|[2468][^048]|[3579][^26])00))(?:(?:(?:\\d\\d)(?:[02468][048]|[13579][26])(?!\\x20BC))|(?:00(?:42|3[0369]|2[147]|1[258]|09)\\x20BC))))))|2[0-8]|1\\d|0?[1-9])([-.\\/])(1[012]|(?:0?[1-9]))\\2((?=(?:00(?:4[0-5]|[0-3]?\\d)\\x20BC)|(?:\\d{4}(?:$|(?=\\x20\\d)\\x20)))\\d{4}(?:\\x20BC)?)(?:$|(?=\\x20\\d)\\x20))?((?:(?:0?[1-9]|1[012])(?::[0-5]\\d){0,2}(?:\\x20[aApP][mM]))|(?:[01]\\d|2[0-3])(?::[0-5]\\d){1,2})?$";
		  String s2 = "^(?=\\d)(?:(?!(?:1582(?:\\.|-|\\/)10(?:\\.|-|\\/)(?:0?[5-9]|1[0-4]))|(?:1752(?:\\.|-|\\/)0?9(?:\\.|-|\\/)(?:0?[3-9]|1[0-3])))(?=(?:(?!000[04]|(?:(?:1[^0-6]|[2468][^048]|[3579][^26])00))(?:(?:\\d\\d)(?:[02468][048]|[13579][26]))\\D0?2\\D29)|(?:\\d{4}\\D(?!(?:0?[2469]|11)\\D31)(?!0?2(?:\\.|-|\\/)(?:29|30))))(\\d{4})([-\\/.])(0?\\d|1[012])\\2((?!00)[012]?\\d|3[01])(?:$|(?=\\x20\\d)\\x20))?((?:(?:0?[1-9]|1[012])(?::[0-5]\\d){0,2}(?:\\x20[aApP][mM]))|(?:[01]\\d|2[0-3])(?::[0-5]\\d){1,2})?$";
		  String s3 = "^((31(?! (FEB|APR|JUN|SEP|NOV)))|((30|29)(?! FEB))|(29(?= FEB (((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)))))|(0?[1-9])|1\\d|2[0-8])-(JAN|FEB|MAR|MAY|APR|JUL|JUN|AUG|OCT|SEP|NOV|DEC)-((1[6-9]|[2-9]\\d)\\d{2})$";
//		  Pattern p1 = Pattern.compile("("+s1+")|("+s2+")");
		  Pattern p1 = Pattern.compile(s1);
		  Pattern p2 = Pattern.compile(s2);
		  Pattern p3 = Pattern.compile(s3);
		  Matcher m1 = p1.matcher(dateStr);
		  Matcher m2 = p2.matcher(dateStr);
		  Matcher m3 = p3.matcher(dateStr);
		  return m1.matches() || m2.matches() || m3.matches();
//		  return m1.matches();
	  }
	  
	  /**
	   * check if a str is a number
	   * @param str
	   * @return true if it is a number
	   */
	  public static boolean isNumber(String str) {
		  String s = "^(((\\d{1,3})(,\\d{3})*)|(\\d+))(.\\d+)?$";
		  Pattern p = Pattern.compile(s);
		  Matcher m = p.matcher(str);
		  return m.matches();
	  }
	  





public static boolean exists(String URLName){
    try {
      HttpURLConnection.setFollowRedirects(false);
      // note : you may also need
      //        HttpURLConnection.setInstanceFollowRedirects(false)
      HttpURLConnection con =
         (HttpURLConnection) new URL(URLName).openConnection();
      con.setRequestMethod("HEAD");
      return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
    }
    catch (Exception e) {
       e.printStackTrace();
       return false;
    }
  }

static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

  public static void main (String[] args) throws ParseException { 
	  //TODO:test result
//	  Child c = new Child();
//	  System.out.println("title..........." + c.getId());
    // keep this function call here     
	  TestMain c = new TestMain();
	  List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"1", "2", "32", "4", "0"}));
//	  c.LongestWord("as dfa,sdf!longest_word fa,sf,da,s,df,asf,da");
//    Scanner  s;
//    Date d = new Date("12/29/1999");
//	  Map<String, String> m = new HashMap<String, String>();l
//	  Map<String, String> m2 = new HashMap<String, String>(m);
//	  m.put("name", "tom");
//	  m.put("age", "reo");
//	  System.out.println("title..........." + m2.size());
//	  String test = "";
//	  char[] chars =  test.toCharArray();
//	  System.out.println("title..........." + String.valueOf(chars));
//	  StringJoiner sj = new StringJoiner(",", "{", "}");
//	  ListNode l1 = new ListNode(2);
//	  l1.next = new ListNode(1);
//	  l1.next.next = new ListNode(5);
//	  ListNode l2 = new ListNode(5);
//	  l2.next = new ListNode(9);
//	  l2.next.next = new ListNode(2);
//	  System.out.println("title..........." + getNum(l1));
//	  System.out.println("title..........." + getNum(addLists(l1,l2)));
	  int res =c.hashCode(new char[] {'u','b','u','n','t', 'u'}, 2607);
	  System.out.println("title..........." + res);
	  double d = 126*(Math.pow(33, 25))*26;
	  System.out.println("d..........." + Double.MAX_VALUE);
	  System.out.println(97*(Math.pow(33, 25))*26);
  }
  
  public int hashCode(char[] key,int HASH_SIZE) {
      // write your code here
      double res = 0;
      int len = key.length;
      for(int i=0; i<key.length; i++) {
          res += key[i]*(Math.pow(33, len-1-i)) % HASH_SIZE;
          System.out.println("res..........." + res);
//          System.out.println("c..........." + key[i]*1);
//          System.out.println("i..........." + key[i]*(Math.pow(33, len-1-i)));
      }
      return (int)(res % HASH_SIZE);
//      return 0;
  }
  public static ListNode addLists(ListNode l1, ListNode l2) {
      // write your code here
      long i1 = getNum(l1);
      long i2 = getNum(l2);
      String[] res = Long.toString(i1+i2).split("");
      ListNode l = new ListNode(Integer.parseInt(res[res.length-1]));
      ListNode it = l;
      for(int i=res.length-2; i>-1; i--) {
      	it.next = new ListNode(Integer.parseInt(res[i]));
      	it = it.next;
      }
      return l;
  }

  public static long getNum(ListNode node) {
  	ListNode it = node;
  	StringBuilder sb = new StringBuilder();
  	do{
  		sb.append(it.val);
  		it = it.next;
  	}while(it != null);
  	return Long.parseLong(sb.reverse().toString());
  }

  
}
  


class MyCompare implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return 0;
	}
	
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int val) {
         this.val = val;
         this.next = null;
     }
}
     

