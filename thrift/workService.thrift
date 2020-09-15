namespace java com.thrift.demo

//引用外部文件
include "work.thrift"

service DoWork {
   void ping(),
   //引用外部对象要加前缀
   string doWork(1:work.Work work)
}