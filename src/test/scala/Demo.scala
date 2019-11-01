

class Demo extends Simulation {
  //用户请求数据库
  val baseHeader = Map(
    "User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
  )
  object requestObject {
    val request =
      exec(
        http("asdasd")
          .get("https://www.baidu.com")
          .headers(baseHeader)
      )
  }
  val scn = scenario("asdasd").exec(
    requestObject.request
  )
  setUp(
    scn.inject(
      incrementUsersPerSec(5) // Double
        .times(5)
        .eachLevelLasting(10 seconds)
        .separatedByRampsLasting(10 seconds)
        .startingFrom(10) // Double
    ))
}
//  val headers_2 = Map("Content-Type" -> "multipart/form-data; boundary=--------------------------834689613902067375214408","cache-control" -> "no-cache")
//
//  //数据库配置  queue->按顺序获取数据,circular->循环按顺序获取数据，random随机获取数据
//  val Demo = jdbcFeeder("jdbc:sql链接","用户名","密码","查询语句").circular
//
//  val headers_0 = Map(
//    "cache-control" -> "no-cache")
//
//  object HttpDemo {
//    val demo =
////      feed(xzstubfeed)  //只有设置了feed才能动态获取数据并请求 否则是直接发送请求
//        exec(http("xzstubtest") // let's give proper names, they are displayed in the reports, and used as keys
//          .get("/")
//      )
//
//        .pause(1 millisecond) // let's set the pauses to 1 sec for demo purpose
//        .pause(2 millisecond)
//        .exec(session=>{
//          println(session) //打印session信息
//          session
//        })
//
//    //
//  }
//
//  //配置请求链接基本参数
//  val httpProtocol = http
//    .baseUrl("https://www.baidu.com")   //请求域名
//    //    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") //请求头部信息
//    //    .contentTypeHeader("multipart/form-data; boundary=--------------------------834689613902067375214408")
//    .acceptLanguageHeader("en-US,en;q=0.5")
////    .proxy(Proxy("127.0.0.1",8888).http) //配置代理
//    .acceptEncodingHeader("gzip, deflate")
//    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
//
//
//  /*
//  * repeat(times，counterName)
//  * times:循环次数
//  * counterName:计数器名称，可选参数，可以用来当当前循环下标值使用，从0开始
//  * */
//  /*
//  * during(duration, counterName, exitASAP)
//  * duration:时长，默认单位秒，可以加单位milliseconds，表示毫秒
//  * counterName:计数器名称，可选。很少使用
//  * exitASAP：默认为true,简单的可以认为当这个为false的时候循环直接跳出,可在循环中进行控制是否继续
//  * */
//  val scn = scenario("province_map").repeat(1){exec(HttpDemo.demo)}  //
//  //  val test = scenario("province_map").repeat(10){exec(Loding.regionRequest)}
//  /*
//  * nothingFor(duration)：设置一段停止的时间
//  * rampUsers(nbUsers) over(duration)：在指定时间内，设置一定数量逐步注入的虚拟用户
//  * constantUsersPerSec(rate) during(duration)：定义一个在每秒钟恒定的并发用户数，持续指定的时间
//  * constantUsersPerSec(rate) during(duration) randomized：定义一个在每秒钟围绕指定并发数随机增减的并发，持续指定时间
//  * rampUsersPerSec(rate1) to (rate2) during(duration)：定义一个并发数区间，运行指定时间，并发增长的周期是一个规律的值
//  * rampUsersPerSec(rate1) to(rate2) during(duration) randomized：定义一个并发数区间，运行指定时间，并发增长的周期是一个随机的值
//  * heavisideUsers(nbUsers) over(duration)：定义一个持续的并发，围绕和海维赛德函数平滑逼近的增长量，持续指定时间（译者解释下海维赛德函数，
//  * H(x)当x>0时返回1，x<0时返回0，x=0时返回0.5。实际操作时，并发数是一个成平滑抛物线形的曲线）
//  *
//  * splitUsers(nbUsers) into(injectionStep) separatedBy(duration)：定义一个周期，执行injectionStep里面的注入，将nbUsers的请求平均分配
//  * splitUsers(nbUsers) into(injectionStep1) separatedBy(injectionStep2)：使用injectionStep2的注入作为周期，分隔injectionStep1的注入，直到用户数达到nbUsers
//   */
//
//
//  //  setUp(
//  //    scn.inject(
//  //      nothingFor(4), // 1
//  //      constantUsersPerSec(1) during(40), //立刻注入一个用户 等同于起线程
//  //      constantUsersPerSec(1) during(20),
//  //      constantUsersPerSec(20) during(60) randomized,
//  //      rampUsersPerSec(20) to (40) during(60),
//  //      constantUsersPerSec(40) during(100) randomized,
//  //      atOnceUsers(1)).protocols(httpProtocol)
//  //  )
//  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}
