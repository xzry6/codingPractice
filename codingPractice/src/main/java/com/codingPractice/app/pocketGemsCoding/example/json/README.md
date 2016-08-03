第二轮，传说中的亚裔小哥，parse json to database
小哥进来同样以为自己是第三轮。。不知道怎么回事儿。
看版上有人报这题，但是找了很久都没有太多细节，我尽量多的回忆吧，希望能帮到后边的人。
json格式.[
{type:"session", data:{player_id:89757, session_id:66055, name:"ergou", date:"2016-1-1HHMMSS"}},
{type:"purchase", data:{player_id:89757, session_id:66055, state:"success", date:"2016-1-2HHMMSS"}},
{type:"battle", data:{player_id:...., session_id:...., result:....}},
.....
]
就是这类型的，长这样整体叫events，里边的每一条叫event，长的差不多，名字不一样，data也就相应的不一样。

database格式
class Row {
      String tableName;
      Map<String, String> map;
}
就是把json的格式parse了然后变成这样就行了，tableName就是对应上边的type（session，purchase，battle这种），map里就是每个event里data里所有的key value pair。

然后给了一个class
class JSONValue {
       String getAsString()
       Long getAsLong()
       Map getAsMap()
       List getAsList()
       ..... 
}
就是每个key value pair的value都是一个JSONValue，整个的list也是JSONValue，data也是，可以用这些method转换成java的的类型（别的语言也行，我是java），但是特定的类型只能call特定的函数，比如session对应的是数字，所以你提取session的值的时候只能call getAsLong()，如果你call了getAsMap()或其他的就不对。而data是Map，parse data时候只能call getAsMap()这个意思。
 
你要实现的method接口是
List<Row> parseToDB(List<JSONValue> events, Config c) {
. more info on 1point3acres.com
}
类似这样表达
arg1 就是上面的JSON，是一堆events。Config是另一个类型也是需要设计的，具体功能差不多就是告诉你哪个类型需要调用JSONValue里的哪个method才能parse对，比如告诉你session里的name是string类型，那么你parse name这个field的时候就要call getAsString()这样。这里需要OOD，我设计了一个type的Interface然后就差不多那样我也不是很清楚楼主非常水的。。。。

